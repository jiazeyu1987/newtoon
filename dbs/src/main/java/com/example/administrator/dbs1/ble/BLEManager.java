package com.example.administrator.dbs1.ble;

import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.ParcelUuid;
import android.os.Parcelable;

import com.example.administrator.dbs1.my_utils.PermissionUtils;
import com.example.administrator.dbs1.ble.btsmart.BtSmartService;
import com.google.gson.Gson;

import java.util.UUID;

public class BLEManager {

    public BluetoothDevice mDeviceToConnect = null;
    public static BtSmartService mService = null; // 蓝牙服务
    public  DeviceHandler mDeviceHandler ;
    private static final int CONNECT_TIMEOUT_MILLIS = 10000;
    public static final String DEVICE_TO_CONNECT = "deviec_to_connect_4323";
    public static final String BLE_PREF = "ble_pre_3234";
    Gson gson = null;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    public Handler mElectrodeHandler;
    boolean bind_service = false;
    private Activity mContext;
    boolean ACCESS_FINE_LOCATION_FLAG,ACCESS_COARSE_LOCATION_FLAG = false;
    MyCallbackInterface callback;

    public interface MyCallbackInterface {
        public void onBleReturnValue(byte[] values);
    }



    public boolean is_connected() {
        return _connected;
    }

    public void set_connected(boolean _connected) {
        this._connected = _connected;
    }

    private boolean _connected = false;
    public BLEManager(Activity context,MyCallbackInterface callback1){
        mContext = context;
        gson = new Gson();
        pref = context.getSharedPreferences(BLEManager.BLE_PREF, context.MODE_PRIVATE);
        editor = pref.edit();
        editor.clear();
        editor.commit();
        mDeviceHandler = new DeviceHandler(context);
        mElectrodeHandler = new ElectrodeHandler(context);
        callback = callback1;
    }

    public void onCreate(){
        check_access_permission();
    }
    

    public void onResume(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                scan_ble();
            }
        },1000);
    }

    private void onResumeWithoutCheckPermission(){
        init_basic(true);
        if(this.is_connected()==false){
            do_connect();
        }
    }

    public void onPause(){
        init_basic(false);
    }

    private PermissionUtils.PermissionGrant mPermissionGrant = new PermissionUtils.PermissionGrant() {
        @Override
        public void onPermissionGranted(int requestCode) {
            switch (requestCode) {
                case PermissionUtils.CODE_ACCESS_FINE_LOCATION:
                    ACCESS_FINE_LOCATION_FLAG = true;
                    break;
                case PermissionUtils.CODE_ACCESS_COARSE_LOCATION:
                    ACCESS_COARSE_LOCATION_FLAG = true;
                    break;
                default:
                    break;
            }
        }
    };



    private void check_access_permission(){
        PermissionUtils.requestPermission(mContext, PermissionUtils.CODE_ACCESS_FINE_LOCATION, mPermissionGrant);
        PermissionUtils.requestPermission(mContext, PermissionUtils.CODE_ACCESS_COARSE_LOCATION, mPermissionGrant);
    }

    private void scan_ble(){
        if(ACCESS_FINE_LOCATION_FLAG&&ACCESS_COARSE_LOCATION_FLAG){
            onResumeWithoutCheckPermission();
        }else{
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    scan_ble();
                }
            },1000);
        }
    }


    private void init_basic(boolean b){
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(CMD_code.BLUE_CONNECT_OK);  // cycle was delivered
        intentFilter.addAction(CMD_code.BLUE_CONNECT_FAIL);
        intentFilter.addAction(CMD_code.BLUE_RECEIVE_DATA);
        intentFilter.addAction(CMD_code.SEND_DATA);
        intentFilter.addAction(CMD_code.BLUE_RECEIVE_FAIL);
        if(b)
            mContext.registerReceiver(mReceiver, intentFilter);
        else
            mContext.unregisterReceiver(mReceiver);
    }

    private void do_connect(){

        String device_string = pref.getString(DEVICE_TO_CONNECT,"");
        if(device_string!=""){
            mDeviceToConnect = gson.fromJson(device_string,BluetoothDevice.class);
        }
        if(mDeviceToConnect==null) {
            Intent intent2 = new Intent(mContext, NewScanActivity.class);
            mContext.startActivity(intent2);
        }else{
            Intent bindIntent = new Intent(mContext, BtSmartService.class);
            mContext.bindService(bindIntent, mServiceConnection, Context.BIND_AUTO_CREATE);
            bind_service = true;
            showAlertDialog(true);
            mDeviceHandler.postDelayed(onReConnectFail, CONNECT_TIMEOUT_MILLIS);
        }
    }

    private AlertDialog.Builder builder1;
    private AlertDialog alert11;
    private void showAlertDialog(boolean flag) {
        if(alert11==null){
            builder1 = new AlertDialog.Builder(mContext);
            builder1.setTitle("等待响应...");
            builder1.setMessage("连接蓝牙设备中...请耐心等待响应!!!");
            builder1.setCancelable(true);
            alert11 = builder1.create();
        }
        if(flag){
            alert11.show();
        }else{
            alert11.dismiss();
        }

    }

    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) { // ������������ź�
            on_receive_action(intent);
        }
    };

    private void on_receive_action(Intent intent){
        final String action = intent.getAction(); //An intent is an abstract description of an
        // operation to be performed. Its most significant use is in the launching of
        // activities, where it can be thought of as the glue between activities. It is
        // basically a passive data structure holding an abstract description of an action to
        // be performed.
        showAlertDialog(false);
        if (action.equals(CMD_code.BLUE_CONNECT_OK)) {
            set_connect_state(true);
        }
        else if(action.equals(CMD_code.BLUE_CONNECT_FAIL)){
            set_connect_state(false);
        }
        else if(action.equals(CMD_code.BLUE_RECEIVE_DATA)){
            on_receive_data(intent.getExtras());
        }else if(action.equals(CMD_code.BLUE_RECEIVE_FAIL)){
            on_receive_fail();
        }
        else if(action.equals(CMD_code.SEND_DATA)){
            on_send_data(intent.getStringExtra("send_data"));
        }
    }

    private void set_connect_state(boolean b){
        set_connected(b);
    };
    private void on_receive_fail(){}
    private void on_receive_data(Bundle msgExtra){
        if(msgExtra == null)
            return;
        Parcelable par = msgExtra.getParcelable(BtSmartService.EXTRA_SERVICE_UUID);
        if(par==null)
            return;
        UUID serviceUuid = ((ParcelUuid)par ).getUuid();
        UUID characteristicUuid =
                ((ParcelUuid) msgExtra.getParcelable(BtSmartService.EXTRA_CHARACTERISTIC_UUID)).getUuid();
        byte[] values = msgExtra.getByteArray(BtSmartService.EXTRA_VALUE);
        int[] values1 = calcUnsignedIntValues(values);
        String temp = "";
        for(int i = 0 ; i < values1.length; i++) {
            temp += Integer.toHexString(values1[i]) + " ";
        }
        if(serviceUuid.compareTo(BtSmartService.BtSmartUuid.DEVICE_INFORMATION_SERVICE.getUuid()) == 0){
            callback.onBleReturnValue(values);
        }
    }

    private int[] calcUnsignedIntValues(byte[] bytesValues) {
        int length = bytesValues.length;
        int[] intValues = new int[length];
        for (int i = 0; i < length; i++) {
            intValues[i] = bytesValues[i] < 0 ? bytesValues[i] + 256 : bytesValues[i];
        }

        return intValues;
    }

    private void on_send_data(String msgExtra){}

    private Runnable onReConnectFail = new Runnable() { // 定时器的线程
        @Override
        public void run() {
            try {
                showAlertDialog(false);
            } catch(Exception e) {
            }
        }
    };

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder rawBinder) {
            mService = ((BtSmartService.LocalBinder) rawBinder).getService();
            if (mService != null) {
                // We have a connection to BtSmartService so now we can connect and register the device handler.
                mService.connectAsClient(mDeviceToConnect, mDeviceHandler); // 这里连上BtSmartService,并指定Handler
                //startConnectTimer(); // 启动一个定时器, 一段时间连不上就不连，如果连上，就把这个定时器删除
            }
        }

        public void onServiceDisconnected(ComponentName classname) {
            mService = null;
        }
    };

    private byte[] calcByteValues(int[] intValues) {
        int iLen = intValues.length;
        byte[] byteValues = new byte[iLen*2];
        for (int i = 0; i < iLen; i++) {
            byteValues[i*2] = (byte) (intValues[i]>>4);
            byteValues[i*2+1] = (byte) (intValues[i]&0x0F);
        }

        return byteValues;
    }

    public String write_with_read(int[] values){
        String s1 = "";
        for(int i = 0 ; i < values.length;i++){
            s1 = s1+Integer.toHexString(values[i]);
            s1 = s1+" ";
        }

        Intent intent = new Intent();
        intent.setAction(CMD_code.SEND_DATA);
        intent.putExtra("send_data",s1);
        mContext.sendBroadcast(intent);

        mService.writeCharacteristicValue(CMD_code.REQUEST_SET_PARAMETERS, BtSmartService.BtSmartUuid.HRP_SERVICE.getUuid(),
                BtSmartService.BtSmartUuid.HEART_RATE_SET_PARAMETERS.getUuid(), calcByteValues(values), mElectrodeHandler);
        mService.requestCharacteristicValue(CMD_code.REQUEST_HEART_RATE, BtSmartService.BtSmartUuid.DEVICE_INFORMATION_SERVICE.getUuid(), BtSmartService.BtSmartUuid.HEART_RATE_MEASUREMENT_11.getUuid(), mElectrodeHandler);
        return s1;
    }


}

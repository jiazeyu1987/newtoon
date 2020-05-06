package com.example.administrator.new_ptns.ble;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.example.administrator.new_ptns.ble.btsmart.BtSmartService;

class DeviceHandler extends Handler {

    final private Context _context;
    public DeviceHandler(Context activity) {
        _context = activity;
    }

    @Override
    public void handleMessage(Message msg) {
        int i = 1;


        //SpannableStringBuilder biggerText = new SpannableStringBuilder("");
        switch (msg.what) { // User-defined message code so that the recipient can identify what this message is about.
            case BtSmartService.MESSAGE_CONNECTED: {
                Intent intent = new Intent();
                Toast.makeText(_context,"蓝牙连接成功",Toast.LENGTH_LONG).show();
                intent.setAction(CMD_code.BLUE_CONNECT_OK);
                _context.sendBroadcast(intent);
                break;
            }
            case BtSmartService.MESSAGE_DISCONNECTED: {
                Intent intent = new Intent();
                intent.setAction(CMD_code.BLUE_CONNECT_FAIL);
                _context.sendBroadcast(intent);
                break;
            }
        }
    }
}

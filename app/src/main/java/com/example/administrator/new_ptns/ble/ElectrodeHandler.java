package com.example.administrator.new_ptns.ble;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.administrator.new_ptns.ble.btsmart.BtSmartService;

public class ElectrodeHandler extends Handler {
    final private Context _context;

    public ElectrodeHandler(Context context) {
        _context = context;
    }

    public void handleMessage(Message msg) {
//            SpannableStringBuilder biggerText = new SpannableStringBuilder("");

        // this will print the msg
        //String message = Integer.toString(msg.what);
        //Log.wtf("msg.what", message);
        // added by Jason, 3/19/2018
        String temp = "";
        //temp += message + "\n";

        switch (msg.what) {
            case BtSmartService.MESSAGE_REQUEST_FAILED: { // 发了请求消息，为什么会连不上呢？
                Intent intent = new Intent();
                intent.setAction(CMD_code.BLUE_RECEIVE_FAIL);
                _context.sendBroadcast(intent);
            }
            case BtSmartService.MESSAGE_CHARACTERISTIC_VALUE: { // 在这里更新页面？
                Bundle msgExtra = msg.getData(); // comments added by Tedd, 往服务器写完数据，则在这里处理后续页面更新

                Intent intent = new Intent();
                intent.setAction(CMD_code.BLUE_RECEIVE_DATA);
                intent.putExtras(msgExtra);
                _context.sendBroadcast(intent);
            }
            case BtSmartService.MESSAGE_WRITE_COMPLETE: {

            }
            default:
                break;
        }
//            closeAlertDialog();
    }
}
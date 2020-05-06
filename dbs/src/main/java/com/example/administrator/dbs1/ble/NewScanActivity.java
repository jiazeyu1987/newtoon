/******************************************************************************
 *  Copyright (C) Cambridge Silicon Radio Limited 2014
 *
 *  This software is provided to the customer for evaluation
 *  purposes only and, as such early feedback on performance and operation
 *  is anticipated. The software source code is subject to change and
 *  not intended for production. Use of developmental release software is
 *  at the user's own risk. This software is provided "as is," and CSR
 *  cautions users to determine for themselves the suitability of using the
 *  beta release version of this software. CSR makes no warranty or
 *  representation whatsoever of merchantability or fitness of the product
 *  for any particular purpose or use. In no event shall CSR be liable for
 *  any consequential, incidental or special damages whatsoever arising out
 *  of the use of or inability to use this software, even if the user has
 *  advised CSR of the possibility of such damages.
 *
 ******************************************************************************/

package com.example.administrator.dbs1.ble;


import android.bluetooth.BluetoothDevice;
import android.content.SharedPreferences;

import com.example.administrator.dbs1.ble.btsmart.BtSmartService;
import com.google.gson.Gson;

import java.util.UUID;


public class NewScanActivity extends ScanResultsActivity {
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    @Override
    protected void connectBluetooth(BluetoothDevice deviceToConnect) {
        Gson gson = new Gson();
        pref = this.getSharedPreferences(BLEManager.BLE_PREF, MODE_PRIVATE);
        editor = pref.edit();
        String anme1 = gson.toJson(deviceToConnect);
        editor.putString(BLEManager.DEVICE_TO_CONNECT, anme1);
        editor.commit();
        finish();
    }

    @Override
    protected UUID[] uuidFilter() {
        UUID[] filter = { BtSmartService.BtSmartUuid.HRP_SERVICE.getUuid() };
        return filter;
    }

}

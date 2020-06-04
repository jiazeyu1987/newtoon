package com.example.administrator.new_ptns;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Title3Activity extends BaseActivity {
    public TextView tv_time;
    public TextView login_user;
    public TextView logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public void init_title(){
        //123111
        tv_time = findViewById(R.id.textView88);
        login_user = findViewById(R.id.textView90);
        logout = findViewById(R.id.btn_return);
        tv_time.setText(G.g_date+"   "+G.g_xingqi);
        login_user.setText("doctor:"+G.doctor_id);
    }





}

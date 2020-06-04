package com.example.administrator.dbs1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Bundle;


public class SlashActivity extends BaseActivity {
    public static  boolean SLASH = true;
    public static  boolean OFFLINE = true;
    public static  boolean AUTO_CONNECT = false;
    public static  boolean REMEMBER_LAST = true;

    public static  boolean EMode = false;
    public static  int start_page = 6;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slash);
        init();
    }

    private void init(){
        pref = this.getSharedPreferences("EActivity", MODE_PRIVATE);
        editor = pref.edit();
        if(REMEMBER_LAST==false){
            editor.clear();
            editor.commit();
        }

        boolean slash1 = pref.getBoolean("slash",false);
        boolean offline1 = pref.getBoolean("offline",false);
        boolean auto1 = pref.getBoolean("auto",false);
        boolean emode1 = pref.getBoolean("emode",false);
        int si = pref.getInt("start_index",4);
        SlashActivity.SLASH = false;
        SlashActivity.EMode = emode1;
        SlashActivity.OFFLINE = true;
        SlashActivity.AUTO_CONNECT = auto1;
        SlashActivity.start_page = si;
        if(SLASH){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SlashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            },1000);
        }else{
            Intent intent = new Intent(SlashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}

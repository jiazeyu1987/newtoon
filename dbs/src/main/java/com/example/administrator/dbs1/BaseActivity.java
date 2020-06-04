package com.example.administrator.dbs1;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity {
    public static final String[] PERMISSION_TAKE_PICTURE = {"android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    public static final String[] PERMISSION_TAKE_VIDEO = {"android.permission.CAMERA", "android.permission.RECORD_AUDIO", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    public static final String[] PERMISSION_STORAGE = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    /**
     * Request permission.
     */
    public void requestPermission(String[] permissions, int code) {
        if (Build.VERSION.SDK_INT >= 23) {
            List<String> deniedPermissions = getDeniedPermissions(this, permissions);
            if (deniedPermissions.isEmpty()) {
                onPermissionGranted(code);
            } else {
                permissions = new String[deniedPermissions.size()];
                deniedPermissions.toArray(permissions);
                ActivityCompat.requestPermissions(this, permissions, code);
            }
        } else {
            onPermissionGranted(code);
        }
    }

    @Override
    public final void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (isGrantedResult(grantResults)) onPermissionGranted(requestCode);
        else onPermissionDenied(requestCode);
    }

    protected void onPermissionGranted(int code) {
    }

    protected void onPermissionDenied(int code) {
    }



    private static List<String> getDeniedPermissions(Context context, String... permissions) {
        List<String> deniedList = new ArrayList<>(2);
        for (String permission : permissions) {
            if (PermissionChecker.checkSelfPermission(context, permission) != PermissionChecker.PERMISSION_GRANTED) {
                deniedList.add(permission);
            }
        }
        return deniedList;
    }

    private static boolean isGrantedResult(int... grantResults) {
        for (int result : grantResults) {
            if (result == PackageManager.PERMISSION_DENIED) return false;
        }
        return true;
    }


    public void showToast(String s1){
        Toast.makeText(this,s1,Toast.LENGTH_LONG).show();
    }



}

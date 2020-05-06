package com.example.administrator.new_ptns;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.new_ptns.ble.BLEManager;
import com.example.administrator.new_ptns.custom_item.CustomItemA1;
import com.example.administrator.new_ptns.history_data.HistoryDao;
import com.example.administrator.new_ptns.history_data.HistoryData;
import com.example.administrator.new_ptns.my_utils.BitmapUtils;
import com.example.administrator.new_ptns.my_utils.PermissionUtils;
import com.example.administrator.new_ptns.pager.MyPagerAdapter;
import com.example.administrator.new_ptns.pager.user.PagerUserItem;
import com.example.administrator.new_ptns.pager.user.UserDao;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.util.AlbumUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity {

    public CustomItemA1 ci1_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);
    }

//    $ git config --global user.name "jiazeyu1987"
//    $ git config --global user.email "252451895@qq.com"
//$ ssh-keygen -t rsa -C "252451895@qq.com"
//git remote add origin https://github.com/jiazeyu1987/newtoon.git

}


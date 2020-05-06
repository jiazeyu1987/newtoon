package com.example.administrator.new_ptns.pager;

import android.view.View;
import android.widget.Toast;

import com.example.administrator.new_ptns.MainActivity;

import java.util.HashMap;

public class PagerBase {
    public MainActivity mContext;
    public View mView;
    public PagerBase(MainActivity context){
        mContext = context;
    }
    public void showToast(String s1){
        Toast.makeText(mContext,s1,Toast.LENGTH_LONG).show();
    }
    public void init_view(View view, String v){
        mView = view;
    }
}

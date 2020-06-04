package com.example.administrator.dbs1.pager;

import android.view.View;
import android.widget.Toast;

import com.example.administrator.dbs1.MainActivity;

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

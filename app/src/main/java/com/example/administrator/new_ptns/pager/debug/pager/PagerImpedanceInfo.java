package com.example.administrator.new_ptns.pager.debug.pager;

import android.view.View;

import com.example.administrator.new_ptns.pager.debug.DailyDebugActivity;
import com.example.administrator.new_ptns.pager.shuzhong.OperationTestingActivity;


public class PagerImpedanceInfo {
    public DailyDebugActivity mContext;
    public View mView;

    public PagerImpedanceInfo(DailyDebugActivity context){
        mContext = context;
    }

    public void init_view(View view){
        mView = view;

    }

    public void onResume(){

    }



}

package com.example.administrator.new_ptns.pager.shuzhong.pager;

import android.view.View;

import com.example.administrator.new_ptns.MainActivity;
import com.example.administrator.new_ptns.pager.PagerBase;
import com.example.administrator.new_ptns.pager.shuzhong.OperationTestingActivity;


public class PagerReportPreview {

    public OperationTestingActivity mContext;
    public View mView;

    public PagerReportPreview(OperationTestingActivity context){
        mContext = context;
    }

    public void init_view(View view){
        mView = view;

    }

    public void onResume(){

    }


}

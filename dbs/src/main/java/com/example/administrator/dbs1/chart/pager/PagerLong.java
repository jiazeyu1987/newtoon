package com.example.administrator.dbs1.chart.pager;

import android.view.View;

import com.example.administrator.dbs1.chart.ChartManagerActivity;


public class PagerLong {

    public ChartManagerActivity mContext;
    public View mView;
    public PagerLong(ChartManagerActivity context){

        mContext = context;
    }


    public void init_view(View view,String type){
        mView = view;

    }


}

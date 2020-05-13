package com.example.administrator.new_ptns.pager.debug;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.new_ptns.pager.debug.pager.PagerCurrentParas;
import com.example.administrator.new_ptns.pager.debug.pager.PagerImpedanceInfo;
import com.example.administrator.new_ptns.pager.debug.pager.PagerStimDebug;
import com.example.administrator.new_ptns.pager.shuzhong.OperationTestingActivity;
import com.example.administrator.new_ptns.pager.shuzhong.pager.PagerBasicInfo;
import com.example.administrator.new_ptns.pager.shuzhong.pager.PagerFunctionDetection;
import com.example.administrator.new_ptns.pager.shuzhong.pager.PagerReportPreview;

import java.util.List;

public class DailyDebugAdapter extends PagerAdapter {

    private List<View> viewList;
    private List<Integer> drawableList;
    private Context context;
    public PagerCurrentParas pagerCurrentParas;
    public PagerImpedanceInfo pagerImpedanceInfo;
    public PagerStimDebug pagerStimDebug;
    public DailyDebugAdapter() {

    }
    public DailyDebugAdapter(DailyDebugActivity ct, List<View> viewList, List<Integer> drawableList) {
        this.viewList = viewList;
        this.drawableList = drawableList;
        context = ct;
        pagerCurrentParas = new PagerCurrentParas(ct);
        pagerImpedanceInfo = new PagerImpedanceInfo(ct);
        pagerStimDebug = new PagerStimDebug(ct);
    }

    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = viewList.get(position);
        if(position==2){
            pagerStimDebug.init_view(view);
        }
        if(position==1){
            pagerCurrentParas.init_view(view);
        }
        if(position==0){
            pagerImpedanceInfo.init_view(view);
        }
        container.addView(view);
        return view;
    }

    public void onResume(int index){
        if(index==2){
            pagerStimDebug.onResume();
        }
        if(index==1){
            pagerCurrentParas.onResume();
        }
        if(index==0){
            pagerImpedanceInfo.onResume();
        }
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(viewList.get(position));
    }
}
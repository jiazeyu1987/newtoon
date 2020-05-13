package com.example.administrator.new_ptns.pager.shuzhong;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.new_ptns.MainActivity;
import com.example.administrator.new_ptns.pager.debug.PagerDebug;
import com.example.administrator.new_ptns.pager.patient_info.PagerPatientInfo;
import com.example.administrator.new_ptns.pager.shuqian.PagerShuqian;
import com.example.administrator.new_ptns.pager.shuzhong.pager.PagerBasicInfo;
import com.example.administrator.new_ptns.pager.shuzhong.pager.PagerFunctionDetection;
import com.example.administrator.new_ptns.pager.shuzhong.pager.PagerReportPreview;

import java.util.List;

public class OperationPagerAdapter extends PagerAdapter {

    private List<View> viewList;
    private List<Integer> drawableList;
    private Context context;
    public PagerBasicInfo pagerBasicInfo;
    public PagerFunctionDetection pagerFunctionDetection;
    public PagerReportPreview pagerReportPreview;
    public OperationPagerAdapter() {

    }
    public OperationPagerAdapter(OperationTestingActivity ct, List<View> viewList, List<Integer> drawableList) {
        this.viewList = viewList;
        this.drawableList = drawableList;
        context = ct;
        pagerBasicInfo = new PagerBasicInfo(ct);
        pagerFunctionDetection = new PagerFunctionDetection(ct);
        pagerReportPreview = new PagerReportPreview(ct);
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
            pagerReportPreview.init_view(view);
        }
        if(position==1){
            pagerFunctionDetection.init_view(view);
        }
        if(position==0){
            pagerBasicInfo.init_view(view);
        }
        container.addView(view);
        return view;
    }

    public void onResume(int index){
        if(index==2){
            pagerReportPreview.onResume();
        }
        if(index==1){
            pagerFunctionDetection.onResume();
        }
        if(index==0){
            pagerBasicInfo.onResume();
        }
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(viewList.get(position));
    }
}
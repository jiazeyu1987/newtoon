package com.example.administrator.new_ptns.chart;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.new_ptns.MainActivity;
import com.example.administrator.new_ptns.chart.pager.PagerLong;
import com.example.administrator.new_ptns.chart.pager.PagerNumber;
import com.example.administrator.new_ptns.pager.template.PagerTemplate;
import com.example.administrator.new_ptns.pager.timing.PagerTiming;
import com.example.administrator.new_ptns.pager.treatment.PagerTreatment;
import com.example.administrator.new_ptns.pager.user.PagerUser;

import java.util.List;

public class ChartPagerAdapter extends PagerAdapter {

    private List<View> viewList;
    private List<Integer> drawableList;
    private Context context;
    public PagerNumber pagerNumber;
    public PagerLong pagerLong;
    public ChartPagerAdapter() {

    }
    public ChartPagerAdapter(ChartManagerActivity ct, List<View> viewList, List<Integer> drawableList) {
        this.viewList = viewList;
        this.drawableList = drawableList;
        context = ct;
        pagerNumber = new PagerNumber(ct);
        pagerLong = new PagerLong(ct);
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
        if(position==1){
            pagerLong.init_view(view,"pagerLong");
        }
        if(position==0){
            pagerNumber.init_view(view,"pagerNumber");
        }
        container.addView(view);
        return view;
    }



    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(viewList.get(position));
    }
}
package com.example.administrator.new_ptns.pager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.new_ptns.MainActivity;
import com.example.administrator.new_ptns.pager.debug.PagerDebug;
import com.example.administrator.new_ptns.pager.patient_info.PagerPatientInfo;
import com.example.administrator.new_ptns.pager.shuqian.PagerShuqian;
import com.example.administrator.new_ptns.pager.shuzhong.PagerShuzhong;

import java.util.List;

public class MyPagerAdapter extends PagerAdapter {

    private List<View> viewList;
    private List<Integer> drawableList;
    private Context context;
    public PagerShuzhong pagerShuzhong;
    public PagerDebug pagerDebug;
    public PagerPatientInfo pagerPatientInfo;
    public PagerShuqian pagerShuqian;
    public MyPagerAdapter() {

    }
    public MyPagerAdapter(MainActivity ct, List<View> viewList, List<Integer> drawableList) {
        this.viewList = viewList;
        this.drawableList = drawableList;
        context = ct;
        //pagerUser = new PagerUser(ct);
        //pagerTiming = new PagerTiming(ct);
        //pagerTreatment = new PagerTreatment(ct);
        //pagerTemplate = new PagerTemplate(ct);
        pagerShuqian = new PagerShuqian(ct);
        pagerShuzhong = new PagerShuzhong(ct);
        pagerDebug = new PagerDebug(ct);
        pagerPatientInfo = new PagerPatientInfo(ct);
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
        if(position==3){
            pagerPatientInfo.init_view(view,"user");
        }
        if(position==2){
            pagerDebug.init_view(view,"timing");
        }
        if(position==1){
            pagerShuzhong.init_view(view,"pagerTemplate");
        }
        if(position==0){
            pagerShuqian.init_view(view,"shuqian");
        }
//        ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
//        imageView.setImageResource(drawableList.get(position));
//        TextView textView = (TextView) view.findViewById(R.id.text_view);
//        textView.setText(String.valueOf(position));
        container.addView(view);
        return view;
    }

    public void onResume(int index){
        if(index==2){
            pagerDebug.onResume();
        }
        if(index==1){
            pagerShuzhong.onResume();
        }
        if(index==0){
            pagerShuqian.onResume();
        }
        if(index==3){
            pagerPatientInfo.onResume();
        }
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(viewList.get(position));
    }
}
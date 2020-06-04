package com.example.administrator.new_ptns.pager.patient_info;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.new_ptns.MainActivity;
import com.example.administrator.new_ptns.R;
import com.example.administrator.new_ptns.custom_item.CustomItemA9;
import com.example.administrator.new_ptns.data_handler.DoublePatientData;
import com.example.administrator.new_ptns.data_handler.PatientData;

import java.util.ArrayList;

class PatientInfoAdapter extends BaseAdapter {
    private ArrayList<DoublePatientData> list  ;
    private MainActivity context = null;
    public PatientInfoAdapter(MainActivity context, ArrayList<DoublePatientData> list1) {
        this.context = context;
        list = list1;
    }
    @Override
    public int getCount() {
        return list.size();
    }
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }




    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder mHolder;
        if (convertView == null) {
            mHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.pager_nt_three_1_item, null, true);
            mHolder.ci90 = convertView.findViewById(R.id.pos0);
            mHolder.ci91 = convertView.findViewById(R.id.pos1);
            convertView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder) convertView.getTag();
        }
        PatientData data1 = list.get(position).p0;
        PatientData data2 = list.get(position).p1;
        mHolder.ci90.set_user_data(data1);
        mHolder.ci91.set_user_data(data2);

        mHolder.ci90.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.myPagerAdapter.pagerPatientInfo.onClickItem(list.get(position).p0);
            }
        });

        mHolder.ci91.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.myPagerAdapter.pagerPatientInfo.onClickItem(list.get(position).p1);
            }
        });
        return convertView;
    }

    class ViewHolder {
        private CustomItemA9 ci90;
        private CustomItemA9 ci91;
    }
}
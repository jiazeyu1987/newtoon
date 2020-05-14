package com.example.administrator.new_ptns.pager.patient_info;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.administrator.new_ptns.MainActivity;
import com.example.administrator.new_ptns.R;
import com.example.administrator.new_ptns.custom_item.CustomItemA6;
import com.example.administrator.new_ptns.custom_item.CustomItemA9;
import com.example.administrator.new_ptns.data_handler.DoublePatientData;
import com.example.administrator.new_ptns.data_handler.ImpedanceData;
import com.example.administrator.new_ptns.data_handler.PatientData;

import java.util.ArrayList;

class ImpedanceHistoryAdapter extends BaseAdapter {
    private ArrayList<ImpedanceData> list  ;
    private ImpedanceHistoryActivity context = null;
    public ImpedanceHistoryAdapter(ImpedanceHistoryActivity context, ArrayList<ImpedanceData> list1) {
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
            convertView = inflater.inflate(R.layout.pager_nt_three_5_item1, null, true);
            mHolder.ci90 = convertView.findViewById(R.id.cia1);
            mHolder.ci91 = convertView.findViewById(R.id.cia2);
            convertView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder) convertView.getTag();
        }
        ArrayList<String> data1 = list.get(position).leftImpedanceList;
        ArrayList<String> data2 = list.get(position).rightImpedanceList;
        mHolder.ci90.setValue(data1);
        mHolder.ci90.setTitleText("左脑");
        mHolder.ci91.setValue(data2);
        mHolder.ci91.setTitleText("右脑");

        return convertView;
    }

    class ViewHolder {
        private CustomItemA6 ci90;
        private CustomItemA6 ci91;
    }
}
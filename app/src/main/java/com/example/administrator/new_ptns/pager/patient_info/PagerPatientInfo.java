package com.example.administrator.new_ptns.pager.patient_info;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.blankj.utilcode.util.ToastUtils;
import com.example.administrator.new_ptns.MainActivity;
import com.example.administrator.new_ptns.R;
import com.example.administrator.new_ptns.data_handler.DoublePatientData;
import com.example.administrator.new_ptns.data_handler.PatientData;
import com.example.administrator.new_ptns.pager.PagerBase;
import com.google.gson.Gson;

import java.util.ArrayList;


public class PagerPatientInfo extends PagerBase {

    ListView listView;
    PatientInfoAdapter adapter;
    ArrayList<PatientData> list0;
    ArrayList<DoublePatientData> list1;
    public PagerPatientInfo(MainActivity context){
        super(context);
    }

    @Override
    public void init_view(View view,String type){
        super.init_view(view,type);

        list0 = PatientData.get_test_data();
        list1 = getDoubleArrayList(list0);
        listView = mView.findViewById(R.id.listview2);
        adapter = new PatientInfoAdapter(mContext,list1);
        listView.setAdapter(adapter);

    }

    public void onClickItem(PatientData data){
        Gson gson = new Gson();
        String s1 = gson.toJson(data);
        Intent intent = new Intent(mContext,DetailPatientInfoActivity.class);
        intent.putExtra("extra",s1);
        mContext.startActivity(intent);
    }

    public ArrayList<DoublePatientData> getDoubleArrayList(ArrayList<PatientData> list_ori){
        ArrayList<DoublePatientData> list1 = new ArrayList<>();
        int len1 = list_ori.size();
        int len2 = (int)(len1/2);

        for(int i = 0 ; i < len2;i++){
            DoublePatientData doublePatientData = new DoublePatientData();
            doublePatientData.p0 = list_ori.get(i*2);
            doublePatientData.p1 = list_ori.get(i*2+1);
            list1.add(doublePatientData);
        }

        if(len1%2==1){
            DoublePatientData doublePatientData = new DoublePatientData();
            doublePatientData.p0 = list_ori.get(list_ori.size()-1);
            list1.add(doublePatientData);
        }
        return list1;
    }

    public void onResume(){

    }



}

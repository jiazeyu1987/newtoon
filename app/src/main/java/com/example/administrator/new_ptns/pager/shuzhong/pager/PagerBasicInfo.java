package com.example.administrator.new_ptns.pager.shuzhong.pager;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.new_ptns.G;
import com.example.administrator.new_ptns.MainActivity;
import com.example.administrator.new_ptns.R;
import com.example.administrator.new_ptns.custom_item.CustomItemA1p3;
import com.example.administrator.new_ptns.pager.PagerBase;
import com.example.administrator.new_ptns.pager.shuzhong.OperationTestingActivity;

import java.util.ArrayList;


public class PagerBasicInfo {
    public OperationTestingActivity mContext;
    public View mView;
    private TextView tv_name,tv_sex,tv_age;
    public CustomItemA1p3 stim,electrode1,electrode2;
    public PagerBasicInfo(OperationTestingActivity context){
        mContext = context;
    }

    public void init_view(View view){
        mView = view;
        tv_name = mView.findViewById(R.id.textView92);
        tv_sex = mView.findViewById(R.id.textView93);
        tv_age = mView.findViewById(R.id.textView95);

        tv_name.setText("姓名:"+mContext.contactData.patient_name);
        tv_sex.setText("性别:"+mContext.contactData.sex);
        tv_age.setText("年龄:"+mContext.contactData.getAge());

        stim = mView.findViewById(R.id.sdfafa1);
        electrode1 = mView.findViewById(R.id.afasdfas2);
        electrode2 = mView.findViewById(R.id.afasdfas3);
        ArrayList<String> arrayList = new ArrayList<>();
        if(G.electrodeBundle1!=null){
            arrayList.add(G.electrodeBundle1.get_position());
        }
        if(G.electrodeBundle2!=null){
            arrayList.add(G.electrodeBundle2.get_position());
        }
        arrayList.add("/");
        electrode1.setDatalist("请选择植入位置",(String[]) arrayList.toArray(new String[arrayList.size()]));
        electrode2.setDatalist("请选择植入位置",(String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public void onResume(){

    }



}

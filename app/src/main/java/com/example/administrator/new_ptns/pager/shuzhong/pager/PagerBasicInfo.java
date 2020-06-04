package com.example.administrator.new_ptns.pager.shuzhong.pager;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
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
    Button ele1,ele2;
    String title_ele;
    String[] strlist1;
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
        if(G.g_patient_data.latest_patientOperationData.electrodeBundle1!=null){
            arrayList.add(G.g_patient_data.latest_patientOperationData.electrodeBundle1.get_position());
        }
        if(G.g_patient_data.latest_patientOperationData.electrodeBundle2!=null){
            arrayList.add(G.g_patient_data.latest_patientOperationData.electrodeBundle2.get_position());
        }
        arrayList.add("None");
        title_ele = "请选择植入位置";
        ele1 = electrode1.findViewById(R.id.button22);
        ele2 = electrode2.findViewById(R.id.button22);
        strlist1 = (String[]) arrayList.toArray(new String[arrayList.size()]);
        ele1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Context c1 = mContext;
                AlertDialog.Builder builder = new AlertDialog.Builder(c1);
                builder.setTitle(title_ele);
                builder.setCancelable(true);
                builder.setIcon(R.mipmap.ic_launcher)
                        .setItems(strlist1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String val1 = strlist1[which];
                                if(val1.equals("None")){
                                    G.g_patient_data.latest_patientOperationData.position1 = null;
                                }else if(val1 == G.g_patient_data.latest_patientOperationData.electrodeBundle1.get_position()){
                                    G.g_patient_data.latest_patientOperationData.position1 = G.g_patient_data.latest_patientOperationData.electrodeBundle1;
                                }else if(val1 == G.g_patient_data.latest_patientOperationData.electrodeBundle2.get_position()){
                                    G.g_patient_data.latest_patientOperationData.position1 = G.g_patient_data.latest_patientOperationData.electrodeBundle2;
                                }else{
                                    new Exception("FFFFFFFFFFFFF");
                                }
                                ele1.setText(val1);
                            }
                        }).create()
                        .show();
            }
        });

        ele2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Context c1 = mContext;
                AlertDialog.Builder builder = new AlertDialog.Builder(c1);
                builder.setTitle(title_ele);
                builder.setCancelable(true);
                builder.setIcon(R.mipmap.ic_launcher)
                        .setItems(strlist1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String val1 = strlist1[which];
                                if(val1.equals("None")){
                                    G.g_patient_data.latest_patientOperationData.position2 = null;
                                }else if(val1 == G.g_patient_data.latest_patientOperationData.electrodeBundle1.get_position()){
                                    G.g_patient_data.latest_patientOperationData.position2 = G.g_patient_data.latest_patientOperationData.electrodeBundle1;
                                }else if(val1 == G.g_patient_data.latest_patientOperationData.electrodeBundle2.get_position()){
                                    G.g_patient_data.latest_patientOperationData.position2 = G.g_patient_data.latest_patientOperationData.electrodeBundle2;
                                }else{
                                    new Exception("FFFFFFFFFFFFF");
                                }
                                ele2.setText(val1);
                            }
                        }).create()
                        .show();
            }
        });

    }

    public void onResume(){

    }



}

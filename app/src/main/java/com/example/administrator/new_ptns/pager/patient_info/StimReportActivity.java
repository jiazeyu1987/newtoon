package com.example.administrator.new_ptns.pager.patient_info;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bin.david.form.core.SmartTable;
import com.example.administrator.new_ptns.R;
import com.example.administrator.new_ptns.Title3Activity;
import com.example.administrator.new_ptns.custom_item.CustomItemA2;
import com.example.administrator.new_ptns.data_handler.PatientData;
import com.example.administrator.new_ptns.data_handler.TableColumnInfoStimReport;
import com.example.administrator.new_ptns.my_utils.TimeUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StimReportActivity extends Title3Activity {

    @BindView(R.id.smartTableRight)
    SmartTable smartTableRight;
    @BindView(R.id.smartTableLeft)
    SmartTable smartTableLeft;

    ArrayList<TableColumnInfoStimReport> list1;
    @BindView(R.id.ci2_list)
    CustomItemA2 ci2List;
    @BindView(R.id.tv_patientname)
    TextView tvPatientname;
    @BindView(R.id.btn_return)
    TextView btnReturn;
    @BindView(R.id.btn_up)
    ImageView btnUp;
    @BindView(R.id.btn_down)
    ImageView btnDown;
    ArrayList<TableColumnInfoStimReport> newlist = new ArrayList<>();
    String[] limit_list = new String[]{"最近一年","最近一月","最近一周"};
    int limit_day = 3650;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stim_report);
        ButterKnife.bind(this);
        init_false_data();
        init_ui();
        fresh_ui();
        Intent intent = getIntent();
        String patient_string = intent.getStringExtra("extra");
        Gson gson = new Gson();
        PatientData patientData = gson.fromJson(patient_string,PatientData.class);
        tvPatientname.setText(patientData.name);
        init_title();
    }

    private void fresh_new_list(){
        if(ci2List.getTitleText3()=="最近一年"){
            limit_day = 365;
        }else if(ci2List.getTitleText3()=="最近一月"){
            limit_day = 30;
        }else if(ci2List.getTitleText3()=="最近一周"){
            limit_day = 7;
        }else{

        }
        newlist = new ArrayList<>();
        for(int i = 0 ; i < list1.size();i++){
            TableColumnInfoStimReport column = list1.get(i);
            String date = column.getDate();
            String cudate = TimeUtils.getCurrentTimeYMD();
            long dayoff = TimeUtils.getDays(cudate,date);
            if(dayoff<limit_day){
                newlist.add(column);
            }
        }
    }

    private void init_ui(){
        ci2List.setValue3("最近一周");
        fresh_new_list();
        ci2List.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(StimReportActivity.this);
                builder.setTitle("请选择");
                builder.setCancelable(true);
                builder.setIcon(R.mipmap.ic_launcher)
                        .setItems(limit_list, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ci2List.setValue3(limit_list[which]);
                                fresh_new_list();
                                fresh_ui();
                            }
                        }).create()
                        .show();

            }
        });
    }

    private void init_false_data() {
        list1 = new ArrayList<>();
        list1.add(new TableColumnInfoStimReport("2020-2-2", "恒流", "3.5", "200", "90", "Basic Solution"));
        list1.add(new TableColumnInfoStimReport("2020-2-3", "恒流", "3.15", "210", "90", "Basic Solution"));
        list1.add(new TableColumnInfoStimReport("2020-5-28", "恒流", "3.25", "210", "90", "Basic Solution"));
        list1.add(new TableColumnInfoStimReport("2020-5-27", "恒流", "3.35", "230", "190", "Basic Solution"));
        list1.add(new TableColumnInfoStimReport("2020-5-3", "恒流", "3.45", "240", "90", "Basic Solution"));
        list1.add(new TableColumnInfoStimReport("2020-5-4", "恒流", "3.55", "250", "90", "Basic Solution"));

    }

    private void fresh_ui() {



        smartTableLeft.setData(newlist);
        smartTableRight.setData(newlist);
    }

    @OnClick({R.id.ci2_list, R.id.btn_return, R.id.btn_up, R.id.btn_down})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ci2_list:
                break;
            case R.id.btn_return:
                break;
            case R.id.btn_up:
                Collections.sort(newlist);
                Collections.reverse(newlist);
                fresh_ui();
                break;
            case R.id.btn_down:
                Collections.sort(newlist);
                fresh_ui();
                break;
        }
    }
}

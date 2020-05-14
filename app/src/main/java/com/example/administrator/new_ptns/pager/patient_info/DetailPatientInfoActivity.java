package com.example.administrator.new_ptns.pager.patient_info;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.new_ptns.R;
import com.example.administrator.new_ptns.data_handler.PatientData;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailPatientInfoActivity extends AppCompatActivity {

    @BindView(R.id.listview3)
    ListView listview3;
    @BindView(R.id.pnt2_txt1)
    TextView pnt2Txt1;
    @BindView(R.id.pnt2_txt2)
    TextView pnt2Txt2;
    @BindView(R.id.pnt2_txt3)
    TextView pnt2Txt3;
    @BindView(R.id.pnt2_txt4)
    TextView pnt2Txt4;
    @BindView(R.id.pnt2_txt5)
    TextView pnt2Txt5;
    @BindView(R.id.pnt2_txt6)
    TextView pnt2Txt6;

    PatientData mPatientData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager_nt_three_2);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String s1 = intent.getStringExtra("extra");
        mPatientData = new Gson().fromJson(s1,PatientData.class);
        pnt2Txt1.setText("姓名："+mPatientData.name+"  性别："+mPatientData.sex+" 年龄:"+mPatientData.age+"岁");
        pnt2Txt2.setText("手机号码："+mPatientData.phone_number);
        pnt2Txt3.setText("家庭住址："+mPatientData.address+mPatientData.detail_address);
        pnt2Txt4.setText("序列号："+mPatientData.stim_number+"\n植入日期："+mPatientData.stim_embedded_date+"\n电池容量："+mPatientData.charging_percent+"%");
        pnt2Txt5.setText("序列号："+mPatientData.electrode1_number+"\n植入日期："+mPatientData.electrode1_date+"\n植入位置："+mPatientData.electorde1_position);
        pnt2Txt6.setText("序列号："+mPatientData.electrode2_number+"\n植入日期："+mPatientData.electrode2_date+"\n植入位置："+mPatientData.electorde2_position);
        pnt2Txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(DetailPatientInfoActivity.this,ImpedanceHistoryActivity.class);
                startActivity(intent1);
            }
        });
    }
}

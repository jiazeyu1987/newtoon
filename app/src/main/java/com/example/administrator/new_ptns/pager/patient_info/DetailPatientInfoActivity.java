package com.example.administrator.new_ptns.pager.patient_info;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.new_ptns.BaseActivity;
import com.example.administrator.new_ptns.R;
import com.example.administrator.new_ptns.data_handler.PatientData;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailPatientInfoActivity extends BaseActivity {

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
    @BindView(R.id.btn_stim_report)
    Button btnStimReport;
    @BindView(R.id.btn_impedance_report)
    Button btnImpedanceReport;
    @BindView(R.id.btn_operation_report)
    Button btnOperationReport;
    private String patient_string;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager_nt_three_2);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        patient_string = intent.getStringExtra("extra");
        mPatientData = new Gson().fromJson(patient_string, PatientData.class);
        pnt2Txt1.setText("姓名：" + mPatientData.name + "  性别：" + mPatientData.sex + " 年龄:" + mPatientData.age + "岁");
        pnt2Txt2.setText("手机号码：" + mPatientData.phone_number);
        pnt2Txt3.setText("家庭住址：" + mPatientData.address + mPatientData.detail_address);
        pnt2Txt4.setText("序列号：" + mPatientData.latest_patientOperationData.stim_number + "\n植入日期：" + mPatientData.latest_patientOperationData.stim_embedded_date + "\n电池容量：" + mPatientData.latest_patientOperationData.charging_percent + "%");
        pnt2Txt5.setText("序列号：" + mPatientData.latest_patientOperationData.electrodeBundle1.xuliehao + "\n植入日期：" + mPatientData.latest_patientOperationData.electrodeBundle1.date + "\n植入位置：" + mPatientData.latest_patientOperationData.electrodeBundle1.get_position());
        pnt2Txt6.setText("序列号：" + mPatientData.latest_patientOperationData.electrodeBundle2.xuliehao + "\n植入日期：" + mPatientData.latest_patientOperationData.electrodeBundle2.date + "\n植入位置：" + mPatientData.latest_patientOperationData.electrodeBundle2.get_position());
        pnt2Txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @OnClick({R.id.btn_stim_report, R.id.btn_impedance_report, R.id.btn_operation_report})
    public void onClick(View view) {
        Intent intent1=null;
        switch (view.getId()) {
            case R.id.btn_stim_report:
                intent1 = new Intent(DetailPatientInfoActivity.this,StimReportActivity.class);

                break;
            case R.id.btn_impedance_report:
                intent1 = new Intent(DetailPatientInfoActivity.this, ImpedanceHistoryActivity.class);
                break;
            case R.id.btn_operation_report:
                intent1 = new Intent(DetailPatientInfoActivity.this, ImpedanceHistoryActivity.class);
                break;
        }
        intent1.putExtra("extra",patient_string);
        startActivity(intent1);
    }
}

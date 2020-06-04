package com.example.administrator.new_ptns.pager.shuzhong;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.new_ptns.BaseActivity;
import com.example.administrator.new_ptns.G;
import com.example.administrator.new_ptns.R;
import com.example.administrator.new_ptns.data_handler.ContactData;
import com.example.administrator.new_ptns.data_handler.ElectrodeBundle;
import com.example.administrator.new_ptns.data_handler.PatientDao;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OperationTestingActivity extends BaseActivity {

    @BindView(R.id.btn_patient)
    Button btnPatient;
    @BindView(R.id.btn_detection)
    Button btnDetection;
    @BindView(R.id.btn_preview)
    Button btnPreview;
    @BindView(R.id.viewPager1)
    ViewPager viewPager1;
    @BindView(R.id.btn_return)
    TextView btnReturn;

    public String new_stim_name = "";
    public ContactData contactData = null;
    public ElectrodeBundle new_electrode1 = null;
    public ElectrodeBundle new_electrode2 = null;
    @BindView(R.id.btn_save)
    Button btnSave;
    private List<View> viewList = new ArrayList<>();
    public OperationPagerAdapter myPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation_testing);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        contactData = new Gson().fromJson(intent.getStringExtra("para1"), ContactData.class);

        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.pager_nt_one_1, null);
        viewList.add(view);
        view = inflater.inflate(R.layout.pager_nt_one_2, null);
        viewList.add(view);
        view = inflater.inflate(R.layout.pager_nt_one_3, null);
        viewList.add(view);

        myPagerAdapter = new OperationPagerAdapter(OperationTestingActivity.this, viewList, null);
        viewPager1.setAdapter(myPagerAdapter);
        if (G.TEST) {
            //btnPreview.performClick();
        }
    }

    @OnClick({R.id.btn_patient, R.id.btn_detection, R.id.btn_preview,R.id.btn_return,R.id.btn_save})
    public void onClick(View view) {
        btnPatient.setBackground(getResources().getDrawable(R.drawable.rect1));
        btnDetection.setBackground(getResources().getDrawable(R.drawable.rect1));
        btnPreview.setBackground(getResources().getDrawable(R.drawable.rect1));
        switch (view.getId()) {
            case R.id.btn_patient:
                btnPatient.setBackground(getResources().getDrawable(R.drawable.rect_blue));
                viewPager1.setCurrentItem(0);
                break;
            case R.id.btn_detection:
                btnDetection.setBackground(getResources().getDrawable(R.drawable.rect_blue));
                viewPager1.setCurrentItem(1);
                break;
            case R.id.btn_preview:
                btnPreview.setBackground(getResources().getDrawable(R.drawable.rect_blue));
                viewPager1.setCurrentItem(2);
                break;
            case R.id.btn_return:
                break;
            case R.id.btn_save:
                PatientDao patientDao = new PatientDao(this);
                G.modify_patient(patientDao,G.g_patient_data);
                finish();

                break;
            default:
                showToast("123");
        }
    }


}

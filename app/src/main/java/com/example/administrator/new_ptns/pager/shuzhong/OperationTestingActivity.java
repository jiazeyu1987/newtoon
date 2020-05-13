package com.example.administrator.new_ptns.pager.shuzhong;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.administrator.new_ptns.MainActivity;
import com.example.administrator.new_ptns.R;
import com.example.administrator.new_ptns.pager.MyPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OperationTestingActivity extends AppCompatActivity {

    @BindView(R.id.btn_patient)
    Button btnPatient;
    @BindView(R.id.btn_detection)
    Button btnDetection;
    @BindView(R.id.btn_preview)
    Button btnPreview;
    @BindView(R.id.viewPager1)
    ViewPager viewPager1;

    private List<View> viewList = new ArrayList<>();
    OperationPagerAdapter myPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation_testing);
        ButterKnife.bind(this);


        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.pager_nt_one_1, null);
        viewList.add(view);
        view = inflater.inflate(R.layout.pager_nt_one_2, null);
        viewList.add(view);
        view = inflater.inflate(R.layout.pager_nt_one_3, null);
        viewList.add(view);

        myPagerAdapter = new OperationPagerAdapter(OperationTestingActivity.this, viewList, null);
        viewPager1.setAdapter(myPagerAdapter);
    }

    @OnClick({R.id.btn_patient, R.id.btn_detection, R.id.btn_preview})
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
        }
    }
}

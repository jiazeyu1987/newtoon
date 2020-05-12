package com.example.administrator.new_ptns.pager.shuzhong;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.new_ptns.R;
import com.example.administrator.new_ptns.custom_item.CustomItemA4;
import com.example.administrator.new_ptns.custom_item.CustomItemA5;
import com.example.administrator.new_ptns.custom_item.CustomItemA6;
import com.example.administrator.new_ptns.custom_item.CustomItemA8;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OperationActivity extends AppCompatActivity {

    @BindView(R.id.btn_return)
    ImageView btnReturn;
    @BindView(R.id.bundle_impedance)
    CustomItemA6 bundleImpedance;
    @BindView(R.id.btn_testing)
    Button btnTesting;
    @BindView(R.id.channel_1)
    CustomItemA8 channel1;
    @BindView(R.id.channel_2)
    CustomItemA8 channel2;
    @BindView(R.id.channel_3)
    CustomItemA8 channel3;
    @BindView(R.id.channel_4)
    CustomItemA8 channel4;
    @BindView(R.id.btn_embedded_position)
    CustomItemA4 btnEmbeddedPosition;
    @BindView(R.id.btn_stop_stim)
    Button btnStopStim;
    @BindView(R.id.btn_save_para)
    Button btnSavePara;
    @BindView(R.id.btn_start_time)
    Button btnStartTime;
    @BindView(R.id.bundle_freq)
    CustomItemA5 bundleFreq;
    @BindView(R.id.bundle_pulse)
    CustomItemA5 bundlePulse;
    @BindView(R.id.bundle_range)
    CustomItemA5 bundleRange;
    @BindView(R.id.radio_voltage)
    RadioButton radioVoltage;
    @BindView(R.id.radio_current)
    RadioButton radioCurrent;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;

    public static final int CURRENT = 1;
    public static final int VOLTAGE = 2;
    private int current_mode = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nt_shuzhong_stim);
        ButterKnife.bind(this);

        radioGroup.check(R.id.radio_current);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.radio_current){
                    current_mode = CURRENT;
                    bundleRange.setPara(0,0.1f,1,0,11,"mA");
                }else{
                    current_mode = VOLTAGE;
                    bundleRange.setPara(0,0.1f,1,0,25,"V");
                }
            }
        });

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("0");
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");

        list1.add("5");
        list1.add("6");
        list1.add("7");
        list1.add("8");
        list1.add("9");

        list1.add("10");
        list1.add("11");
        list1.add("12");
        list1.add("13");
        list1.add("14");

        list1.add("15");
        list1.add("16");
        list1.add("17");
        list1.add("18");
        list1.add("19");
        bundleImpedance.setValue(list1);
    }

    @OnClick({R.id.btn_return, R.id.btn_testing, R.id.btn_embedded_position, R.id.btn_stop_stim, R.id.btn_save_para, R.id.btn_start_time})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_return:
                break;
            case R.id.btn_testing:
                break;
            case R.id.btn_embedded_position:
                break;
            case R.id.btn_stop_stim:
                break;
            case R.id.btn_save_para:
                break;
            case R.id.btn_start_time:
                break;
        }
    }
}

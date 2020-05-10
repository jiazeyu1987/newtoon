package com.example.administrator.new_ptns.pager.shuqian;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.new_ptns.BaseActivity;
import com.example.administrator.new_ptns.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PulseTestingActivity extends BaseActivity {
    @BindView(R.id.apt_electrode1_value)
    TextView aptElectrode1Value;
    @BindView(R.id.apt_electrode2_value)
    TextView aptElectrode2Value;
    @BindView(R.id.apt_contact_number_value)
    TextView aptContactNumberValue;
    @BindView(R.id.apt_operation_info)
    TextView aptOperationInfo;
    @BindView(R.id.apt_current_value)
    TextView aptCurrentValue;
    @BindView(R.id.apt_current_state)
    TextView aptCurrentState;
    @BindView(R.id.apt_voltage_value)
    TextView aptVoltageValue;
    @BindView(R.id.apt_voltage_state)
    TextView aptVoltageState;
    @BindView(R.id.apt_impedance_value)
    TextView aptImpedanceValue;
    @BindView(R.id.apt_impedance_state)
    TextView aptImpedanceState;
    @BindView(R.id.apt_battery_voltage_value)
    TextView aptBatteryVoltageValue;
    @BindView(R.id.apt_battery_voltage_state)
    TextView aptBatteryVoltageState;
    @BindView(R.id.apt_battery_number_value)
    TextView aptBatteryNumberValue;
    @BindView(R.id.apt_battery_number_state)
    TextView aptBatteryNumberState;
    @BindView(R.id.apt_btn_testing)
    Button aptBtnTesting;
    @BindView(R.id.ani_btn_shutdown)
    Button aniBtnShutdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nt_pulse_testing);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.apt_btn_testing, R.id.ani_btn_shutdown})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.apt_btn_testing:
                break;
            case R.id.ani_btn_shutdown:
                break;
        }
    }
}

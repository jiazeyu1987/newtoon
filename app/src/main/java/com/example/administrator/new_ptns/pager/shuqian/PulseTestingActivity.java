package com.example.administrator.new_ptns.pager.shuqian;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
    @BindView(R.id.btn_return)
    ImageView btnReturn;

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
                SetProductInfo("123", "456", "789");
                SetChargingTestingInfo("`````````````````````````````");
                SetSystemTestingInfo("01", "11", "02", "12", "03", "13", "04", "14", "05", "15");
                break;
            case R.id.ani_btn_shutdown:
                break;
        }
    }

    private void SetProductInfo(String aptElectrode1Value1, String aptElectrode1Value2, String aptContactNumberValue1) {
        aptElectrode1Value.setText(aptElectrode1Value1);
        aptElectrode2Value.setText(aptElectrode1Value2);
        aptContactNumberValue.setText(aptContactNumberValue1);
    }

    private void SetChargingTestingInfo(String info) {
        aptOperationInfo.setText(info);
    }

    private void SetSystemTestingInfo(
            String aptCurrentValue1, String aptCurrentState1,
            String aptVoltageValue1, String aptVoltageState1,
            String aptImpedanceValue1, String aptImpedanceState1,
            String aptBatteryVoltageValue1, String aptBatteryVoltageState1,
            String aptBatteryNumberValue1, String aptBatteryNumberState1
    ) {
        aptCurrentValue.setText(aptCurrentValue1);
        aptCurrentState.setText(aptCurrentState1);
        aptVoltageValue.setText(aptVoltageValue1);
        aptVoltageState.setText(aptVoltageState1);
        aptImpedanceValue.setText(aptImpedanceValue1);
        aptImpedanceState.setText(aptImpedanceState1);
        aptBatteryVoltageValue.setText(aptBatteryVoltageValue1);
        aptBatteryVoltageState.setText(aptBatteryVoltageState1);
        aptBatteryNumberValue.setText(aptBatteryNumberValue1);
        aptBatteryNumberState.setText(aptBatteryNumberState1);
    }

    @OnClick(R.id.btn_return)
    public void onClick() {
        finish();
    }
}

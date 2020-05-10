package com.example.administrator.new_ptns.pager.shuqian;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.example.administrator.new_ptns.BaseActivity;
import com.example.administrator.new_ptns.R;
import com.example.administrator.new_ptns.custom_item.CustomItemA1;
import com.example.administrator.new_ptns.custom_item.CustomItemA2;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewContactActivity extends BaseActivity {
    @BindView(R.id.contact_number)
    CustomItemA1 contactNumber;
    @BindView(R.id.btn_return)
    ImageView btnReturn;
    @BindView(R.id.ani_name)
    CustomItemA1 aniName;
    @BindView(R.id.ani_idcard)
    CustomItemA1 aniIdcard;
    @BindView(R.id.ani_phone_number)
    CustomItemA1 aniPhoneNumber;
    @BindView(R.id.ani_address)
    CustomItemA1 aniAddress;
    @BindView(R.id.ani_detailaddress)
    CustomItemA1 aniDetailaddress;
    @BindView(R.id.ani_control_software)
    CustomItemA2 aniControlSoftware;
    @BindView(R.id.ani_electrode1)
    CustomItemA2 aniElectrode1;
    @BindView(R.id.ani_charging_coil)
    CustomItemA2 aniChargingCoil;
    @BindView(R.id.ani_electrode2)
    CustomItemA2 aniElectrode2;
    @BindView(R.id.ani_extra_info)
    CustomItemA1 aniExtraInfo;
    @BindView(R.id.ani_operation_date)
    CustomItemA2 aniOperationDate;
    @BindView(R.id.ani_operation_doctor)
    CustomItemA2 aniOperationDoctor;
    @BindView(R.id.ani_operation_machanism)
    CustomItemA2 aniOperationMachanism;
    @BindView(R.id.ani_department)
    CustomItemA2 aniDepartment;
    @BindView(R.id.ani_relative)
    CustomItemA1 aniRelative;
    @BindView(R.id.ani_relative_name)
    CustomItemA1 aniRelativeName;
    @BindView(R.id.ani_contact_phone_number)
    CustomItemA1 aniContactPhoneNumber;
    @BindView(R.id.ani_adviser_name)
    CustomItemA1 aniAdviserName;
    @BindView(R.id.ani_btn_shutdown)
    Button aniBtnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nt_contact_info);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_return)
    public void onClick() {
    }
}

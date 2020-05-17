package com.example.administrator.new_ptns.pager.shuqian;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.example.administrator.new_ptns.BaseActivity;
import com.example.administrator.new_ptns.R;
import com.example.administrator.new_ptns.custom_item.CustomItemA1;
import com.example.administrator.new_ptns.custom_item.CustomItemA2;
import com.example.administrator.new_ptns.data_handler.ContactDao;
import com.example.administrator.new_ptns.data_handler.ContactData;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.addapp.pickers.entity.City;
import cn.addapp.pickers.entity.County;
import cn.addapp.pickers.entity.Province;

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
    @BindView(R.id.ani_stimulator)
    CustomItemA2 aniStimulator;
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

    public static final int NEW = 0;
    public static final int MODIFY = 1;
    public static final int VIEW = 2;
    public static final String INTENT_CONTACT_STATE = "CONTACT_STATE";
    public static final String INTENT_CONTACT_JSON = "CONTACT_STATE";
    public int state = VIEW;

    public ContactData mContact = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nt_contact_info);
        ButterKnife.bind(this);
        Utils.init(this);
        Intent intent = getIntent();
        state = intent.getIntExtra(INTENT_CONTACT_STATE, NEW);
        fresh_state();
    }

    private void fresh_state() {
        if (state == NEW) {
            mContact = new ContactData();
        } else {
            Intent intent = getIntent();
            mContact = new Gson().fromJson(intent.getStringExtra(INTENT_CONTACT_JSON), ContactData.class);

            contactNumber.setTitleText3(mContact.contact_number);

            aniName.setTitleText3(mContact.patient_name);
            aniIdcard.setTitleText3(mContact.id_card);
            aniPhoneNumber.setTitleText3(mContact.phone_number);
            aniAddress.setTitleText3(mContact.address);
            aniDetailaddress.setTitleText3(mContact.detail_address);

            aniOperationMachanism.setTitleText3(mContact.operation_machanism);
            aniOperationDoctor.setTitleText3(mContact.operation_doctor);
            aniOperationDate.setTitleText3(mContact.operation_date);
            aniDepartment.setTitleText3(mContact.department);

            aniStimulator.setTitleText3(mContact.stimulator);
            aniElectrode1.setTitleText3(mContact.electrode1);
            aniElectrode2.setTitleText3(mContact.electrode2);
            aniControlSoftware.setTitleText3(mContact.stim_software);
            aniChargingCoil.setTitleText3(mContact.charging_coil);

            aniRelativeName.setTitleText3(mContact.relative_name);
            aniRelative.setTitleText3(mContact.relative);
            aniContactPhoneNumber.setTitleText3(mContact.relative_phone_number);

            aniExtraInfo.setTitleText3(mContact.extra);

            aniAdviserName.setTitleText3(mContact.adviser_info);
        }
    }


    @OnClick(R.id.ani_btn_shutdown)
    public void onClick() {
        mContact.contact_number = contactNumber.getTitleText3();

        mContact.patient_name = aniName.getTitleText3();
        mContact.id_card = aniIdcard.getTitleText3();
        mContact.sex = "男";
        mContact.phone_number = aniPhoneNumber.getTitleText3();
        mContact.address = aniAddress.getTitleText3();
        mContact.detail_address = aniAddress.getTitleText3();

        mContact.operation_machanism = aniOperationMachanism.getTitleText3();
        mContact.department = aniDepartment.getTitleText3();
        mContact.operation_doctor = aniDepartment.getTitleText3();
        mContact.operation_date = aniDepartment.getTitleText3();

        mContact.stimulator = aniStimulator.getTitleText3();
        mContact.electrode1 = aniElectrode1.getTitleText3();
        mContact.electrode2 = aniElectrode2.getTitleText3();
        mContact.stim_software = aniControlSoftware.getTitleText3();
        mContact.charging_coil = aniChargingCoil.getTitleText3();

        mContact.relative_name = aniRelativeName.getTitleText3();
        mContact.relative = aniRelative.getTitleText3();
        mContact.relative_phone_number = aniContactPhoneNumber.getTitleText3();

        mContact.extra = aniExtraInfo.getTitleText3();

        mContact.adviser_info = aniAdviserName.getTitleText3();

        boolean result = mContact.CheckDataLegality();
        if (!result) {
            return;
        }

        ContactDao dao = new ContactDao(this);
        if (state == NEW) {
            dao.insert(mContact);
        } else if (state == MODIFY) {
            dao.modify(mContact);
        }
        finish();
    }

    @OnClick(R.id.ani_address)
    public void onAddressPicker(View view) {
        if (state == VIEW) {
            return;
        }
        AddressPickTask task = new AddressPickTask(this);
        task.setHideProvince(false);
        task.setHideCounty(false);
        task.setCallback(new AddressPickTask.Callback() {
            @Override
            public void onAddressInitFailed() {
                ToastUtils.showShort("数据初始化失败");
            }

            @Override
            public void onAddressPicked(Province province, City city, County county) {
                if (county == null) {
                    ToastUtils.showShort(province.getAreaName() + city.getAreaName());
                } else {
                    ToastUtils.showShort(province.getAreaName() + "-" + city.getAreaName() + "-" + county.getAreaName());
                }
            }
        });
        task.execute("安徽", "安庆", "潜山");
    }

    @OnClick(R.id.btn_return)
    public void onClickReturn() {
        finish();
    }
}

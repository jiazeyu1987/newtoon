package com.example.administrator.new_ptns.pager.shuqian;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.example.administrator.new_ptns.BaseActivity;
import com.example.administrator.new_ptns.R;
import com.example.administrator.new_ptns.custom_item.CustomItemA1;
import com.example.administrator.new_ptns.custom_item.CustomItemA2;
import com.example.administrator.new_ptns.data_handler.ContactDao;
import com.example.administrator.new_ptns.data_handler.ContactData;
import com.example.administrator.new_ptns.data_handler.ContactDataList;
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
    public static final String INTENT_CONTACT_STATE = "INTENT_CONTACT_STATE";
    public static final String INTENT_CONTACT_JSON = "INTENT_CONTACT_JSON";
    public int state = VIEW;

    public ContactData mContact = null;
    public ContactDataList mContactDataList = null;
    @BindView(R.id.ani_extra)
    EditText aniExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nt_contact_info);
        ButterKnife.bind(this);
        Utils.init(this);
        Intent intent = getIntent();
        state = intent.getIntExtra(INTENT_CONTACT_STATE, NEW);
        init_base_data();
        fresh_state();

    }

    private void init_false_data() {
        aniName.setTitleText3("张三");
        aniPhoneNumber.setTitleText3("14292918492");
        aniIdcard.setTitleText3("3408211999010184033");
        aniAddress.setTitleText3("浙江省杭州市余杭区");
        aniDetailaddress.setTitleText3("东西大道998号10栋101");

        aniRelative.setTitleText3("朋友");
        aniRelativeName.setTitleText3("李四");

        aniAdviserName.setTitleText3("王五");
        aniExtra.setText("你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好");
        aniContactPhoneNumber.setTitleText3("182923929118");

        contactNumber.setTitleText3("NO.000001");

        aniOperationMachanism.setValue3("医疗机构1");
        aniDepartment.setValue3("科室1");
        aniOperationDoctor.setValue3("医生1");
        aniOperationDate.setValue3("2020-1-12");
        aniStimulator.setValue3("刺激器1");
        aniElectrode1.setValue3("LSTN");
        aniElectrode2.setValue3("RSTN");
        aniControlSoftware.setValue3("软件1");
        aniChargingCoil.setValue3("线圈1");
    }

    private void init_base_data() {
        aniOperationMachanism.setDataList("请选择医疗机构", new String[]{"医疗机构1", "医疗机构2", "医疗机构3", "医疗机构4", "医疗机构5", "医疗机构6", "医疗机构7"});
        aniDepartment.setDataList("请选择科室", new String[]{"科室1", "科室2", "科室3", "科室4", "科室5", "科室6", "科室7"});
        aniOperationDoctor.setDataList("请选择手术医生", new String[]{"医生1", "医生2", "医生3", "医生4", "医生5", "医生6", "医生7",});
        aniOperationDate.setDatePicker();

        aniStimulator.setDataList("请选择刺激器", new String[]{"刺激器1", "刺激器2", "刺激器3", "刺激器4", "刺激器5", "刺激器6",});
        aniElectrode1.setDataList("请选择电极", new String[]{"LSTN", "RSTN",});
        aniElectrode2.setDataList("请选择电极", new String[]{"LSTN", "RSTN",});
        aniControlSoftware.setDataList("请选择程控软件", new String[]{"软件1", "软件2"});
        aniChargingCoil.setDataList("请选择充电线圈", new String[]{"线圈1", "线圈2"});
    }

    private void fresh_state() {
        if (state == NEW) {
            mContact = new ContactData();
            init_false_data();
        } else {
            Intent intent = getIntent();
            mContactDataList = new Gson().fromJson(intent.getStringExtra(INTENT_CONTACT_JSON), ContactDataList.class);
            mContact = mContactDataList.list1.get(0);
            freshUnModifyableContact();
            contactNumber.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(state==VIEW){
                        final String[] datalist = mContactDataList.getContactNumberList();
                        AlertDialog.Builder builder = new AlertDialog.Builder(NewContactActivity.this);
                        builder.setTitle("请选择订单号");
                        builder.setCancelable(true);
                        builder.setIcon(R.mipmap.ic_launcher)
                                .setItems(datalist, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        //contactNumber.setUnModifyValue(datalist[which]);
                                        mContact = mContactDataList.list1.get(which);
                                        freshUnModifyableContact();
                                    }
                                }).create()
                                .show();
                    }
                }
            });
        }
    }


    private void freshUnModifyableContact(){
        contactNumber.setUnModifyValue(mContact.contact_number);

        aniName.setUnModifyValue(mContact.patient_name);
        aniIdcard.setUnModifyValue(mContact.id_card);
        aniPhoneNumber.setUnModifyValue(mContact.phone_number);
        aniAddress.setUnModifyValue(mContact.address);
        aniDetailaddress.setUnModifyValue(mContact.detail_address);

        aniOperationMachanism.setUnClickableValue(mContact.operation_machanism);
        aniOperationDoctor.setUnClickableValue(mContact.operation_doctor);
        aniOperationDate.setUnClickableValue(mContact.operation_date);
        aniDepartment.setUnClickableValue(mContact.department);

        aniStimulator.setUnClickableValue(mContact.stimulator);
        aniElectrode1.setUnClickableValue(mContact.electrode1);
        aniElectrode2.setUnClickableValue(mContact.electrode2);
        aniControlSoftware.setUnClickableValue(mContact.stim_software);
        aniChargingCoil.setUnClickableValue(mContact.charging_coil);

        aniRelativeName.setUnModifyValue(mContact.relative_name);
        aniRelative.setUnModifyValue(mContact.relative);
        aniContactPhoneNumber.setUnModifyValue(mContact.relative_phone_number);

        aniExtra.setText(mContact.extra);
        aniExtra.setEnabled(false);
        aniAdviserName.setUnModifyValue(mContact.adviser_info);
        aniBtnSave.setVisibility(View.INVISIBLE);
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
        mContact.operation_doctor = aniOperationDoctor.getTitleText3();
        mContact.operation_date = aniOperationDate.getTitleText3();

        mContact.stimulator = aniStimulator.getTitleText3();
        mContact.electrode1 = aniElectrode1.getTitleText3();
        mContact.electrode2 = aniElectrode2.getTitleText3();
        mContact.stim_software = aniControlSoftware.getTitleText3();
        mContact.charging_coil = aniChargingCoil.getTitleText3();

        mContact.relative_name = aniRelativeName.getTitleText3();
        mContact.relative = aniRelative.getTitleText3();
        mContact.relative_phone_number = aniContactPhoneNumber.getTitleText3();
        mContact.extra = aniExtra.getText().toString();

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

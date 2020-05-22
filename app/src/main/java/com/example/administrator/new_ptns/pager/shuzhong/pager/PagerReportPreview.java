package com.example.administrator.new_ptns.pager.shuzhong.pager;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.bin.david.form.core.SmartTable;
import com.bin.david.form.data.style.FontStyle;
import com.example.administrator.new_ptns.R;
import com.example.administrator.new_ptns.custom_item.CustomItem5;
import com.example.administrator.new_ptns.custom_item.CustomItemA1;
import com.example.administrator.new_ptns.custom_item.CustomItemA1p3;
import com.example.administrator.new_ptns.data_handler.ContactData;
import com.example.administrator.new_ptns.data_handler.OperationTempData;
import com.example.administrator.new_ptns.data_handler.OperationTempDataDao;
import com.example.administrator.new_ptns.data_handler.OperationTableColumnInfo;
import com.example.administrator.new_ptns.pager.shuzhong.OperationTestingActivity;

import java.util.ArrayList;
import java.util.List;


public class PagerReportPreview {

    public OperationTestingActivity mContext;
    public View mView;

    public TextView tv_name,tv_sex,tv_age,tv_phone;
    public CustomItemA1p3 stim,electrode1,electrode2;
    public CheckBox cb_impedance,cb_current,cb_voltage,cb_battery,cb_charging;
    public CustomItemA1 hospital,operation_doctor,operation_date,contact_number;
    public ArrayList<OperationTempData> list1;
    public ContactData contactData = null;
    public ScrollView scrollview;
    public TableLayout table1;
    public ConstraintLayout lt1;
    CustomItem5 tag1;
    public PagerReportPreview(OperationTestingActivity context){
        mContext = context;
    }

    public void init_view(View view){
        mView = view;
        tv_name = mView.findViewById(R.id.textView92);
        tv_sex = mView.findViewById(R.id.textView93);
        tv_age = mView.findViewById(R.id.textView95);
        tv_phone = mView.findViewById(R.id.textView98);

        stim = mView.findViewById(R.id.sdfafa1);
        electrode1 = mView.findViewById(R.id.afasdfas2);
        electrode2 = mView.findViewById(R.id.afasdfas3);

        cb_impedance = mView.findViewById(R.id.checkBox4);
        cb_current = mView.findViewById(R.id.checkBox5);
        cb_voltage = mView.findViewById(R.id.checkBox3);
        cb_battery = mView.findViewById(R.id.checkBox2);
        cb_charging = mView.findViewById(R.id.checkBox);

        hospital = mView.findViewById(R.id.customItemA19);
        operation_doctor = mView.findViewById(R.id.customItemA110);
        operation_date = mView.findViewById(R.id.custom1ItemA19);
        contact_number = mView.findViewById(R.id.custom12ItemA19);
        scrollview = mView.findViewById(R.id.scrollview1);
        lt1 = mView.findViewById(R.id.lt1);
        tag1 = mView.findViewById(R.id.other_record);
        contactData = mContext.contactData;
        OperationTempDataDao dao = new OperationTempDataDao(mContext);
        list1 = dao.getAllOperationTempDatas();
        list1.add(new OperationTempData(1,"2020-2-2","LSTN","3+ 2-","200","xxxxx"));
        list1.add(new OperationTempData(1,"2020-2-2","LSTN","3+ 2-","200","xxxxx"));
        list1.add(new OperationTempData(1,"2020-2-2","LSTN","3+ 2-","200","xxxxx"));
        list1.add(new OperationTempData(1,"2020-2-2","LSTN","3+ 2-","200","xxxxx"));
        list1.add(new OperationTempData(1,"2020-2-2","LSTN","3+ 2-","200","xxxxx"));
        list1.add(new OperationTempData(1,"2020-2-2","LSTN","3+ 2-","200","xxxxx"));
        list1.add(new OperationTempData(1,"2020-2-2","LSTN","3+ 2-","200","xxxxx"));
        list1.add(new OperationTempData(1,"2020-2-2","LSTN","3+ 2-","200","xxxxx"));
        list1.add(new OperationTempData(1,"2020-2-2","LSTN","3+ 2-","200","xxxxx"));
        list1.add(new OperationTempData(1,"2020-2-2","LSTN","3+ 2-","200","xxxxx"));
        list1.add(new OperationTempData(1,"2020-2-2","LSTN","3+ 2-","200","xxxxx"));
        list1.add(new OperationTempData(1,"2020-2-2","LSTN","3+ 2-","200","xxxxx"));
        list1.add(new OperationTempData(1,"2020-2-2","LSTN","3+ 2-","200","xxxxx"));
        list1.add(new OperationTempData(1,"2020-2-2","LSTN","3+ 2-","200","xxxxx"));
        list1.add(new OperationTempData(1,"2020-2-2","LSTN","3+ 2-","200","xxxxx"));
        list1.add(new OperationTempData(1,"2020-2-2","LSTN","3+ 2-","200","xxxxx"));
        list1.add(new OperationTempData(1,"2020-2-2","LSTN","3+ 2-","200","xxxxx"));
        list1.add(new OperationTempData(1,"2020-2-2","LSTN","3+ 2-","200","xxxxx"));
        list1.add(new OperationTempData(1,"2020-2-2","LSTN","3+ 2-","200","xxxxx"));
        list1.add(new OperationTempData(1,"2020-2-2","LSTN","3+ 2-","200","xxxxx"));
        list1.add(new OperationTempData(1,"2020-2-2","LSTN","3+ 2-","200","xxxxx"));
        list1.add(new OperationTempData(1,"2020-2-2","LSTN","3+ 2-","200","xxxxx"));
        list1.add(new OperationTempData(1,"2020-2-2","LSTN","3+ 2-","200","xxxxx"));
        list1.add(new OperationTempData(1,"2020-2-2","LSTN","3+ 2-","200","xxxxx"));
        list1.add(new OperationTempData(1,"2020-2-2","LSTN","3+ 2-","200","xxxxx"));
        list1.add(new OperationTempData(1,"2020-2-2","LSTN","3+ 2-","200","xxxxx"));
        list1.add(new OperationTempData(1,"2020-2-2","LSTN","3+ 2-","200","xxxxx"));
        list1.add(new OperationTempData(1,"2020-2-2","LSTN","3+ 2-","200","xxxxx"));
        list1.add(new OperationTempData(1,"2020-2-2","LSTN","3+ 2-","200","xxxxx"));
        list1.add(new OperationTempData(1,"2020-2-2","LSTN","3+ 2-","200","xxxxx"));
        list1.add(new OperationTempData(1,"2020-2-2","LSTN","3+ 2-","200","xxxxx"));
        list1.add(new OperationTempData(1,"2020-2-2","LSTN","3+ 2-","200","xxxxx"));
        list1.add(new OperationTempData(1,"2020-2-2","LSTN","3+ 2-","200","xxxxx"));
        list1.add(new OperationTempData(1,"2020-2-2","LSTN","3+ 2-","200","xxxxx"));
        list1.add(new OperationTempData(1,"2020-2-2","LSTN","3+ 2-","200","xxxxx"));
        table1 = mView.findViewById(R.id.tableLayout);
        set_data();
        set_table_data();
    }

    private void set_table_data(){
        List<OperationTableColumnInfo> list = new ArrayList<>();
        SmartTable table = mView.findViewById(R.id.table1);
        for(int i = 0 ; i < list1.size();i++){
            OperationTempData data = list1.get(i);
            list.add(new OperationTableColumnInfo(data.long_date,data.electrode_position,data.electrode_data,data.impedance,data.stim_para));
        }
        table.setData(list);
        table.getConfig().setContentStyle(new FontStyle(18, Color.BLUE));
        //lt1.getLayoutParams().height = list1.size()*20+lt1.getLayoutParams().height;

        ConstraintLayout.LayoutParams lp = (ConstraintLayout.LayoutParams) tag1.getLayoutParams();
        lp.topMargin = list1.size()*60;
        tag1.setLayoutParams(lp);
    }

    private void set_data(){
        tv_name.setText(contactData.patient_name);
        tv_sex.setText(contactData.sex);
        tv_phone.setText(contactData.phone_number);
        tv_age.setText(contactData.getAge());

        stim.setTitleText2(mContext.myPagerAdapter.pagerBasicInfo.stim.edt1.getText().toString());
        electrode1.setTitleText2(mContext.myPagerAdapter.pagerBasicInfo.electrode1.btn1.getText().toString());
        electrode2.setTitleText2(mContext.myPagerAdapter.pagerBasicInfo.electrode2.btn1.getText().toString());
        cb_battery.setChecked(true);
        cb_current.setChecked(true);
        cb_voltage.setChecked(true);
        cb_charging.setChecked(true);
        cb_impedance.setChecked(true);

        hospital.setTitleText3(contactData.operation_machanism);
        operation_doctor.setTitleText3(contactData.operation_doctor);
        operation_date.setTitleText3(contactData.operation_date);
        contact_number.setTitleText3(contactData.relative_phone_number);
    }

    public void onResume(){

    }


}


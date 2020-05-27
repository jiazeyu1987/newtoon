package com.example.administrator.new_ptns.pager.shuzhong;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.example.administrator.new_ptns.G;
import com.example.administrator.new_ptns.MainActivity;
import com.example.administrator.new_ptns.R;
import com.example.administrator.new_ptns.custom_item.CustomItemA1p1;
import com.example.administrator.new_ptns.custom_item.CustomItemA1p2;
import com.example.administrator.new_ptns.data_handler.ContactDao;
import com.example.administrator.new_ptns.data_handler.ContactData;
import com.example.administrator.new_ptns.data_handler.ContactDataList;
import com.example.administrator.new_ptns.data_handler.ElectrodeBundle;
import com.example.administrator.new_ptns.data_handler.PatientDao;
import com.example.administrator.new_ptns.data_handler.PatientData;
import com.example.administrator.new_ptns.my_utils.TimeUtils;
import com.example.administrator.new_ptns.pager.PagerBase;
import com.example.administrator.new_ptns.pager.shuqian.NewContactActivity;
import com.google.gson.Gson;

import java.util.ArrayList;


public class PagerShuzhong extends PagerBase {
    CustomItemA1p1 ci_contact_number,ci_id_card;
    CustomItemA1p2 ci_electrode1,ci_electrode2;
    ElectrodeBundle bundle1,bundle2;
    TextView contact_confirm;
    TextView enter1,enter2;
    TextView tv_testing;
    ContactData g_contactData;
    public PagerShuzhong(MainActivity context){
        super(context);
    }

    @Override
    public void init_view(View view,String type){
        super.init_view(view,type);
        enter1 = mView.findViewById(R.id.textView84);
        enter2 = mView.findViewById(R.id.textView85);
        tv_testing = mView.findViewById(R.id.pm1_testing);
        contact_confirm = mView.findViewById(R.id.textView82);
        ci_contact_number = mView.findViewById(R.id.ci_contact_number);
        ci_id_card = mView.findViewById(R.id.ci_id_card);
        ci_electrode1 = mView.findViewById(R.id.ci_electrode1);
        ci_electrode2 = mView.findViewById(R.id.ci_electrode2);
        tv_testing.setVisibility(View.INVISIBLE);
        contact_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContactDao dao = new ContactDao(mContext);
                ArrayList<ContactData> list1 = dao.get_contact_by_idcard(ci_id_card.getTitleText3());
                ArrayList<ContactData> newlist = new ArrayList<>();
                for(int i = 0 ; i < list1.size();i++){
                    if(list1.get(i).contact_number.equals(ci_contact_number.getTitleText3())){
                        newlist.add(list1.get(i));
                    }
                }
                list1 = newlist;
                if(list1.size()==0){
                    ToastUtils.showShort("没有符合条件的合同信息1");
                    return;
                }

                ContactData contactData=list1.get(0);
                setActive();
                ContactDataList contactDataList = new ContactDataList();
                contactDataList.list1 = new ArrayList<>();
                contactDataList.list1.add(contactData);
                set_global_contact(contactData);

                Intent intent = new Intent(mContext, NewContactActivity.class);
                intent.putExtra(NewContactActivity.INTENT_CONTACT_STATE,NewContactActivity.VIEW);
                intent.putExtra(NewContactActivity.INTENT_CONTACT_JSON,new Gson().toJson(contactDataList));
                G.init(contactDataList.list1.get(0), TimeUtils.getCurrentTimeYMDHMS());
                g_contactData = list1.get(0);
                if(G.TEST==false) {
                    mContext.startActivity(intent);
                }
                ToastUtils.showShort("OK1");
            }
        });
        enter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_enter1();
            }
        });

        enter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_enter2();
            }
        });
        tv_testing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_enter_testing();
            }
        });
        if(G.TEST){
            contact_confirm.performClick();
        }
    }

    private void do_enter1(){
        Intent intent = new Intent(mContext,OperationActivity.class);
        String para1 = ci_electrode1.btn1.getText().toString();
        String para2 = ci_electrode1.btn2.getText().toString();
        String para3 = ci_electrode1.getTitleText2();
        ElectrodeBundle bundle = new ElectrodeBundle();
        bundle.id = 1;
        bundle.left_or_right = para1;
        bundle.guige = para2;
        bundle.xuliehao = para3;
        G.position1 = bundle;
        G.electrodeBundle1 = bundle;
        Gson gson = new Gson();
        String s1 = gson.toJson(bundle);
        intent.putExtra("extra",s1);
        mContext.startActivity(intent);
    }
    private void do_enter2(){
        Intent intent = new Intent(mContext,OperationActivity.class);
        String para1 = ci_electrode2.btn1.getText().toString();
        String para2 = ci_electrode2.btn2.getText().toString();
        String para3 = ci_electrode2.getTitleText2();
        ElectrodeBundle bundle = new ElectrodeBundle();
        bundle.id = 2;
        bundle.left_or_right = para1;
        bundle.guige = para2;
        bundle.xuliehao = para3;
        G.position2 = bundle;
        G.electrodeBundle2 = bundle;
        Gson gson = new Gson();
        String s1 = gson.toJson(bundle);
        intent.putExtra("extra",s1);
        mContext.startActivity(intent);
    }

    private void do_enter_testing(){
        Intent intent = new Intent(mContext,OperationTestingActivity.class);
        Gson gson = new Gson();
        intent.putExtra("para1",gson.toJson(g_contactData));
        mContext.startActivity(intent);
    }

    private void set_global_contact(ContactData contactData){
        G.g_contact_data = contactData;
        generate_patient_by_contact(contactData);
    }

    private void generate_patient_by_contact(ContactData contactData){
        String id_card = contactData.id_card;
        if(id_card==null){
            mContext.finish();
            return;
        }
        PatientDao patientDao = new PatientDao(mContext);
        PatientData patientData = G.getPatientLocalByIdCard(id_card);
        if(patientData!=null){
            G.g_patient_data = patientData;
        }else{
            PatientDao dao = new PatientDao(mContext);
            PatientData patientData1 = new PatientData();
            patientData1.id_card = contactData.id_card;
            patientData1.doctor_id = G.doctor_id;
            patientData1.name = contactData.patient_name;
            patientData1.sex = contactData.sex;
            patientData1.phone_number = contactData.phone_number;
            patientData1.address = contactData.address;
            patientData1.detail_address = contactData.detail_address;
            G.add_patient(dao,patientData1);
            G.g_patient_data = patientData1;
        }
    }

    private void setActive(){
        tv_testing.setVisibility(View.VISIBLE);
    }

    public void onResume(){

    }



}

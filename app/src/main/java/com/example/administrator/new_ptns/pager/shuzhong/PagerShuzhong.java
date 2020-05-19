package com.example.administrator.new_ptns.pager.shuzhong;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.new_ptns.G;
import com.example.administrator.new_ptns.MainActivity;
import com.example.administrator.new_ptns.R;
import com.example.administrator.new_ptns.custom_item.CustomItemA1p1;
import com.example.administrator.new_ptns.custom_item.CustomItemA1p2;
import com.example.administrator.new_ptns.data_handler.ContactDao;
import com.example.administrator.new_ptns.data_handler.ContactData;
import com.example.administrator.new_ptns.data_handler.ContactDataList;
import com.example.administrator.new_ptns.my_utils.TimeUtils;
import com.example.administrator.new_ptns.pager.PagerBase;
import com.example.administrator.new_ptns.pager.shuqian.NewContactActivity;
import com.google.gson.Gson;

import java.util.ArrayList;


public class PagerShuzhong extends PagerBase {
    CustomItemA1p1 ci_contact_number,ci_id_card;
    CustomItemA1p2 ci_electrode1,ci_electrode2;
    TextView contact_confirm;
    TextView enter1,enter2;
    TextView tv_testing;
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
        contact_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContactDao dao = new ContactDao(mContext);
                ArrayList<ContactData> list1 = dao.get_contact_by_idcard(ci_id_card.getTitleText3());
                if(list1.size()==0){
                    return;
                }
                ContactDataList contactDataList = new ContactDataList();
                contactDataList.list1 = list1;
                Intent intent = new Intent(mContext, NewContactActivity.class);
                intent.putExtra(NewContactActivity.INTENT_CONTACT_STATE,NewContactActivity.VIEW);
                intent.putExtra(NewContactActivity.INTENT_CONTACT_JSON,new Gson().toJson(contactDataList));
                G.init(contactDataList.list1.get(0), TimeUtils.getCurrentTimeYMDHMS());
                mContext.startActivity(intent);
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
    }

    private void do_enter1(){
        Intent intent = new Intent(mContext,OperationActivity.class);
        String para1 = ci_electrode1.btn1.getText().toString();
        String para2 = ci_electrode1.btn2.getText().toString();
        String para3 = ci_electrode1.getTitleText2();
        intent.putExtra("para1",para1);
        intent.putExtra("para2",para2);
        intent.putExtra("para3",para3);
        mContext.startActivity(intent);
    }
    private void do_enter2(){
        Intent intent = new Intent(mContext,OperationActivity.class);
        String para1 = ci_electrode2.btn1.getText().toString();
        String para2 = ci_electrode2.btn2.getText().toString();
        String para3 = ci_electrode2.getTitleText2();
        intent.putExtra("para1",para1);
        intent.putExtra("para2",para2);
        intent.putExtra("para3",para3);
        mContext.startActivity(intent);
    }

    private void do_enter_testing(){
        Intent intent = new Intent(mContext,OperationTestingActivity.class);
        mContext.startActivity(intent);
    }

    public void onResume(){

    }



}

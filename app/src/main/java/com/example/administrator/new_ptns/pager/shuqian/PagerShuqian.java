package com.example.administrator.new_ptns.pager.shuqian;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.new_ptns.MainActivity;
import com.example.administrator.new_ptns.R;
import com.example.administrator.new_ptns.custom_item.CustomItemA1p1;
import com.example.administrator.new_ptns.data_handler.ContactDao;
import com.example.administrator.new_ptns.data_handler.ContactData;
import com.example.administrator.new_ptns.data_handler.ContactDataList;
import com.example.administrator.new_ptns.pager.PagerBase;
import com.google.gson.Gson;

import java.util.ArrayList;


public class PagerShuqian extends PagerBase {
    private CustomItemA1p1 query_contact;
    private CustomItemA1p1 new_contact;
    private EditText et_id_number,et_name;
    private ImageView iv_find,iv_new ;
    public PagerShuqian(MainActivity context){
        super(context);
    }
    private TextView tv_testing;
    @Override
    public void init_view(View view,String type){
        super.init_view(view,type);
        query_contact = mView.findViewById(R.id.ci_contact_number);
        new_contact = mView.findViewById(R.id.ci_id_card);
        et_id_number = query_contact.findViewById(R.id.et_1);
        et_name = new_contact.findViewById(R.id.et_1);
        iv_find = query_contact.findViewById(R.id.imageView36);
        iv_new = new_contact.findViewById(R.id.imageView36);
        tv_testing = mView.findViewById(R.id.pm1_testing);
        iv_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_find();
            }
        });
        tv_testing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_testing();
            }
        });
        iv_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_new();
            }
        });


    }

    public void onResume(){

    }

    private void do_find(){

        ContactDao dao = new ContactDao(mContext);
        ArrayList<ContactData> list1 = dao.get_contact_by_idcard(query_contact.getTitleText3());
        if(list1.size()==0){
            return;
        }
        ContactDataList contactDataList = new ContactDataList();
        contactDataList.list1 = list1;
        Intent intent = new Intent(mContext,NewContactActivity.class);
        intent.putExtra(NewContactActivity.INTENT_CONTACT_STATE,NewContactActivity.VIEW);
        intent.putExtra(NewContactActivity.INTENT_CONTACT_JSON,new Gson().toJson(contactDataList));
        mContext.startActivity(intent);
    }

    private void do_new(){
        Intent intent = new Intent(mContext,NewContactActivity.class);
        mContext.startActivity(intent);
    }

    private void do_testing(){
        Intent intent = new Intent(mContext,PulseTestingActivity.class);
        mContext.startActivity(intent);
    }
}

package com.example.administrator.dbs1.pager.user;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.dbs1.MainActivity;
import com.example.administrator.dbs1.R;
import com.example.administrator.dbs1.ble.CMD_code;
import com.example.administrator.dbs1.custom_item.CustomItem5;
import com.example.administrator.dbs1.custom_item.InfoDialog;
import com.example.administrator.dbs1.pager.PagerBase;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Calendar;


public class PagerUser extends PagerBase {

    CustomItem5 data_export;
    CustomItem5 connect_check;
    CustomItem5 private_contact;
    ImageView edit_button;

    TextView txt_name,txt_sex,txt_age;
    public PagerUser(MainActivity context){
        super(context);
    }

    @Override
    public void init_view(View view,String type){
        super.init_view(view,type);
        data_export = mView.findViewById(R.id.customItem53);
        connect_check = mView.findViewById(R.id.customItem52);
        private_contact = mView.findViewById(R.id.customItem5);
        edit_button = mView.findViewById(R.id.vi4_edit);
        edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_edit();
            }
        });
        data_export.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_data_export();
            }
        });
        connect_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_connect_check();
            }
        });
        private_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_private_contact();
            }
        });
        txt_name = mView.findViewById(R.id.textView10);
        txt_sex = mView.findViewById(R.id.textView16);
        txt_age = mView.findViewById(R.id.textView17);
        fresh_user();
    }

    public void onResume(){
        UserDao dao = new UserDao(mContext);
        ArrayList<PagerUserItem> list1 = dao.getAllUsers();
        if(list1.size()==0){
           mContext.current_user = null;
        }else{
            mContext.current_user = list1.get(0);
        }
        fresh_user();
    }

    private void fresh_user(){
        if(mContext.current_user!=null){
            txt_name.setText(mContext.current_user.name);
            txt_sex.setText(mContext.current_user.sex);

            String[] sarray = mContext.current_user.birthday.split("-");
            int year = Integer.parseInt(sarray[0]);
            Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
            int year_now = c.get(Calendar.YEAR);
            int age = year_now-year;
            txt_age.setText(age+"");
        }
    }

    private void do_edit(){
        Intent intent = new Intent(mContext, EditUserActivity.class);

        if(mContext.current_user!=null){
            Gson gson = new Gson();
            String s1 = gson.toJson(mContext.current_user);
            intent.putExtra("extra",s1);
        }

        mContext.startActivity(intent);
    }

    private void do_data_export(){
//        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
//        builder.setTitle("Title").
//                setPositiveButton("Positive", null).
//                setNegativeButton("Negative", null)
//                .setMultiChoiceItems(new String[] {"选项1","选项2","选项3","选项2","选项3","选项2","选项3","选项2","选项3","选项2","选项3","选项2","选项3","选项2","选项3","选项2","选项3"}, null, null).
//                show();
          Intent intent = new Intent(mContext,DataExportActivity.class);
          mContext.startActivity(intent);
    }

    private void do_connect_check(){
        int[] values = new int[8];
        values[0] = 0x01;
        values[1] = CMD_code.CMD_READ_MEMORY;
        mContext.write_with_read(values);
    }

    private void do_private_contact(){
        InfoDialog infoDialog = new InfoDialog.Builder(mContext)
                .setTitle("隐私条款")
                .setMessage("\n" +
                        "本应用不会上传任何数据\n" +
                        "不会使用网络")
                .setButton("同意授权", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showToast("FFFFFFFFFFFFFFF");
                    }
                })
                .create();
        infoDialog.show();
    }

}

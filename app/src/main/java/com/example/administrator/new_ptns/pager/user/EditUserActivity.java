package com.example.administrator.new_ptns.pager.user;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.new_ptns.R;
import com.example.administrator.new_ptns.my_utils.TimeUtils;
import com.google.gson.Gson;
import com.meetsl.scardview.SCardView;

import java.util.Calendar;

public class EditUserActivity extends AppCompatActivity {

    EditText txt_name;
    TextView txt_birthday;
    Button man,woman,confirm;
    ImageView btn_return;
    SCardView btn_birthday;
    Boolean is_man=true;
    PagerUserItem item = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_patient);
        txt_name = findViewById(R.id.textView38);
        txt_birthday = findViewById(R.id.textView40);
        man = findViewById(R.id.button4);
        woman = findViewById(R.id.button5);
        confirm = findViewById(R.id.aep_confirm);
        btn_return = findViewById(R.id.imageView26);
        btn_birthday = findViewById(R.id.SCardView2);
        man.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_click_man();
            }
        });

        woman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_click_woman();
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_click_confirm();
            }
        });

        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btn_birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_click_bithday();
            }
        });

        Intent intent = getIntent();
        String s1 = intent.getStringExtra("extra");
        if(s1!=null&&s1.length()>0){
            Gson gson = new Gson();
            item = gson.fromJson(s1,PagerUserItem.class);
        }

        if(item!=null){
            txt_name.setText(item.name);
            if(item.sex.equals("男")){
                do_click_man();
            }else{
                do_click_woman();
            }
            txt_birthday.setText(item.birthday);
        }


    }


    private void do_click_man(){
        is_man = true;
        man.setBackground(getResources().getDrawable(R.drawable.rect1));
        man.setTextColor(getResources().getColor(R.color.green1));
        woman.setBackground(null);
        woman.setTextColor(getResources().getColor(R.color.active_txt_color1));
    }

    private void do_click_woman(){
        is_man = false;
        woman.setBackground(getResources().getDrawable(R.drawable.rect1));
        woman.setTextColor(getResources().getColor(R.color.green1));
        man.setBackground(null);
        man.setTextColor(getResources().getColor(R.color.active_txt_color1));
    }

    private void do_click_confirm(){
        PagerUserItem user = new PagerUserItem();
        if(txt_name.getText()==null||txt_name.getText().length()<1){
            Toast.makeText(EditUserActivity.this,"请输入姓名",Toast.LENGTH_LONG).show();
            return;
        }
        if(txt_birthday.getText()==null||txt_birthday.getText().length()<1||txt_birthday.getText().equals("请选择出生日期")){
            Toast.makeText(EditUserActivity.this,"请输入生日信息",Toast.LENGTH_LONG).show();
            return;
        }


        if(item==null) {
            if(is_man){
                user.sex="男";
            }else{
                user.sex="女";
            }
            user.name = txt_name.getText().toString();
            user.birthday = txt_birthday.getText().toString();
            user.create_time = TimeUtils.getCurrentTimeYMDHMS();
            user.last_modify_time = TimeUtils.getCurrentTimeYMDHMS();
            UserDao dao = new UserDao(this);
            dao.insert(user);
        }else{
            if(is_man){
                item.sex="男";
            }else{
                item.sex="女";
            }
            item.name = txt_name.getText().toString();
            item.birthday = txt_birthday.getText().toString();
            item.last_modify_time = TimeUtils.getCurrentTimeYMDHMS();
            UserDao dao = new UserDao(this);
            dao.modify(item);
        }
        finish();
    }

    private void do_click_bithday(){

        if(item==null) {
            Calendar ca = Calendar.getInstance();
            final int mYear = ca.get(Calendar.YEAR) - 30;
            final int mMonth = ca.get(Calendar.MONTH);
            final int mDay = ca.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(EditUserActivity.this, DatePickerDialog.THEME_HOLO_DARK,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            txt_birthday.setText(year + "-" + (month + 1) + "-" + dayOfMonth + "");
                        }
                    },
                    mYear, mMonth, mDay);
            datePickerDialog.show();
        }else{
            String[] sarray = item.birthday.split("-");
            int mYear = Integer.parseInt(sarray[0]);
            int mMonth = Integer.parseInt(sarray[1])-1;
            int mDay = Integer.parseInt(sarray[2]);
            DatePickerDialog datePickerDialog = new DatePickerDialog(EditUserActivity.this, DatePickerDialog.THEME_HOLO_DARK,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            txt_birthday.setText(year + "-" + (month + 1) + "-" + dayOfMonth + "");
                        }
                    },
                    mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }

}

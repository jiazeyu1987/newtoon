package com.example.administrator.new_ptns.pager.timing;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.administrator.new_ptns.BaseActivity;
import com.example.administrator.new_ptns.R;
import com.google.gson.Gson;
import com.kyleduo.switchbutton.SwitchButton;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NewTimingActivity extends BaseActivity {

    Button button_day1,button_day2,button_day3,button_day4,button_day5,button_day6,button_day7;
    Boolean b1=true,b2=true,b3=true,b4=true,b5=true,b6=true,b7=true;
    Button confirm,delete,modify;
    SwitchButton switchButton;
    TimePicker timePicker;
    TextView timePickTxt;
    TextView titleTxt;
    private PagerTimingItem current_item = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_timing);
        Intent intent = getIntent();
        String extra = intent.getStringExtra("extra_value");
        if(extra!=null&&extra.length()>0){
            Gson gson = new Gson();
            PagerTimingItem item = gson.fromJson(extra,PagerTimingItem.class);
            current_item = item;
        }
        if(current_item!=null){
            b1 = current_item.b1;
            b2 = current_item.b2;
            b3 = current_item.b3;
            b4 = current_item.b4;
            b5 = current_item.b5;
            b6 = current_item.b6;
            b7 = current_item.b7;
        }

        init_view();
        if(current_item!=null){
            switchButton.setChecked(current_item.repeat);
            int hour = Integer.parseInt(current_item.time_tar.split(":")[0]);
            int minute = Integer.parseInt(current_item.time_tar.split(":")[1]);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                timePicker.setHour(hour);
                timePicker.setMinute(minute);
            } else {
                timePicker.setCurrentHour(hour);
                timePicker.setCurrentMinute(minute);
            }
            titleTxt.setText("修改时间");
            confirm.setVisibility(View.GONE);
            modify.setVisibility(View.VISIBLE);
            delete.setVisibility(View.VISIBLE);
        }
    }


    private void init_view(){
        titleTxt = findViewById(R.id.textView45);
        titleTxt.setText("设定时间");
        timePickTxt = findViewById(R.id.textView46);
        timePicker = findViewById(R.id.timePicker4);
        confirm = findViewById(R.id.button15);
        modify = findViewById(R.id.button15111);
        modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_modify();
            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_confirm();
            }
        });
        delete = findViewById(R.id.button16);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_delete();
            }
        });
        switchButton = findViewById(R.id.switch1);
        switchButton.setChecked(true);
        button_day1 = findViewById(R.id.button_day1);
        button_day2 = findViewById(R.id.button_day2);
        button_day3 = findViewById(R.id.button_day3);
        button_day4 = findViewById(R.id.button_day4);
        button_day5 = findViewById(R.id.button_day5);
        button_day6 = findViewById(R.id.button_day6);
        button_day7 = findViewById(R.id.button_day7);
        set_button_choosen(button_day1,b1);
        set_button_choosen(button_day2,b2);
        set_button_choosen(button_day3,b3);
        set_button_choosen(button_day4,b4);
        set_button_choosen(button_day5,b5);
        set_button_choosen(button_day6,b6);
        set_button_choosen(button_day7,b7);
        button_day1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b1 = !b1;
                set_button_choosen(button_day1,b1);
            }
        });
        button_day2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b2 = !b2;
                set_button_choosen(button_day2,b2);
            }
        });
        button_day3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b3 = !b3;
                set_button_choosen(button_day3,b3);
            }
        });
        button_day4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b4 = !b4;
                set_button_choosen(button_day4,b4);
            }
        });
        button_day5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b5 = !b5;
                set_button_choosen(button_day5,b5);
            }
        });
        button_day6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b6 = !b6;
                set_button_choosen(button_day6,b6);
            }
        });
        button_day7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b7 = !b7;
                set_button_choosen(button_day7,b7);
            }
        });

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hourOfDay, int minute) {
                String hourOfDay2 = String.format("%02d", hourOfDay);
                String minute2 = String.format("%02d", minute);
                timePickTxt.setText(hourOfDay2 + ":" + minute2);
            }
        });

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");// HH:mm:ss
//获取当前时间
        Date date = new Date(System.currentTimeMillis());
        timePickTxt.setText(simpleDateFormat.format(date));
        confirm.setVisibility(View.VISIBLE);
        modify.setVisibility(View.GONE);
        delete.setVisibility(View.GONE);
    }

    private void set_button_choosen(Button button ,Boolean b1){
        if(b1){
            button.setBackground(getResources().getDrawable(R.drawable.round1));
            button.setTextColor(getResources().getColor(R.color.white));
        }else{
            button.setBackground(getResources().getDrawable(R.drawable.round2));
            button.setTextColor(getResources().getColor(R.color.active_txt_color1));
        }
    }

    private void do_confirm(){
        do_create_new();
    }

    private void do_create_new(){
        if(!b1&&!b2&&!b3&&!b4&&!b5&&!b6&&!b7){
            Toast.makeText(this,"请选择一个日期",Toast.LENGTH_LONG).show();
            return;
        }

        PagerTimingItem item = new PagerTimingItem();
        item.b1 = b1;
        item.b2 = b2;
        item.b3 = b3;
        item.b4 = b4;
        item.b5 = b5;
        item.b6 = b6;
        item.b7 = b7;
        item.repeat = switchButton.isChecked();
        item.time_tar = timePickTxt.getText().toString();
        item.open = true;
        TimeDao dao = new TimeDao(NewTimingActivity.this);
        dao.insert(item);
        finish();

        Date date = new Date();
    }

    private void do_delete(){
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(NewTimingActivity.this);
        builder.setTitle("警告");
        builder.setMessage("确认要删除当前闹钟吗？");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                TimeDao dao = new TimeDao(NewTimingActivity.this);
                dao.delete(current_item);
                finish();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();

    }

    private void do_modify(){

        if(!b1&&!b2&&!b3&&!b4&&!b5&&!b6&&!b7){
            Toast.makeText(this,"请选择一个日期",Toast.LENGTH_LONG).show();
            return;
        }

        current_item.b1 = b1;
        current_item.b2 = b2;
        current_item.b3 = b3;
        current_item.b4 = b4;
        current_item.b5 = b5;
        current_item.b6 = b6;
        current_item.b7 = b7;
        current_item.repeat = switchButton.isChecked();
        current_item.time_tar = timePickTxt.getText().toString();
        TimeDao dao = new TimeDao(this);
        dao.modify(current_item);
        finish();
    }
}

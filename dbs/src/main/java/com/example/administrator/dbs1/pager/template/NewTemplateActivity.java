package com.example.administrator.dbs1.pager.template;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.dbs1.R;
import com.example.administrator.dbs1.custom_item.TemplateItem;
import com.google.gson.Gson;

import java.util.ArrayList;

public class NewTemplateActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<TemplateItem> list11;
    TextView name_txt;
    PagerTemplateItem current_item;
    LinearLayout button_save,button_modify,button_delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);
        get_current_item();
        name_txt = findViewById(R.id.at_name);
        listView = findViewById(R.id.at_listview);
        list11 = new ArrayList<>();

        TemplateItem item1 = new TemplateItem(this);
        item1.name = "time";
        item1.setIconImgId(R.mipmap.zhiliaoshijian);
        item1.setText("治疗时间","分钟");
        list11.add(item1);

        TemplateItem item2 = new TemplateItem(this);
        item2.name = "current";
        item2.setIconImgId(R.mipmap.cijidianliu);
        item2.setText("刺激电流","毫安");
        list11.add(item2);

        TemplateItem item3 = new TemplateItem(this);
        item3.name = "freq";
        item3.setIconImgId(R.mipmap.pulse);
        item3.setText("脉冲频率","赫兹");
        list11.add(item3);

        TemplateItem item4 = new TemplateItem(this);
        item4.name = "pulse";
        item4.setIconImgId(R.mipmap.maichongkuandu);
        item4.setText("脉冲宽度","微秒");
        list11.add(item4);

        TemplateItem item5 = new TemplateItem(this);
        item5.name = "close";
        item5.setIconImgId(R.mipmap.guanbishijian);
        item5.setText("关闭时间","分钟");
        list11.add(item5);

        TemplateItem item6 = new TemplateItem(this);
        item6.name = "up";
        item6.setIconImgId(R.mipmap.shangshengshijian);
        item6.setText("上升时间","分钟");
        list11.add(item6);

        TemplateItem item7 = new TemplateItem(this);
        item7.name = "stim";
        item7.setIconImgId(R.mipmap.cijishijian);
        item7.setText("刺激时间","分钟");
        list11.add(item7);

        TemplateItem item8 = new TemplateItem(this);
        item8.name = "down";
        item8.setIconImgId(R.mipmap.xiajiangshijian);
        item8.setText("下降时间","分钟");
        list11.add(item8);

        TemplateItemAdapter adapter = new TemplateItemAdapter(this,list11);
        listView.setAdapter(adapter);

        button_save = findViewById(R.id.button_save);
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_save();
            }
        });
        button_modify = findViewById(R.id.at_modify);
        button_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_modify();
            }
        });
        button_delete = findViewById(R.id.at_delete);
        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_delete();
            }
        });

        if(current_item==null){
            button_save.setVisibility(View.VISIBLE);
            button_modify.setVisibility(View.GONE);
            button_delete.setVisibility(View.GONE);
        }else{
            button_save.setVisibility(View.GONE);
            button_modify.setVisibility(View.VISIBLE);
            button_delete.setVisibility(View.VISIBLE);
            list11.get(0).set_value(current_item.treatment_time);
            list11.get(1).set_value(current_item.current);
            list11.get(2).set_value(current_item.freq);
            list11.get(3).set_value(current_item.pulse_width);
            list11.get(4).set_value(current_item.close_time);
            list11.get(5).set_value(current_item.raise_time);
            list11.get(6).set_value(current_item.stim_time);
            list11.get(7).set_value(current_item.fall_time);
            name_txt.setText(current_item.name);
        }
    }

    private void get_current_item(){
        Intent intent = getIntent();
        String s1 = intent.getStringExtra("extra");
        if(s1!=null&&s1.length()>0) {
            Gson gson = new Gson();
            current_item = gson.fromJson(s1, PagerTemplateItem.class);
        }else{
            current_item = null;
        }
    }

    private void do_save(){
        PagerTemplateItem item = new PagerTemplateItem();
        item.treatment_time = list11.get(0).value;
        item.current = list11.get(1).value;
        item.freq = list11.get(2).value;
        item.pulse_width = list11.get(3).value;
        item.close_time = list11.get(4).value;
        item.raise_time = list11.get(5).value;
        item.stim_time = list11.get(6).value;
        item.fall_time = list11.get(7).value;
        item.name = name_txt.getText().toString();
        if(item.name==null||item.name.length()<1){
            Toast.makeText(this,"请填写模板名称",Toast.LENGTH_LONG).show();
            return;
        }
        TemplateDao dao = new TemplateDao(this);
        dao.insert(item);
        finish();
    }

    private void do_modify(){
        current_item.treatment_time = list11.get(0).value;
        current_item.current = list11.get(1).value;
        current_item.freq = list11.get(2).value;
        current_item.pulse_width = list11.get(3).value;
        current_item.close_time = list11.get(4).value;
        current_item.raise_time = list11.get(5).value;
        current_item.stim_time = list11.get(6).value;
        current_item.fall_time = list11.get(7).value;
        current_item.name = name_txt.getText().toString();
        if(current_item.name==null||current_item.name.length()<1){
            Toast.makeText(this,"请填写模板名称",Toast.LENGTH_LONG).show();
            return;
        }
        TemplateDao dao = new TemplateDao(this);
        dao.modify(current_item);
        finish();
    }

    private void do_delete(){
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(NewTemplateActivity.this);
        builder.setTitle("警告");
        builder.setMessage("确认要删除当前模板吗？");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                TemplateDao dao = new TemplateDao(NewTemplateActivity.this);
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
}

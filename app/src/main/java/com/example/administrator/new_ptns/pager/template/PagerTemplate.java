package com.example.administrator.new_ptns.pager.template;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.administrator.new_ptns.MainActivity;
import com.example.administrator.new_ptns.R;
import com.example.administrator.new_ptns.pager.PagerBase;
import com.example.administrator.new_ptns.pager.timing.NewTimingActivity;
import com.example.administrator.new_ptns.pager.timing.PagerTimingItem;

import java.util.ArrayList;


public class PagerTemplate extends PagerBase {
    ListView listView;
    ArrayList<PagerTemplateItem> list1;
    PagerTemplateAdapter adapter;
    Button addTemplate;
    public PagerTemplate(MainActivity context){
        super(context);
    }

    @Override
    public void init_view(View view,String type){
        super.init_view(view,type);
        listView = mView.findViewById(R.id.listview2);
        list1 =  new ArrayList<>();
        init_false_data();
        //init_data_from_database();
        //adapter = new PagerTemplateAdapter(mContext,list1);
        //listView.setAdapter(adapter);
        onResume();

        addTemplate = mView.findViewById(R.id.button_add);
        addTemplate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, NewTemplateActivity.class);
                mContext.startActivity(intent);
            }
        });

    }

    public void onResume(){
        TemplateDao dao = new TemplateDao(mContext);
        list1 = dao.getAllTemplates();
        adapter = new PagerTemplateAdapter(mContext,list1);
        listView.setAdapter(adapter);
    }

//    private void init_data_from_database(){
//        TemplateDao dao = new TemplateDao(mContext);
//        list1 = dao.getAllTemplates();
//    }

    private void init_false_data(){
        for(int i = 0 ; i < 10;i++) {
            PagerTemplateItem item = new PagerTemplateItem();
            item.current = 30000;
            item.freq = 12;
            item.treatment_time = 5;
            item.pulse_width = 12;
            item.close_time = 21;
            item.raise_time = 3;
            item.fall_time = 5;
            item.name = "模板"+i;
            item.stim_time = 30+i;
            list1.add(item);
        }
    }

}

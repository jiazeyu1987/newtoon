package com.example.administrator.new_ptns.pager.timing;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.administrator.new_ptns.MainActivity;
import com.example.administrator.new_ptns.R;
import com.example.administrator.new_ptns.pager.PagerBase;
import com.google.gson.Gson;

import java.util.ArrayList;


public class PagerTiming extends PagerBase {

    ListView listView;
    Button addTiming;
    ArrayList<PagerTimingItem> list1;
    PagerTimingAdapter adapter ;
    public PagerTiming(MainActivity context){
        super(context);
    }

    @Override
    public void init_view(View view,String type){
        super.init_view(view,type);
        listView = mView.findViewById(R.id.listview1);
        list1 =  new ArrayList<>();
        //init_false_data();
        //TimeDao dao = new TimeDao(mContext);
        //dao.delete_all();
        init_data_from_database();
        adapter = new PagerTimingAdapter(mContext,list1);
        listView.setAdapter(adapter);
        addTiming = mView.findViewById(R.id.button7);
        addTiming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, NewTimingActivity.class);
                mContext.startActivity(intent);
            }
        });

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                PagerTimingItem item1 = list1.get(i);
//                Gson gson = new Gson();
//                String s1 = gson.toJson(item1);
//                Intent intent = new Intent(mContext, NewTimingActivity.class);
//                intent.putExtra("extra_value",s1);
//                mContext.startActivity(intent);
//            }
//        });
//
//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
//            @Override
//            public boolean onItemLongClick(AdapterView<?> av, View v, int pos, long id)
//            {
//                PagerTimingItem item1 = list1.get(pos);
//                Gson gson = new Gson();
//                String s1 = gson.toJson(item1);
//                Intent intent = new Intent(mContext, NewTimingActivity.class);
//                intent.putExtra("extra_value",s1);
//                mContext.startActivity(intent);
//                return true;
//            }
//        });
    }


    public void onResume(){
        if(adapter!=null) {
            TimeDao dao = new TimeDao(mContext);
            list1 = dao.getAllTimes();
            adapter = new PagerTimingAdapter(mContext,list1);
            listView.setAdapter(adapter);
        }
    }

    private void init_data_from_database(){
        TimeDao dao = new TimeDao(mContext);
        list1 = dao.getAllTimes();
        int k = 1;
    }

    private void init_false_data(){
        PagerTimingItem item = new PagerTimingItem();
        item.time_tar = "08:27";
        item.time_cal = "8小时27分后";
        item.time_day = "周一，周三，周四";
        item.open = false;
        list1.add(item);

        PagerTimingItem item1 = new PagerTimingItem();
        item1.time_tar = "08:27";
        item1.time_cal = "8小时27分后";
        item1.time_day = "周一，周三，周四";
        item1.open = true;
        list1.add(item1);

        PagerTimingItem item2 = new PagerTimingItem();
        item2.time_tar = "08:27";
        item2.time_cal = "8小时27分后";
        item2.time_day = "周一，周三，周四";
        item2.open = false;
        list1.add(item2);

        PagerTimingItem item3 = new PagerTimingItem();
        item3.time_tar = "08:27";
        item3.time_cal = "8小时27分后";
        item3.time_day = "周一，周三，周四";
        item3.open = false;
        list1.add(item3);

        PagerTimingItem item4 = new PagerTimingItem();
        item4.time_tar = "08:27";
        item4.time_cal = "8小时27分后";
        item4.time_day = "周一，周三，周四";
        item4.open = false;
        list1.add(item4);

        PagerTimingItem item5 = new PagerTimingItem();
        item5.time_tar = "08:27";
        item5.time_cal = "8小时27分后";
        item5.time_day = "周一，周三，周四";
        item5.open = false;
        list1.add(item5);

        PagerTimingItem item6 = new PagerTimingItem();
        item6.time_tar = "08:27";
        item6.time_cal = "8小时27分后";
        item6.time_day = "周一，周三，周四";
        item6.open = false;
        list1.add(item6);
    }


}

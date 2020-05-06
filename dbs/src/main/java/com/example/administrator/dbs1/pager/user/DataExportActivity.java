package com.example.administrator.dbs1.pager.user;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.administrator.dbs1.BaseActivity;
import com.example.administrator.dbs1.R;
import com.example.administrator.dbs1.history_data.HistoryData;
import com.example.administrator.dbs1.my_utils.TimeUtils;

import java.util.ArrayList;
import java.util.Date;

public class DataExportActivity extends BaseActivity {
    int current_mode = 1;
    Button mode1,mode2;
    Button save;
    DatePicker from,to;
    TextView tv_from,tv_to;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_export);
        init_view();
    }

    private void init_view(){
        from = findViewById(R.id.timePicker2);
        to = findViewById(R.id.timePicker);
        tv_from = findViewById(R.id.textView29);
        tv_to  = findViewById(R.id.textView25);
        mode1 = findViewById(R.id.button2);
        mode2 = findViewById(R.id.button3);
        save = findViewById(R.id.button);
        mode1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_set_mode1();
            }
        });
        mode2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_set_mode2();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_save();
            }
        });

//        from.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
//            @Override
//            public void onTimeChanged(TimePicker timePicker, int hourOfDay, int minute) {
//                String hourOfDay2 = String.format("%02d", hourOfDay);
//                String minute2 = String.format("%02d", minute);
//                timePickTxt.setText(hourOfDay2 + ":" + minute2);
//            }
//        });
        String t1 = TimeUtils.getTimeShort();
        String sArray[] = t1.split(":");
        final int mYear = Integer.parseInt(sArray[0]);
        final int mMonth = Integer.parseInt(sArray[1]);
        final int mDay = Integer.parseInt(sArray[2]);
//        from.getCalendarView().setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
//                String s1 = year + "-" + (month + 1) + "-" + dayOfMonth + "";
//                showToast(s1);
//            }
//        });
//
//        to.getCalendarView().setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
//                String s1 = year + "-" + (month + 1) + "-" + dayOfMonth + "";
//                showToast(s1);
//            }
//        });
        from.setMaxDate(TimeUtils.getCurrentMillis());
        to.setMaxDate(TimeUtils.getCurrentMillis());
    }

    private void do_set_mode1(){
        if(current_mode==1){
            return;
        }
        current_mode = 1;
        fresh_view();
    }

    private void do_set_mode2(){
        if(current_mode==2){
            return;
        }
        current_mode = 2;
        fresh_view();
    }

    ArrayList<HistoryData> historyDatas;
    private void do_save(){
//        String s1 = from.getYear()+"-"+(from.getMonth()+1)+"-"+from.getDayOfMonth()+" "+"00:00:00";
//        String s2 = to.getYear()+"-"+(to.getMonth()+1)+"-"+to.getDayOfMonth()+" "+"00:00:00";
//        showToast(s1);
//        HistoryDao historyDao = new HistoryDao(this);
//        historyDatas = historyDao.getAllHistorys();
//        Collections.sort(historyDatas,new Comparator<HistoryData>(){
//            @Override
//            public int compare(HistoryData b1, HistoryData b2) {
//                return b1.date.compareTo(b2.date);
//            }
//
//        });
//
//        ArrayList<HistoryData> historyData1 = get_history_date_between_long(TimeUtils.strToDateLong(s1),TimeUtils.strToDateLong(s2));
//        int fa = historyData1.size();
        //HistoryData historyData = new HistoryData();
        ExportUtils utils = new ExportUtils(this);
        utils.doExport();
    }


    public ArrayList<HistoryData> get_history_date_between_long(Date from , Date to){
        if(historyDatas.size()==0){
            return new ArrayList<>();
        }
        int top = historyDatas.size()-1;
        int bottom = 0;
        int middle = (int) ((top + bottom)*1.0 / 2);
        while(true) {
            if(top==0){
                return new ArrayList<>();
            }
            if(bottom==top){
                return new ArrayList<>();
            }
            HistoryData historyData = historyDatas.get(middle);
            String from3 = TimeUtils.dateToStrLong(from);
            String to3 = TimeUtils.dateToStrLong(to);
            String now3 = TimeUtils.dateToStrLong(historyData.date);
            int result = TimeUtils.betweenDateLong(historyData.date, from, to);
            if (result == 0) {
                ArrayList<HistoryData> list1 = new ArrayList<>();
                for (int i = middle; i < historyDatas.size(); i++) {
                    historyData = historyDatas.get(i);
                    if (TimeUtils.betweenDateLong(historyData.date, from, to) == 0) {
                        list1.add(historyData);
                    } else {
                        break;
                    }
                }
                for (int i = middle - 1; i > -1; i--) {
                    historyData = historyDatas.get(i);
                    if (TimeUtils.betweenDateLong(historyData.date, from, to) == 0) {
                        list1.add(historyData);
                    } else {
                        break;
                    }
                }
                return list1;
            } else if (result < 0) {
                bottom = middle+1;
                middle = (int)Math.floor((top + bottom)*1.0 / 2);
            } else {
                top = middle;
                middle = (int)Math.floor((top + bottom)*1.0 / 2);
            }
        }



    }




    private void fresh_view(){
        if(current_mode==1){
            mode1.setBackground(getResources().getDrawable(R.drawable.round_rec11));
            mode1.setTextColor(getResources().getColor(R.color.white));
            mode2.setBackground(null);
            mode2.setTextColor(Color.parseColor("#999999"));
            to.setVisibility(View.INVISIBLE);
            tv_to.setVisibility(View.INVISIBLE);
        }else{
            mode2.setBackground(getResources().getDrawable(R.drawable.round_rec11));
            mode2.setTextColor(getResources().getColor(R.color.white));
            mode1.setBackground(null);
            mode1.setTextColor(Color.parseColor("#999999"));
            to.setVisibility(View.VISIBLE);
            tv_to.setVisibility(View.VISIBLE);
        }
    }

}

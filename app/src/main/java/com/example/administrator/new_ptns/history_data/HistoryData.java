package com.example.administrator.new_ptns.history_data;

import com.example.administrator.new_ptns.my_utils.TimeUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class HistoryData {
    public int id;
    public String start_date;
    public int cure_last_time;
    public int template_id = 0;
    public int current_value = 0;
    public Date date;
    public Date date_long;
    public void cal(){
        String[] s1 = start_date.split(" ");
        date = TimeUtils.strToDate(s1[0]);
        //dateLong = TimeUtils.getSecondTimestamp(date);
        date_long = TimeUtils.strToDateLong(start_date);
    };

    public static ArrayList<HistoryData> get_simulation_datas(){
        ArrayList<HistoryData> list1 = new ArrayList<>();
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int date = c.get(Calendar.DATE);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);

        for(int i = 0 ; i < 1000 ;i++){
            HistoryData historyData = new HistoryData();
            year = 2010;
            month = (new Random()).nextInt(12);
            date = (new Random()).nextInt(30);
            hour = (new Random()).nextInt(24);
            minute = (new Random()).nextInt(60);
            second = 0;
            historyData.start_date = year + "-" + (month+1) + "-" + date + " " + hour  + ":" + minute + ":" + second;
            historyData.cure_last_time = (new Random()).nextInt(1800);
            list1.add(historyData);
        }
        return list1;

    }


}

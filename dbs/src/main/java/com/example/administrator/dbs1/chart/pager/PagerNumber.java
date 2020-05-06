package com.example.administrator.dbs1.chart.pager;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.dbs1.R;
import com.example.administrator.dbs1.chart.ChartManagerActivity;
import com.example.administrator.dbs1.chart.chart_item.utils.DayAxisValueFormatter;
import com.example.administrator.dbs1.chart.chart_item.utils.XYMarkerView;
import com.example.administrator.dbs1.history_data.HistoryDao;
import com.example.administrator.dbs1.history_data.HistoryData;
import com.example.administrator.dbs1.my_utils.TimeUtils;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class PagerNumber {
    private String mode;
    public ChartManagerActivity mContext;
    public View mView;
    LinearLayout button_stick,button_pie,button_line;
    TextView tv_stick,tv_pie,tv_line,from_date,to_date;
    ImageView img_stick,img_pie,img_line;
    ConstraintLayout button_from_date,button_to_date;
    Button button_day,button_year,button_month,button_week;
    public String current_time_flag = "month";
    String last_time_flag = "";
    ConstraintLayout treatment_days,untreatment_days;
    TextView tv_td,tv_utd;
    ImageView img_td,img_utd;
    Boolean is_treatment_day = true;
    private PieChart pie_chart;
    private BarChart bar_chart;
    private LineChart line_chart;
    HistoryDao historyDao;
    private String bar_style = "line";
    ArrayList<HistoryData> historyDatas;
    ArrayList<Integer> values_total_long;
    TextView tv_number,tv_danwei;
    int count = 0;
    InnerInfo info = new InnerInfo();
    HashMap<String,String> map1 = new HashMap<String, String>();
    public PagerNumber(ChartManagerActivity context){
        mContext = context;
        historyDao = new HistoryDao(mContext);
        historyDatas = historyDao.getAllHistorys();

        sortData();
//        historyDatas = new ArrayList<>();
//        for(int i = 1 ; i < 13 ;i++) {
//            int k = new Random().nextInt(5)+3;
//            for(int j = 0 ; j < k ;j++) {
//                HistoryData hd = new HistoryData();
//                hd.start_date = "2010-" + String.format("%02d", i) + "-02";
//                hd.cal();
//                historyDatas.add(hd);
//            }
//        }


    }

    private void sortData(){
        Collections.sort(historyDatas,new Comparator<HistoryData>(){
            @Override
            public int compare(HistoryData b1, HistoryData b2) {
                return b1.date.compareTo(b2.date);
            }

        });
    }


    public void init_view(View view,String type){
        mView = view;
        tv_number = mView.findViewById(R.id.textView64);
        tv_danwei = mView.findViewById(R.id.textView65);
        button_stick = mView.findViewById(R.id.button_stick);
        button_pie = mView.findViewById(R.id.button_pie);
        button_line = mView.findViewById(R.id.button_line);
        tv_stick = mView.findViewById(R.id.tv_stick);
        tv_pie = mView.findViewById(R.id.tv_pie);
        tv_line = mView.findViewById(R.id.tv_line);
        img_stick = mView.findViewById(R.id.img_stick);
        img_pie = mView.findViewById(R.id.img_pie);
        img_line = mView.findViewById(R.id.img_line);
        button_from_date = mView.findViewById(R.id.constraintLayout6);
        button_to_date = mView.findViewById(R.id.constraintLayout7);
        from_date = mView.findViewById(R.id.textView66);
        to_date = mView.findViewById(R.id.textView661);
        button_stick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bar_style = "stick";
                fresh_view();
            }
        });

        button_pie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bar_style = "pie";
                if(current_time_flag.equals("day")||current_time_flag.equals("week")){
                    current_time_flag = "month";
                }
                fresh_view();
            }
        });

        button_line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bar_style = "line";
                fresh_view();
            }
        });

        button_from_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                do_choose_from_date();

            }
        });

        button_to_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //do_choose_to_date();
            }
        });

        Calendar ca = Calendar.getInstance();
        final int mYear = ca.get(Calendar.YEAR) - 10;
        final int mMonth = ca.get(Calendar.MONTH);
        final int mDay = ca.get(Calendar.DAY_OF_MONTH);
        from_date.setText(mYear + "-" + (mMonth) + "-" + mDay + "");
        to_date.setText(mYear + "-" + (mMonth+1) + "-" + mDay + "");
        button_day = mView.findViewById(R.id.button_day);
        button_week = mView.findViewById(R.id.button_week);
        button_month = mView.findViewById(R.id.button_month);
        button_year = mView.findViewById(R.id.button_year);
        button_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_time_flag("day");
            }
        });
        button_week.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_time_flag("week");
            }
        });
        button_month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_time_flag("month");
            }
        });
        button_year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_time_flag("year");
            }
        });



        treatment_days = mView.findViewById(R.id.treatment_days);
        untreatment_days = mView.findViewById(R.id.un_treatment_days);
        treatment_days.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_choose_treatment_day();
            }
        });

        untreatment_days.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_choose_untreatment_day();
            }
        });

        img_td = mView.findViewById(R.id.img_td);
        img_utd = mView.findViewById(R.id.img_utd);
        tv_td = mView.findViewById(R.id.tv_td);
        tv_utd = mView.findViewById(R.id.tv_utd);

        pie_chart = mView.findViewById(R.id.chart1);
        bar_chart = mView.findViewById(R.id.chart2);
        line_chart = mView.findViewById(R.id.chart3);
        fresh_view();

//        Intent intent = new Intent(mContext, CubicLineChartActivity.class);
//        mContext.startActivity(intent);
    }

    private void do_choose_treatment_day(){
        is_treatment_day = true;
        img_td.setImageDrawable(mContext.getResources().getDrawable(R.drawable.cured));
        tv_td.setTextColor(mContext.getResources().getColor(R.color.green1));
        img_utd.setImageDrawable(mContext.getResources().getDrawable(R.drawable.uncured));
        tv_utd.setTextColor(mContext.getResources().getColor(R.color.gray2));
    }

    private void do_choose_untreatment_day(){
        is_treatment_day = false;
        img_utd.setImageDrawable(mContext.getResources().getDrawable(R.drawable.cured));
        tv_utd.setTextColor(mContext.getResources().getColor(R.color.green1));
        img_td.setImageDrawable(mContext.getResources().getDrawable(R.drawable.uncured));
        tv_td.setTextColor(mContext.getResources().getColor(R.color.gray2));
    }

    private void do_choose_from_date(){
        String s1 = from_date.getText().toString();
        String[] sArray = s1.split("-");
        final int mYear = Integer.parseInt(sArray[0]);
        final int mMonth = Integer.parseInt(sArray[1]);
        final int mDay = Integer.parseInt(sArray[2]);
        DatePickerDialog datePickerDialog = new DatePickerDialog(mContext, DatePickerDialog.THEME_HOLO_DARK,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        from_date.setText(year + "-" + (month + 1) + "-" + dayOfMonth + "");
                        fresh_to_date();
                        fresh_view();
                    }
                },
                mYear, mMonth-1, mDay);
        datePickerDialog.show();
    }

    private void do_choose_to_date(){
        String s1 = to_date.getText().toString();
        String[] sArray = s1.split("-");
        final int mYear = Integer.parseInt(sArray[0]);
        final int mMonth = Integer.parseInt(sArray[1]);
        final int mDay = Integer.parseInt(sArray[2]);
        DatePickerDialog datePickerDialog = new DatePickerDialog(mContext, DatePickerDialog.THEME_HOLO_DARK,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        to_date.setText(year + "-" + (month + 1) + "-" + dayOfMonth + "");
                    }
                },
                mYear, mMonth-1, mDay);
        datePickerDialog.show();
    }

    private void reset_1(){
        pie_chart.setVisibility(View.GONE);
        bar_chart.setVisibility(View.GONE);
        line_chart.setVisibility(View.GONE);
        tv_line.setTextColor(mContext.getResources().getColor(R.color.gray2));
        tv_pie.setTextColor(mContext.getResources().getColor(R.color.gray2));
        tv_stick.setTextColor(mContext.getResources().getColor(R.color.gray2));
        img_line.setImageDrawable(mContext.getResources().getDrawable(R.drawable.line_off));
        img_stick.setImageDrawable(mContext.getResources().getDrawable(R.drawable.stick_off));
        img_pie.setImageDrawable(mContext.getResources().getDrawable(R.drawable.pie_off));
        button_stick.setBackground(null);
        button_pie.setBackground(null);
        button_line.setBackground(null);
        reset_2();
    }

    private void reset_2(){

        button_day.setBackground(null);
        button_day.setTextColor(mView.getResources().getColor(R.color.gray2));
        button_week.setBackground(null);
        button_week.setTextColor(mView.getResources().getColor(R.color.gray2));
        button_month.setBackground(null);
        button_month.setTextColor(mView.getResources().getColor(R.color.gray2));
        button_year.setBackground(null);
        button_year.setTextColor(mView.getResources().getColor(R.color.gray2));
    }

    public void set_time_flag(String s1){
        current_time_flag = s1;
        if(bar_style.equals("pie")){
            if(s1.equals("day")||s1.equals("week")){
                current_time_flag = "month";
            }
        }
        fresh_view();
    }


    private void fresh_view(){
        fresh_list_data();
        if(bar_style.equals("pie")){
            do_click_pie();
        }
        if(bar_style.equals("stick")){
            do_click_stick();
        }
        if(bar_style.equals("line")){
            do_click_line();
        }
        reset_2();
        button_to_date.setVisibility(View.VISIBLE);
        if(current_time_flag=="day"){
            button_to_date.setVisibility(View.INVISIBLE);
            button_day.setBackground(mView.getResources().getDrawable(R.drawable.rect_blue));
            button_day.setTextColor(mView.getResources().getColor(R.color.white));
        }else if(current_time_flag=="month"){
            button_month.setBackground(mView.getResources().getDrawable(R.drawable.rect_blue));
            button_month.setTextColor(mView.getResources().getColor(R.color.white));
        }else if(current_time_flag=="week"){
            button_week.setBackground(mView.getResources().getDrawable(R.drawable.rect_blue));
            button_week.setTextColor(mView.getResources().getColor(R.color.white));
        }else if(current_time_flag=="year"){
            button_year.setBackground(mView.getResources().getDrawable(R.drawable.rect_blue));
            button_year.setTextColor(mView.getResources().getColor(R.color.white));
        }

        fresh_to_date();
    }

    public void set_mode(String mode1){
        mode = mode1;
        fresh_view();
    }

    private void fresh_list_data(){
        ArrayList<HistoryData> historyDataArrayList;
        Gson gson = new Gson();
        String from_date_string =  from_date.getText().toString();
        from_date_string =  TimeUtils.dateToStrLong(TimeUtils.strToDate(from_date_string));

        String key1 = from_date_string+"&"+current_time_flag;
        if(map1.containsKey(key1)){
            String s2 = map1.get(key1);
            info = gson.fromJson(s2,InnerInfo.class);
            if(mode=="long"){
                int num = 0;
                for(int i = 0 ; i < info.valueLong.size() ;i++){
                    num+=info.valueLong.get(i);
                }
                tv_number.setText(num/60 + "");
                tv_danwei.setText("分钟");
            }else {
                int num = 0;
                for(int i = 0 ; i < info.values1.size() ;i++){
                    num+=info.values1.get(i);
                }
                tv_number.setText(num + "");
                tv_danwei.setText("次");
            }
            return;
        }

        Date FromDate = TimeUtils.strToDateLong(from_date_string);
        info.values1 = new ArrayList<>();
        info.valueLong = new ArrayList<>();
        if(current_time_flag == "day"){
            count = 6;
            String FromDataString = from_date_string;
            for(int i = 0 ; i < count ; i++){
                String NextDateStr = TimeUtils.getNextHour(FromDataString,4);
                historyDataArrayList = get_history_date_between_long(TimeUtils.strToDate(FromDataString), TimeUtils.strToDate(NextDateStr));
                FromDataString = NextDateStr;
                info.values1.add(historyDataArrayList.size());
                int total_long = 0;
                for(int k = 0 ; k < historyDataArrayList.size();k++){
                    total_long = total_long + historyDataArrayList.get(k).cure_last_time;
                }
                info.valueLong.add(total_long);
            }
        }else if(current_time_flag == "week"){
            count = 7;
            String FromDataString = from_date_string;
            for(int i = 0 ; i < count ; i++){
                String NextDateStr = TimeUtils.getNextDayLong(FromDataString);
                historyDataArrayList = get_history_date_between_long(TimeUtils.strToDateLong(FromDataString), TimeUtils.strToDateLong(NextDateStr));
                FromDataString = NextDateStr;
                info.values1.add(historyDataArrayList.size());
                int total_long = 0;
                for(int k = 0 ; k < historyDataArrayList.size();k++){
                    total_long = total_long + historyDataArrayList.get(k).cure_last_time;
                }
                info.valueLong.add(total_long);
            }
        }else if(current_time_flag == "month"){
            count = TimeUtils.getDaysofMonth(FromDate);
            String FromDataString = from_date_string;
            info.cure_days = 0;
            info.un_cure_days = 0;
            for(int i = 0 ; i < count ; i++){
                String NextDateStr = TimeUtils.getNextDayLong(FromDataString);
                historyDataArrayList = get_history_date_between_long(TimeUtils.strToDateLong(FromDataString), TimeUtils.strToDateLong(NextDateStr));
                FromDataString = NextDateStr;
                if(historyDataArrayList.size()>0){
                    info.cure_days+=1;
                }else{
                    info.un_cure_days+=1;
                }
                info.values1.add(historyDataArrayList.size());
                int total_long = 0;
                for(int k = 0 ; k < historyDataArrayList.size();k++){
                    total_long = total_long + historyDataArrayList.get(k).cure_last_time;
                }
                info.valueLong.add(total_long);
            }
        }else if(current_time_flag == "year"){
            count = 12;
            String FromDataString = from_date_string;
            for(int i = 0 ; i < count ; i++){
                String NextDateStr = TimeUtils.getNextMonthLong(FromDataString);
                historyDataArrayList = get_history_date_between_long(TimeUtils.strToDateLong(FromDataString), TimeUtils.strToDateLong(NextDateStr));
                FromDataString = NextDateStr;
                info.values1.add(historyDataArrayList.size());
                int total_long = 0;
                for(int k = 0 ; k < historyDataArrayList.size();k++){
                    total_long = total_long + historyDataArrayList.get(k).cure_last_time;
                }
                info.valueLong.add(total_long);
            }

            info.cure_days = 0;
            info.un_cure_days = 0;
            FromDataString = from_date_string;
            for(int i = 0 ; i <365;i++){
                String NextDateStr = TimeUtils.getNextDayLong(FromDataString);
                historyDataArrayList = get_history_date_between_long(TimeUtils.strToDateLong(FromDataString), TimeUtils.strToDateLong(NextDateStr));
                FromDataString = NextDateStr;
                if(historyDataArrayList.size()>0){
                    info.cure_days+=1;
                }else{
                    info.un_cure_days+=1;
                }
            }
        }
        if(mode=="long"){
            int num = 0;
            for(int i = 0 ; i < info.valueLong.size() ;i++){
                num+=info.valueLong.get(i);
            }
            tv_number.setText(num/60 + "");
            tv_danwei.setText("分钟");
        }else {
            int num = 0;
            for(int i = 0 ; i < info.values1.size() ;i++){
                num+=info.values1.get(i);
            }
            tv_number.setText(num + "");
            tv_danwei.setText("次");
        }



        String s1 = gson.toJson(info);
        map1.put(key1,s1);
    }

    private void fresh_to_date(){
        String s1 = from_date.getText().toString();
        if(current_time_flag=="day"){

        }else if(current_time_flag=="week"){
            to_date.setText(TimeUtils.getNextWeek(s1));
        }else if(current_time_flag=="month"){
            to_date.setText(TimeUtils.getNextMonth(s1));
        }else if(current_time_flag=="year"){
            to_date.setText(TimeUtils.getNextYear(s1));
        }
    }

    private void do_click_stick(){
        reset_1();
        tv_stick.setTextColor(mContext.getResources().getColor(R.color.white));
        img_stick.setImageDrawable(mContext.getResources().getDrawable(R.drawable.stick_on));
        button_week.setVisibility(View.VISIBLE);
        button_day.setVisibility(View.VISIBLE);
        button_stick.setBackground(mContext.getResources().getDrawable(R.drawable.sad));
        show_bar_chart();
    }
    private void do_click_pie(){
        reset_1();
        tv_pie.setTextColor(mContext.getResources().getColor(R.color.white));
        img_pie.setImageDrawable(mContext.getResources().getDrawable(R.drawable.pie_on));
        button_week.setVisibility(View.GONE);
        button_day.setVisibility(View.GONE);
        button_pie.setBackground(mContext.getResources().getDrawable(R.drawable.sad));
        show_pie_chart();

    }
    private void do_click_line(){
        reset_1();
        tv_line.setTextColor(mContext.getResources().getColor(R.color.white));
        img_line.setImageDrawable(mContext.getResources().getDrawable(R.drawable.line_on));
        button_week.setVisibility(View.VISIBLE);
        button_day.setVisibility(View.VISIBLE);
        button_line.setBackground(mContext.getResources().getDrawable(R.drawable.sad));
        show_line_chart();
    }


    private void show_line_chart(){


        ValueFormatter xAxisFormatter = new DayAxisValueFormatter(bar_chart);
        XAxis xAxis = bar_chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f); // only intervals of 1 day
        xAxis.setLabelCount(7);
        xAxis.setValueFormatter(xAxisFormatter);
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return getXAxisLabel(value);
            }
        });
        YAxis y = line_chart.getAxisLeft();
        y.setLabelCount(12, false);
        y.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        float[] dash1 = new float[]{30.0f,30.0f};
        y.setGridDashedLine(new DashPathEffect(dash1,1.0f));
        y.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {

                return (int)(value)+"次";
            }
        });
        line_chart.setVisibility(View.VISIBLE);
        line_chart.getDescription().setEnabled(false);
        line_chart.getAxisRight().setEnabled(false);
        line_chart.getLegend().setEnabled(false);
        line_chart.invalidate();
        setLineData();
    }

    private void show_bar_chart(){
        bar_chart.setVisibility(View.VISIBLE);
        bar_chart.setDrawBarShadow(false);
        bar_chart.setDrawValueAboveBar(true);
        bar_chart.getDescription().setEnabled(false);
        bar_chart.setMaxVisibleValueCount(60);
        bar_chart.setPinchZoom(false);
        bar_chart.setDrawGridBackground(false);
        ValueFormatter xAxisFormatter = new DayAxisValueFormatter(bar_chart);
        XAxis xAxis = bar_chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f); // only intervals of 1 day
        xAxis.setLabelCount(7);
        xAxis.setDrawGridLines(false);
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return getXAxisLabel(value);
            }
        });
        YAxis leftAxis = bar_chart.getAxisLeft();
        leftAxis.setLabelCount(8, false);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setSpaceTop(15f);
        //leftAxis.setDrawGridLines(true);
        //leftAxis.setGridColor(mContext.getResources().getColor(R.color.green1));
        float[] dash1 = new float[]{30.0f,30.0f};
            leftAxis.setGridDashedLine(new DashPathEffect(dash1,1.0f));
        //leftAxis.setAxisLineDashedLine(new DashPathEffect(dash1,6.0f));
        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)
        leftAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                if(mode=="long"){
                    return (int)(value/60)+"分钟";
                }
                return (int)(value)+"次";
            }
        });
        YAxis rightAxis = bar_chart.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setLabelCount(8, false);
        rightAxis.setSpaceTop(15f);
        rightAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)
        bar_chart.getAxisRight().setEnabled(false);
        Legend l = bar_chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setForm(Legend.LegendForm.SQUARE);
        l.setFormSize(9f);
        l.setTextSize(11f);
        l.setXEntrySpace(4f);
        bar_chart.getLegend().setEnabled(false);
        XYMarkerView mv = new XYMarkerView(mContext, xAxisFormatter);
        mv.setChartView(bar_chart); // For bounds control
        setBarData();
    }

    private String getXAxisLabel(float value){
        if(current_time_flag.equals("year")) {
            if(value<0.01){
                return "1月";
            }
            else if (0.99 < value && value < 1.01) {
                return "2月";
            }else if(1.99 < value && value < 2.01) {
                return "3月";
            }else if(2.99 < value && value < 3.01) {
                return "4月";
            }else if(3.99 < value && value < 4.01) {
                return "5月";
            }else if(4.99 < value && value < 5.01) {
                return "6月";
            }else if(5.99 < value && value < 6.01) {
                return "7月";
            }else if(6.99 < value && value < 7.01) {
                return "8月";
            }else if(7.99 < value && value < 8.01) {
                return "9月";
            }else if(8.99 < value && value < 9.01) {
                return "10月";
            }else if(9.99 < value && value < 10.01) {
                return "11月";
            }else if(10.99 < value && value < 11.01) {
                return "12月";
            }
        }else if(current_time_flag=="month"){
            return (int)(value+1)+"";
        }else if(current_time_flag=="week"){
            if(5.99<value &&value<6.01){
                return "周日";
            }else{
                return "周"+(int)(value+1);
            }
        }else{
            return String.format("%02d",(int)(value*4))+":00";
        }
        return (int)(value)+"";
    }

    private void setLineData() {
        ArrayList<Entry> values = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            values.add(new Entry(i, info.values1.get(i)));
        }

        LineDataSet set1;

        if (line_chart.getData() != null &&
                line_chart.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet) line_chart.getData().getDataSetByIndex(0);
            set1.setValues(values);
            line_chart.getData().notifyDataChanged();
            line_chart.notifyDataSetChanged();
        } else {
            // create a dataset and give it a type
            set1 = new LineDataSet(values, "");
            set1.setLineWidth(2.75f);
            set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);
            set1.setCubicIntensity(0.2f);
            set1.setDrawFilled(true);
            set1.setDrawCircles(false);
            set1.setHighLightColor(mContext.getResources().getColor(R.color.green1));
            set1.setColor(mContext.getResources().getColor(R.color.green1));

            set1.setDrawHorizontalHighlightIndicator(false);
            set1.setFillFormatter(new IFillFormatter() {
                @Override
                public float getFillLinePosition(ILineDataSet dataSet, LineDataProvider dataProvider) {
                    return line_chart.getAxisLeft().getAxisMinimum();
                }
            });
            set1.setFillColor(mContext.getResources().getColor(R.color.green2));
            //set1.setFillAlpha(100);

            // create a data object with the data sets
            LineData data = new LineData(set1);
            data.setValueTextSize(9f);
            data.setDrawValues(false);

            // set data
            line_chart.setData(data);
        }
    }



    private void setBarData(){


        ArrayList<BarEntry> values = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if(mode=="long"){
                values.add(new BarEntry(i, info.valueLong.get(i)));
            }else {
                values.add(new BarEntry(i, info.values1.get(i)));
            }
        }


        List<Integer> colors = new ArrayList<>();
        colors.add(mContext.getResources().getColor(R.color.green1));
        BarDataSet set;
        if (bar_chart.getData() != null &&
                bar_chart.getData().getDataSetCount() > 0) {
            set = (BarDataSet) bar_chart.getData().getDataSetByIndex(0);
            set.setValues(values);
            bar_chart.getData().notifyDataChanged();
            bar_chart.notifyDataSetChanged();
        } else {
            set = new BarDataSet(values, "治疗次数");
            set.setColors(colors);
            set.setValueTextColors(colors);

            BarData data = new BarData(set);
            data.setValueTextSize(13f);
            data.setValueFormatter(new ValueFormatter() {
                @Override
                public String getFormattedValue(float value) {
                    return (int)(value)+"";
                }
            });
            data.setBarWidth(0.8f);

            bar_chart.setData(data);
            bar_chart.invalidate();
        }
    }

    private void show_pie_chart(){
        pie_chart.setVisibility(View.VISIBLE);

        pie_chart.setUsePercentValues(true);
        pie_chart.getDescription().setEnabled(false);
        pie_chart.setExtraOffsets(5, 10, 5, 5);
        pie_chart.getLegend().setEnabled(false);
        setPieData();
    }

    protected final String[] parties = new String[] {
            "治疗", "未治疗"
    };

    private void setPieData() {
        ArrayList<PieEntry> entries = new ArrayList<>();


        ArrayList<Integer> values2 = new ArrayList<>();
        values2.add(info.cure_days);
        values2.add(info.un_cure_days);
        for (int i = 0; i < 2 ; i++) {
            entries.add(new PieEntry(values2.get(i),
                    parties[i]));
        }

        PieDataSet dataSet = new PieDataSet(entries,"治疗次数");

        dataSet.setDrawIcons(false);

        dataSet.setSliceSpace(3f);
        dataSet.setIconsOffset(new MPPointF(0, 40));
        dataSet.setSelectionShift(5f);

        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(mContext.getResources().getColor(R.color.green1));
        colors.add(mContext.getResources().getColor(R.color.gray2));
        dataSet.setColors(colors);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter(pie_chart));
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
        pie_chart.setData(data);

        // undo all highlights
        pie_chart.highlightValues(null);

        pie_chart.invalidate();
    }


    public ArrayList<HistoryData> get_history_date_between(Date from ,Date to){
        ArrayList<HistoryData> list1 = new ArrayList<>();
        for(int i = 0 ; i < historyDatas.size() ; i++){
            HistoryData historyData = historyDatas.get(i);
            if(TimeUtils.betweenDate(historyData.date,from,to)){
                list1.add(historyData);
            }
        }
        return list1;
    }

//    public ArrayList<HistoryData> get_history_datas(Context context,Date from ,Date to){
//        historyDao = new HistoryDao(mContext);
//        historyDatas = historyDao.getAllHistorys();
//        return get_history_date_between_long(from,to);
//    }

    public ArrayList<HistoryData> get_history_date_between_long(Date from ,Date to){
//        ArrayList<HistoryData> list1 = new ArrayList<>();
//        for(int i = 0 ; i < historyDatas.size() ; i++){
//            HistoryData historyData = historyDatas.get(i);
//            String source1 = TimeUtils.dateToStrLong(historyData.date_long);
//            String from1 = TimeUtils.dateToStrLong(from);
//            String to1 = TimeUtils.dateToStrLong(to);
//            if(TimeUtils.betweenDateLong(historyData.date,from,to)){
//                list1.add(historyData);
//            }
//        }



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

    private class InnerInfo{
        public ArrayList<Integer> valueLong;
        public ArrayList<Integer> values1;
        public int cure_days;
        public int un_cure_days;
        public String type;
        public InnerInfo(){
            values1 = new ArrayList<>();
            valueLong = new ArrayList<>();
            cure_days = 0;
            un_cure_days = 0;
        }
    }
}

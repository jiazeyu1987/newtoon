package com.example.administrator.new_ptns.chart;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.new_ptns.R;
import com.example.administrator.new_ptns.chart.chart_item.unit.BarChartActivity;
import com.example.administrator.new_ptns.chart.chart_item.unit.PieChartActivity;
import com.example.administrator.new_ptns.custom_item.NoSlideViewPage;

import java.util.ArrayList;
import java.util.List;

public class ChartManagerActivity extends AppCompatActivity {
    private NoSlideViewPage viewPager;
    private List<View> viewList = new ArrayList<>();
    private int[] drawableIds = new int[] {R.mipmap.me, R.mipmap.timing};
    private List<Integer> drawableList;
    ChartPagerAdapter myPagerAdapter;

    ConstraintLayout button_number,button_long;
    TextView tv_number,tv_long;
    LinearLayout b_number,b_long;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_manager);
        viewPager = findViewById(R.id.view_pager);
        tv_number = findViewById(R.id.textView2);
        tv_long = findViewById(R.id.textView44);
        b_number = findViewById(R.id.dsdfs);
        b_long = findViewById(R.id.sdfsdfa);
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.chart_viewpager_item1, null);
        viewList.add(view);
        view = inflater.inflate(R.layout.chart_viewpager_item2, null);
        viewList.add(view);

        drawableList = new ArrayList<Integer>();
        drawableList.add(drawableIds[drawableIds.length - 1]);
        for (int id : drawableIds) {
            drawableList.add(id);
        }
        drawableList.add(drawableIds[0]);


        myPagerAdapter = new ChartPagerAdapter(ChartManagerActivity.this, viewList, drawableList);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                set_page(i);
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        set_page(0);

        button_number = findViewById(R.id.button_number);
        button_long = findViewById(R.id.button_long);
        button_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fresh_bottom();
                tv_number.setTextColor(getResources().getColor(R.color.green1));
                b_number.setBackgroundColor(getResources().getColor(R.color.green1));
                //myPagerAdapter.pagerNumber.set_mode("number");
            }
        });

        button_long.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fresh_bottom();
                tv_long.setTextColor(getResources().getColor(R.color.green1));
                b_long.setBackgroundColor(getResources().getColor(R.color.green1));
                //myPagerAdapter.pagerNumber.set_mode("long");
            }
        });


        viewPager.setAdapter(myPagerAdapter);
//        Intent intent = new Intent(this, BarChartActivity.class);
//        startActivity(intent);
    }

    private void set_page(int i){
        fresh_bottom();
        if(i==0){
            tv_number.setTextColor(getResources().getColor(R.color.green1));
            b_number.setBackgroundColor(getResources().getColor(R.color.green1));
            viewPager.setCurrentItem(0, false);
        }
        if(i==1){
            tv_long.setTextColor(getResources().getColor(R.color.green1));
            b_long.setBackgroundColor(getResources().getColor(R.color.green1));
            viewPager.setCurrentItem(1, false);
        }
    }

    private void fresh_bottom(){
        tv_number.setTextColor(getResources().getColor(R.color.gray2));
        b_number.setBackgroundColor(getResources().getColor(R.color.gray3));
        tv_long.setTextColor(getResources().getColor(R.color.gray2));
        b_long.setBackgroundColor(getResources().getColor(R.color.gray3));
    }
}

package com.example.administrator.new_ptns;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.blankj.utilcode.util.ToastUtils;
import com.example.administrator.new_ptns.custom_item.CustomItemA1;
import com.example.administrator.new_ptns.data_handler.ContactDao;
import com.example.administrator.new_ptns.pager.MyPagerAdapter;
import com.example.administrator.new_ptns.pager.shuqian.AddressPickTask;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.addapp.pickers.entity.City;
import cn.addapp.pickers.entity.County;
import cn.addapp.pickers.entity.Province;


public class MainActivity extends BaseActivity {

    public CustomItemA1 ci1_name;
    @BindView(R.id.button28)
    public Button shuqian;
    @BindView(R.id.button29)
    public Button shuzhong;
    @BindView(R.id.button26)
    public Button debug;
    @BindView(R.id.button27)
    public Button patient_info;
    @BindView(R.id.vp1)
    public ViewPager viewPager;

    public MyPagerAdapter myPagerAdapter;
    private List<View> viewList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nt_main);

        ButterKnife.bind(this);
        init_view();

        ContactDao dao = new ContactDao(this);
        dao.delete_all();
    }


    private void init_view(){
        shuqian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_click_shuqian();
            }
        });

        shuzhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_click_shuzhong();
            }
        });

        debug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_click_debug();
            }
        });

        patient_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_click_patient_info();
            }
        });


        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.pager_nt_main_1, null);
        viewList.add(view);
        view = inflater.inflate(R.layout.pager_nt_main_2, null);
        viewList.add(view);
        view = inflater.inflate(R.layout.pager_nt_main_3, null);
        viewList.add(view);
        view = inflater.inflate(R.layout.pager_nt_main_4, null);
        viewList.add(view);

        myPagerAdapter = new MyPagerAdapter(MainActivity.this, viewList, null);
        viewPager.setAdapter(myPagerAdapter);
    }

    private void do_click_shuqian(){
        set_choosen(shuqian);
        viewPager.setCurrentItem(0, false);
    }

    private void do_click_shuzhong(){
        set_choosen(shuzhong);
        viewPager.setCurrentItem(1, false);
    }

    private void do_click_debug(){
        set_choosen(debug);
        viewPager.setCurrentItem(2, false);



    }

    private void do_click_patient_info(){
        set_choosen(patient_info);
        viewPager.setCurrentItem(3, false);
    }



    private void set_choosen(Button button){
        shuqian.setBackgroundColor(getResources().getColor(R.color.white));
        shuzhong.setBackgroundColor(getResources().getColor(R.color.white));
        debug.setBackgroundColor(getResources().getColor(R.color.white));
        patient_info.setBackgroundColor(getResources().getColor(R.color.white));
        button.setBackgroundColor(getResources().getColor(R.color.green2));
    }

}


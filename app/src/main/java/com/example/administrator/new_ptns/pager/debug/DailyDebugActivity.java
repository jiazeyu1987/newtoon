package com.example.administrator.new_ptns.pager.debug;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.new_ptns.BaseActivity;
import com.example.administrator.new_ptns.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DailyDebugActivity extends BaseActivity {


    @BindView(R.id.btn_impedance)
    Button btnImpedance;
    @BindView(R.id.btn_paras)
    Button btnParas;
    @BindView(R.id.btn_debug)
    Button btnDebug;
    @BindView(R.id.viewPager1)
    ViewPager viewPager1;
    @BindView(R.id.btn_return)
    TextView btnReturn;
    private List<View> viewList = new ArrayList<>();
    DailyDebugAdapter myPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_debug);
        ButterKnife.bind(this);


        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.pager_nt_two_1, null);
        viewList.add(view);
        view = inflater.inflate(R.layout.pager_nt_two_3, null);
        viewList.add(view);
        view = inflater.inflate(R.layout.pager_nt_two_2, null);
        viewList.add(view);

        myPagerAdapter = new DailyDebugAdapter(DailyDebugActivity.this, viewList, null);
        viewPager1.setAdapter(myPagerAdapter);
        if(G.TEST){
            btnDebug.performClick();
        }
    }


    @OnClick({R.id.btn_impedance, R.id.btn_paras, R.id.btn_debug})
    public void onClick(View view) {
        btnParas.setBackground(getResources().getDrawable(R.drawable.rect1));
        btnImpedance.setBackground(getResources().getDrawable(R.drawable.rect1));
        btnDebug.setBackground(getResources().getDrawable(R.drawable.rect1));
        switch (view.getId()) {
            case R.id.btn_impedance:
                btnImpedance.setBackground(getResources().getDrawable(R.drawable.rect_blue));
                viewPager1.setCurrentItem(0);
                break;
            case R.id.btn_paras:
                btnParas.setBackground(getResources().getDrawable(R.drawable.rect_blue));
                viewPager1.setCurrentItem(1);
                break;
            case R.id.btn_debug:
                btnDebug.setBackground(getResources().getDrawable(R.drawable.rect_blue));
                viewPager1.setCurrentItem(2);
                break;
        }
    }

    @OnClick(R.id.btn_return)
    public void onClick() {
        finish();
    }
}

package com.example.administrator.new_ptns.pager.debug.pager;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.administrator.new_ptns.R;
import com.example.administrator.new_ptns.custom_item.CustomItemA3p1;
import com.example.administrator.new_ptns.custom_item.CustomItemA7;
import com.example.administrator.new_ptns.custom_item.CustomItemA8;
import com.example.administrator.new_ptns.pager.debug.DailyDebugActivity;
import com.kyleduo.switchbutton.SwitchButton;


public class PagerStimDebug {

    public DailyDebugActivity mContext;
    public View mView;


    public SwitchButton vc_switch;
    public CustomItemA3p1 soft_boot,soft_stop;
    public Button btn_LSTN,btn_RSTN,btn_syn_to_side;
    public CheckBox stim_real_time,complex_solution;
    public CustomItemA8 channel1,channel2,channel3,channel4,channel5;
    public CustomItemA7 solution1,solution2;
    public CustomItemA3p1 range_auth,freq_auth,pulse_auth;

    public Button start_stim,save_report,shut_down_stim;

    public boolean is_realtime = false;
    public String current_side = "left";
    public String vc_type = "current";
    public PagerStimDebug(DailyDebugActivity context){
        mContext = context;
    }

    public void init_view(View view){
        mView = view;
        vc_switch = mView.findViewById(R.id.switch2);
        soft_boot = mView.findViewById(R.id.soft_boot);
        soft_stop = mView.findViewById(R.id.soft_stop);
        btn_LSTN = mView.findViewById(R.id.button41);
        btn_RSTN = mView.findViewById(R.id.button40);
        //btn_syn_to_side = mView.findViewById(R.id.switch2);
        stim_real_time = mView.findViewById(R.id.checkBox7);
        complex_solution = mView.findViewById(R.id.checkBox6);
        channel1 = mView.findViewById(R.id.customItemA82);
        channel2 = mView.findViewById(R.id.customItemA83);
        channel3 = mView.findViewById(R.id.customItemA84);
        channel4 = mView.findViewById(R.id.customItemA85);
        channel5 = mView.findViewById(R.id.customItemA18);
        solution1 = mView.findViewById(R.id.customItemA7);
        solution2 = mView.findViewById(R.id.asdgafdgad);

        range_auth = mView.findViewById(R.id.customItemA3p12);
        freq_auth = mView.findViewById(R.id.customItemA3p13);
        pulse_auth = mView.findViewById(R.id.customItemA3p14);

        start_stim = mView.findViewById(R.id.button422);
        save_report = mView.findViewById(R.id.button412);
        shut_down_stim = mView.findViewById(R.id.button42);
        start_stim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_start_stim();
            }
        });

        save_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_save_report();
            }
        });

        shut_down_stim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_shut_down_stim();
            }
        });

        complex_solution.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    change_to_solution("complex");
                }else{
                    change_to_solution("simple");
                }
            }
        });

        stim_real_time.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                change_real_time(b);
            }
        });

        btn_LSTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_choose_side("left");
            }
        });

        btn_RSTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_choose_side("right");
            }
        });

        vc_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                do_choose_vc(b);
            }
        });
        do_choose_side("left");
        range_auth.setDataList("请选择幅度范围",new String[]{"禁止","加减0.2","加减0.4","加减0.6","加减0.8","加减1.0","加减1.5","加减2.0","其他"});
        freq_auth.setDataList("请选择频率范围",new String[]{"禁止","加减10","加减20","加减30","加减40","加减50","其他"});
        pulse_auth.setDataList("请选择脉宽范围",new String[]{"禁止","加减10","加减20","加减30","加减40","加减50","加减60","加减70","加减80","加减90","加减100","其他"});
        soft_boot.setDataList("请选择软启动时间",new String[]{"关闭","1s","2s","3s","4s","5s","6s","7s","8s","9s","10s"});
        soft_stop.setDataList("请选择软停止时间",new String[]{"关闭","1s","2s","3s","4s","5s","6s","7s","8s","9s","10s"});
    }

    public void onResume(){

    }

    private void do_start_stim(){}
    private void do_save_report(){}
    private void do_shut_down_stim(){}
    private void change_to_solution(String type){
        if(type=="complex"){

        }else{

        }
    }
    private void change_real_time(boolean b1){
        is_realtime = b1;
        //TODO
    }

    private void do_choose_side(String side){
        current_side = side;
        btn_LSTN.setTextColor(mContext.getResources().getColor(R.color.green2));
        btn_RSTN.setTextColor(mContext.getResources().getColor(R.color.green2));
        btn_LSTN.setBackgroundColor(mContext.getResources().getColor(R.color.white));
        btn_RSTN.setBackgroundColor(mContext.getResources().getColor(R.color.white));
        if(current_side=="left"){
            btn_LSTN.setTextColor(mContext.getResources().getColor(R.color.white));
            btn_LSTN.setBackgroundColor(mContext.getResources().getColor(R.color.green2));
        }else{
            btn_RSTN.setTextColor(mContext.getResources().getColor(R.color.white));
            btn_RSTN.setBackgroundColor(mContext.getResources().getColor(R.color.green2));
        }
    }

    private void do_choose_vc(boolean b){
        //todo
    }
}


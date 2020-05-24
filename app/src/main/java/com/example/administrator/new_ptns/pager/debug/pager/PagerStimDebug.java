package com.example.administrator.new_ptns.pager.debug.pager;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.blankj.utilcode.util.ToastUtils;
import com.example.administrator.new_ptns.R;
import com.example.administrator.new_ptns.custom_item.CustomItemA3p1;
import com.example.administrator.new_ptns.custom_item.CustomItemA7;
import com.example.administrator.new_ptns.custom_item.CustomItemA8;
import com.example.administrator.new_ptns.data_handler.SolutionBigData;
import com.example.administrator.new_ptns.data_handler.SolutionData;
import com.example.administrator.new_ptns.data_handler.StimDebugData;
import com.example.administrator.new_ptns.pager.debug.DailyDebugActivity;
import com.kyleduo.switchbutton.SwitchButton;


public class PagerStimDebug {

    public DailyDebugActivity mContext;
    public View mView;


    public SwitchButton vc_switch;
    public CustomItemA3p1 soft_boot,soft_stop;
    public Button btn_LSTN,btn_RSTN,btn_syn_to_side;
    public CheckBox cb_stim_real_time,cb_complex_solution;
    public CustomItemA3p1 range_auth,freq_auth,pulse_auth,lasttime_auth;

    public Button start_stim,save_report,shut_down_stim;
    CustomItemA8 btn_channel1,btn_channel2,btn_channel3,btn_channel4,btn_channel5;
    public String current_side = "left";
    public String vc_mode = "current";
    CustomItemA7 ci_solution1,ci_solution2;
    public SolutionBigData left_data = new SolutionBigData();
    public SolutionBigData right_data = new SolutionBigData();
    public StimDebugData data = null;
    public PagerStimDebug(DailyDebugActivity context){
        mContext = context;
    }

    public void init_view(View view){
        mView = view;
        btn_syn_to_side = mView.findViewById(R.id.button10);
        vc_switch = mView.findViewById(R.id.switch2);
        soft_boot = mView.findViewById(R.id.soft_boot);
        soft_stop = mView.findViewById(R.id.soft_stop);
        btn_LSTN = mView.findViewById(R.id.button41);
        btn_RSTN = mView.findViewById(R.id.button40);
        //btn_syn_to_side = mView.findViewById(R.id.switch2);
        cb_stim_real_time = mView.findViewById(R.id.checkBox7);
        cb_complex_solution = mView.findViewById(R.id.checkBox6);
        btn_channel1 = mView.findViewById(R.id.customItemA82);
        btn_channel2 = mView.findViewById(R.id.customItemA83);
        btn_channel3 = mView.findViewById(R.id.customItemA84);
        btn_channel4 = mView.findViewById(R.id.customItemA85);
        btn_channel5 = mView.findViewById(R.id.customItemA18);
        ci_solution1 = mView.findViewById(R.id.customItemA7);
        ci_solution2 = mView.findViewById(R.id.asdgafdgad);

        range_auth = mView.findViewById(R.id.customItemA3p12);
        freq_auth = mView.findViewById(R.id.customItemA3p13);
        pulse_auth = mView.findViewById(R.id.customItemA3p14);
        lasttime_auth = mView.findViewById(R.id.dfgsdfgsdg);
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

        cb_complex_solution.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                change_to_solution(b);
            }
        });

        cb_stim_real_time.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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


        btn_syn_to_side.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                do_syn();
            }
        });
        set_solutionBigData();
        do_choose_side("left");
        lasttime_auth.setDataList("清选择持续时间",new String[]{"允许","禁止"});
        range_auth.setDataList("请选择幅度范围",new String[]{"禁止","加减0.2","加减0.4","加减0.6","加减0.8","加减1.0","加减1.5","加减2.0","其他"});
        freq_auth.setDataList("请选择频率范围",new String[]{"禁止","加减10","加减20","加减30","加减40","加减50","其他"});
        pulse_auth.setDataList("请选择脉宽范围",new String[]{"禁止","加减10","加减20","加减30","加减40","加减50","加减60","加减70","加减80","加减90","加减100","其他"});
        soft_boot.setDataList("请选择软启动时间",new String[]{"关闭","1s","2s","3s","4s","5s","6s","7s","8s","9s","10s"});
        soft_stop.setDataList("请选择软停止时间",new String[]{"关闭","1s","2s","3s","4s","5s","6s","7s","8s","9s","10s"});
    }

    private void update_solutionBigData(){
        SolutionBigData target_data;
        if(current_side == "left"){
            target_data = left_data;
        }else{
            target_data = right_data;
        }
        target_data.solutionData1 = ci_solution1.getSolutionData();
        target_data.solutionData2 = ci_solution2.getSolutionData();
        ToastUtils.showShort(target_data.solutionData1.get_vcmode());
        ci_solution1.update_vcmode(target_data.solutionData1.get_vcmode());
        ci_solution2.update_vcmode(target_data.solutionData2.get_vcmode());
        target_data.realtime = cb_stim_real_time.isChecked();
        target_data.complex = cb_complex_solution.isChecked();
        target_data.channel1 = btn_channel1.getBtnText();
        target_data.channel2 = btn_channel2.getBtnText();
        target_data.channel3 = btn_channel3.getBtnText();
        target_data.channel4 = btn_channel4.getBtnText();
        target_data.channel5 = btn_channel5.getBtnText();

    }

    private void set_solutionBigData(){
        SolutionBigData target_data;
        if(current_side == "left"){
            target_data = left_data;
        }else{
            target_data = right_data;
        }
        ci_solution1.setSolutionData(target_data.solutionData1);
        ci_solution2.setSolutionData(target_data.solutionData2);
        cb_stim_real_time.setChecked(target_data.realtime);
        cb_complex_solution.setChecked(target_data.complex);
        btn_channel1.setBtnText(target_data.channel1);
        btn_channel2.setBtnText(target_data.channel2);
        btn_channel3.setBtnText(target_data.channel3);
        btn_channel4.setBtnText(target_data.channel4);
        btn_channel5.setBtnText(target_data.channel5);
        change_to_solution(target_data.complex);
    }

    private void do_syn(){
        if(current_side=="left"){
            update_solutionBigData();
            right_data = new SolutionBigData(left_data);
            do_choose_side("right");
        }else{
            update_solutionBigData();
            left_data = new SolutionBigData(right_data);
            do_choose_side("left");
        }
    }

    public void onResume(){

    }

    private void do_start_stim(){}
    private void do_save_report(){}
    private void do_shut_down_stim(){}
    private void change_to_solution(boolean b1){
        if(b1){
            ci_solution1.setMode2();
            ci_solution2.setVisibility(View.VISIBLE);
        }else{
            ci_solution1.setMode1();
            ci_solution2.setVisibility(View.INVISIBLE);
        }
    }
    private void change_real_time(boolean b1){
        //TODO
    }



    private void do_choose_side(String side){
        if(current_side == side){
            return;
        }
        update_solutionBigData();
        current_side = side;
        set_solutionBigData();
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
        if(b){
            vc_mode = "current";
        }else{
            vc_mode = "voltage";
        }
        left_data.set_vcmode(vc_mode);
        right_data.set_vcmode(vc_mode);
        update_solutionBigData();
    }
}


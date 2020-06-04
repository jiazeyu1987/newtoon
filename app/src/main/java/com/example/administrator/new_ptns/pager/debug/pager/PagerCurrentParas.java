package com.example.administrator.new_ptns.pager.debug.pager;

import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.administrator.new_ptns.R;
import com.example.administrator.new_ptns.custom_item.CustomItemA1;
import com.example.administrator.new_ptns.data_handler.DailyStimBundle;
import com.example.administrator.new_ptns.pager.debug.DailyDebugActivity;
import com.example.administrator.new_ptns.pager.shuzhong.OperationTestingActivity;


public class PagerCurrentParas {

    public DailyDebugActivity mContext;
    public View mView;

    public TextView[] rangeArray;
    public TextView[] freqArray;
    public TextView[] pulseArray;

    public TableLayout table1,table2;
    public ImageView tableImage1,tableImage2;
    public CustomItemA1 soft_boot,soft_stop;
    public TextView range_range_left = null;
    public TextView range_freq_left = null;
    public TextView range_pulse_left = null;
    public TextView range_time_left = null;
    public TextView range_range_right = null;
    public TextView range_freq_right = null;
    public TextView range_pulse_right = null;
    public TextView range_time_right = null;

    public CustomItemA1 run_state,battery,inner_clock;

    DailyStimBundle bundle;


    public PagerCurrentParas(DailyDebugActivity context){
        mContext = context;
    }

    public void init_view(View view){
        mView = view;

        table1 = mView.findViewById(R.id.table1);
        table2 = mView.findViewById(R.id.table2);
        tableImage1 = mView.findViewById(R.id.tableImage1);
        tableImage2 = mView.findViewById(R.id.tableImage2);
        rangeArray = new TextView[]{mView.findViewById(R.id.apt_current_value),
                mView.findViewById(R.id.apt_current_state),
                mView.findViewById(R.id.t31extView711),
                mView.findViewById(R.id.t31extView7111),
        };


        freqArray = new TextView[]{mView.findViewById(R.id.apt_voltage_value),
                mView.findViewById(R.id.apt_voltage_state),
                mView.findViewById(R.id.t2e1xtView711),
                mView.findViewById(R.id.t2ex2tView7111),
        };

        pulseArray = new TextView[]{mView.findViewById(R.id.apt_impedance_value),
                mView.findViewById(R.id.apt_impedance_state),
                mView.findViewById(R.id.t1ext3View711),
                mView.findViewById(R.id.t1extV2iew7111),
        };


        range_range_left = mView.findViewById(R.id.t1extV11iew711);
        range_freq_left = mView.findViewById(R.id.t3extVi1ew711);
        range_pulse_left = mView.findViewById(R.id.t2e11xtView711);
        range_time_left = mView.findViewById(R.id.t1extV1iew711);
        range_range_right = mView.findViewById(R.id.t1extVi1e1w7111);
        range_freq_right = mView.findViewById(R.id.t3ext1View7111);
        range_pulse_right = mView.findViewById(R.id.t2e1xtView7111);
        range_time_right = mView.findViewById(R.id.t1extVie1w7111);

        soft_boot = mView.findViewById(R.id.soft_boot);
        soft_stop = mView.findViewById(R.id.soft_stop);

        run_state = mView.findViewById(R.id.customItemA113);
        battery = mView.findViewById(R.id.asdasdasd);
        inner_clock = mView.findViewById(R.id.asda1sdasd);
        //bundle = DailyStimBundle.getNormalTestData();
        bundle = DailyStimBundle.getComplexTestData();
        init_with_data();
    }

    public void init_with_data(){
        if(bundle.state == DailyStimBundle.StateComplex){
            table2.setVisibility(View.VISIBLE);
            tableImage2.setVisibility(View.VISIBLE);
            for(int i = 0 ; i < 4;i++){
                rangeArray[i].setText(bundle.rangeArray[i]);
                freqArray[i].setText(bundle.freqArray[i]);
                pulseArray[i].setText(bundle.pulseArray[i]);
            }
        }else{
            table2.setVisibility(View.INVISIBLE);
            tableImage2.setVisibility(View.INVISIBLE);
            for(int i = 0 ; i < 2;i++){
                rangeArray[i].setText(bundle.rangeArray[i]);
                freqArray[i].setText(bundle.freqArray[i]);
                pulseArray[i].setText(bundle.pulseArray[i]);
            }
        }
        soft_boot.setTitleText3(bundle.soft_boot);
        soft_stop.setTitleText3(bundle.soft_stop);

        range_range_left.setText(bundle.range_range_left);
        range_freq_left.setText(bundle.range_freq_left);
        range_pulse_left.setText(bundle.range_pulse_left);
        range_time_left.setText(bundle.range_time_left);
        range_range_right.setText(bundle.range_range_right);
        range_freq_right.setText(bundle.range_freq_right);
        range_pulse_right.setText(bundle.range_pulse_right);
        range_time_right.setText(bundle.range_time_right);

        run_state.setTitleText3(bundle.run_state);
        battery.setTitleText3(bundle.battery);
        inner_clock.setTitleText3(bundle.inner_clock);
    }

    public void onResume(){

    }


}

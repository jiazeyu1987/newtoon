package com.example.administrator.new_ptns.pager.shuzhong;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.administrator.new_ptns.BaseActivity;
import com.example.administrator.new_ptns.R;
import com.example.administrator.new_ptns.custom_item.CustomItemA4;
import com.example.administrator.new_ptns.custom_item.CustomItemA5;
import com.example.administrator.new_ptns.custom_item.CustomItemA6;
import com.example.administrator.new_ptns.custom_item.CustomItemA8;
import com.example.administrator.new_ptns.data_handler.OperationTempData;
import com.example.administrator.new_ptns.data_handler.OperationTempDataDao;
import com.example.administrator.new_ptns.my_utils.TimeUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OperationActivity extends BaseActivity {

    @BindView(R.id.btn_return)
    ImageView btnReturn;
    @BindView(R.id.bundle_impedance)
    CustomItemA6 bundleImpedance;
    @BindView(R.id.btn_testing)
    Button btnTesting;
    @BindView(R.id.channel_1)
    CustomItemA8 channel1;
    @BindView(R.id.channel_2)
    CustomItemA8 channel2;
    @BindView(R.id.channel_3)
    CustomItemA8 channel3;
    @BindView(R.id.channel_4)
    CustomItemA8 channel4;
    @BindView(R.id.btn_embedded_position)
    CustomItemA4 btnEmbeddedPosition;
    @BindView(R.id.btn_stop_stim)
    Button btnStopStim;
    @BindView(R.id.btn_save_para)
    Button btnSavePara;
    @BindView(R.id.btn_start_time)
    Button btnStartTime;
    @BindView(R.id.bundle_freq)
    CustomItemA5 bundleFreq;
    @BindView(R.id.bundle_pulse)
    CustomItemA5 bundlePulse;
    @BindView(R.id.bundle_range)
    CustomItemA5 bundleRange;
    @BindView(R.id.radio_voltage)
    RadioButton radioVoltage;
    @BindView(R.id.radio_current)
    RadioButton radioCurrent;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;

    public static final int CURRENT = 1;
    public static final int VOLTAGE = 2;
    @BindView(R.id.tv_electrode_show)
    TextView tvElectrodeShow;
    private int current_mode = 1;
    public String g_side;
    public String g_guige;
    public String g_xuliehao;
    public ArrayList<String> impedance_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nt_shuzhong_stim);
        ButterKnife.bind(this);

        radioGroup.check(R.id.radio_current);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radio_current) {
                    current_mode = CURRENT;
                    bundleRange.setPara(0, 0.1f, 1, 0, 11, "mA");
                } else {
                    current_mode = VOLTAGE;
                    bundleRange.setPara(0, 0.1f, 1, 0, 25, "V");
                }
            }
        });

        Intent intent = getIntent();
        g_side = intent.getStringExtra("para1");
        g_guige = intent.getStringExtra("para2");
        g_xuliehao = intent.getStringExtra("para3");
        tvElectrodeShow.setText(g_side+":"+g_guige);
        init_false_data();

    }

    private void init_false_data() {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("0");
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");

        list1.add("5");
        list1.add("6");
        list1.add("7");
        list1.add("8");
        list1.add("9");

        list1.add("10");
        list1.add("11");
        list1.add("12");
        list1.add("13");
        list1.add("14");

        list1.add("15");
        list1.add("16");
        list1.add("17");
        list1.add("18");
        list1.add("19");
        impedance_list = list1;
        bundleImpedance.setValue(impedance_list);
    }

    @OnClick({R.id.btn_return, R.id.btn_testing, R.id.btn_embedded_position, R.id.btn_stop_stim, R.id.btn_save_para, R.id.btn_start_time})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_return:
                finish();
                break;
            case R.id.btn_testing:
                break;
            case R.id.btn_embedded_position:
                break;
            case R.id.btn_stop_stim:
                break;
            case R.id.btn_save_para:
                do_save_para();
                break;
            case R.id.btn_start_time:
                break;
        }
    }

    private void do_save_para(){
        OperationTempData data = new OperationTempData();
        data.electrode_data = save_electrode_data();
        data.impedance = save_impedance_data();
        data.electrode_position = "----";
        data.long_date = TimeUtils.getCurrentTimeYMDHMS();
        data.stim_para = save_stim_para();
        OperationTempDataDao dao = new OperationTempDataDao(this);
        dao.insert(data);
    }

    private String save_stim_para(){
        String s1 = "";
        if(current_mode==VOLTAGE){
            s1 = s1+bundleRange.getTitleText2()+"mV  ";
        }else{
            s1 = s1+bundleRange.getTitleText2()+"mA  ";
        }

        s1 = s1+bundleFreq.getTitleText2()+"Hz  ";
        s1 = s1+bundlePulse.getTitleText2()+"uS  ";
        return  s1;
    }

    private String  save_electrode_data(){
        String s1 = "";
        if(channel1.state==1){
            s1 = s1+"1+";
        }else if(channel1.state==2){
            s1 = s1+"1-";
        }

        if(channel2.state==1){
            s1 = s1+"2+";
        }else if(channel2.state==2){
            s1 = s1+"2-";
        }

        if(channel3.state==1){
            s1 = s1+"3+";
        }else if(channel3.state==2){
            s1 = s1+"3-";
        }

        if(channel4.state==1){
            s1 = s1+"4+";
        }else if(channel4.state==2){
            s1 = s1+"4-";
        }
        return s1;
    }

    private String save_impedance_data(){
        String s1 = "";
        CustomItemA8[] ss1 = new CustomItemA8[]{channel1,channel2,channel3,channel4};
        int[] vals = new int[4];
        for (int i = 0 ; i < ss1.length ;i++){
            if(ss1[i].state==1){
                vals[i] = 1;
            }else if(ss1[i].state==2){
                vals[i] = -1;
            }else{
                vals[i] = 0;
            }
        }

        for(int i = 0 ; i < vals.length;i++)
            for(int j = 0 ; j < vals.length ; j++){
                if(vals[i]*vals[j]==-1){
                    int index=i*vals.length+j;
                    String val1 = impedance_list.get(index);
                    s1 = s1+"val1";
                    s1 = s1+" ";
                }
            }
        return s1;
    }
}

package com.example.administrator.new_ptns.pager.debug.pager;

import android.view.View;
import android.widget.Button;

import com.example.administrator.new_ptns.R;
import com.example.administrator.new_ptns.custom_item.CustomItemA6;
import com.example.administrator.new_ptns.data_handler.ElectrodeBundle;
import com.example.administrator.new_ptns.pager.debug.DailyDebugActivity;
import com.example.administrator.new_ptns.pager.shuzhong.OperationTestingActivity;

import java.util.ArrayList;


public class PagerImpedanceInfo {
    public DailyDebugActivity mContext;
    public View mView;
    public CustomItemA6 left_table,right_table;
    public ArrayList<String> impedance_list;
    public Button btn_test;
    public PagerImpedanceInfo(DailyDebugActivity context){
        mContext = context;
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
        left_table.setValue(impedance_list);
        right_table.setValue(impedance_list);
    }

    public void init_view(View view){
        mView = view;
        left_table = mView.findViewById(R.id.customItemA6);
        right_table = mView.findViewById(R.id.customItemA62);
        btn_test = mView.findViewById(R.id.button30);
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                init_false_data();
            }
        });
    }

    public void onResume(){

    }



}

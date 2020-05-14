package com.example.administrator.new_ptns.pager.patient_info;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.administrator.new_ptns.R;
import com.example.administrator.new_ptns.data_handler.DoublePatientData;
import com.example.administrator.new_ptns.data_handler.ImpedanceData;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImpedanceHistoryActivity extends AppCompatActivity {


    @BindView(R.id.listview4)
    ListView listview4;

    ImpedanceHistoryAdapter adapter;
    ArrayList<ImpedanceData> list1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager_nt_three_4);
        ButterKnife.bind(this);
        list1 = ImpedanceData.get_test_data();
        adapter = new ImpedanceHistoryAdapter(this,list1);
        listview4.setAdapter(adapter);
    }
}

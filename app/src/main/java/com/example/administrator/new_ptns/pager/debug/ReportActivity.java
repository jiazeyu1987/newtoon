package com.example.administrator.new_ptns.pager.debug;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bin.david.form.core.SmartTable;
import com.example.administrator.new_ptns.R;
import com.example.administrator.new_ptns.custom_item.CustomItem5;
import com.example.administrator.new_ptns.custom_item.CustomItemA6;
import com.example.administrator.new_ptns.data_handler.SolutionBigData;
import com.example.administrator.new_ptns.data_handler.StimDebugDao;
import com.example.administrator.new_ptns.data_handler.StimDebugData;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReportActivity extends AppCompatActivity {

    @BindView(R.id.solution_table)
    SmartTable solutionTable;
    @BindView(R.id.para_table)
    SmartTable paraTable;
    @BindView(R.id.impedance_table_right)
    CustomItemA6 impedanceTableRight;
    @BindView(R.id.impedance_table_left)
    CustomItemA6 impedanceTableLeft;
    @BindView(R.id.customItem51112)
    CustomItem5 customItem51112;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager_nt_two_4);
        ButterKnife.bind(this);

        StimDebugDao dao = new StimDebugDao(this);
        ArrayList<StimDebugData> datalist = dao.getAllStimDebugs();
        StimDebugData targetData = null;
        if(datalist.size()>0){
            targetData = datalist.get(datalist.size()-1);
        }

        if(targetData!=null){
            SolutionBigData left_data = targetData.left_data;
            SolutionBigData right_data = targetData.right_data;
        }

    }
}

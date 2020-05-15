package com.example.administrator.new_ptns.data_handler;

import java.util.ArrayList;

public class ImpedanceData extends AABaseData{
    public int id;
    public String date;
    public ArrayList<String> leftImpedanceList = null;
    public ArrayList<String> rightImpedanceList = null;

    public static ArrayList<ImpedanceData> get_test_data(){
        ArrayList<ImpedanceData> list1 = new ArrayList<>();
        for(int i = 0 ; i < 11;i++){
            ImpedanceData data = new ImpedanceData();
            data.date = "2020-02-01";
            data.leftImpedanceList = new ArrayList<>();
            for(int j = 0 ; j < 20 ;j++){
                data.leftImpedanceList.add(j*j+"");
            }
            list1.add(data);
        }
        return list1;
    }
}

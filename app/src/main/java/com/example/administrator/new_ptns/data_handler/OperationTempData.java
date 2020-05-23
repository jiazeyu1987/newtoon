package com.example.administrator.new_ptns.data_handler;

public class OperationTempData extends AABaseData{
    public int id;
    public String electrode_data;
    public String long_date;
    public String electrode_position;
    public String impedance;
    public String stim_para;

    public OperationTempData(int id1,String long_date1,String electrode_position1,String electrode_data1,String impedance1,String stim_para1){
        id = id1;
        electrode_data = electrode_data1;
        long_date = long_date1;
        electrode_position = electrode_position1;
        impedance = impedance1;
        stim_para = stim_para1;
    }

    public OperationTempData(){}
}

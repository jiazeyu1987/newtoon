package com.example.administrator.new_ptns.data_handler;

import com.example.administrator.new_ptns.G;

import java.util.ArrayList;

public class PatientData extends AABaseData {
    public int id;

    public int doctor_id =1;
    public String doctor_name;
    public String id_card;
    public String name;
    public String sex;
    public int age;
    public String last_operation_date;
    public String last_debug_date;
    public int  icon1;
    public String phone_number;
    public String address;
    public String detail_address;

    public PatientOperationData latest_patientOperationData = new PatientOperationData();
    public ArrayList<DailyStimBundle> dailyStimBundleArrayList = new ArrayList<>();


    public PatientData(){
        doctor_id = G.doctor_id;
    }

    public static ArrayList<PatientData> get_test_data(){
        ArrayList<PatientData> list1 = new ArrayList<>();
        for(int i = 0 ; i < 11;i++){
            PatientData data = new PatientData();
            data.name = "小红"+i;
            data.sex = "女";
            data.age = i*i+5;
            data.last_operation_date = "2020-02-02";
            data.last_debug_date = "2020-01-01";

            data.phone_number = "193923849231";
            data.address = "浙江省杭州市余杭区";
            data.detail_address = "XX小区XX栋"+i+"楼";
            data.latest_patientOperationData.stim_number = "NO.000001";
            data.latest_patientOperationData.stim_embedded_date = "2020-02-01";
            data.latest_patientOperationData.charging_percent = i*i+"%";
//            data.electrode1_number = "NO.0000021";
//            data.electorde1_position = "LSTN";
//            data.electrode1_date = "2020-02-02";
//            data.electrode2_number = "NO.0000022";
//            data.electorde2_position = "RSTN";
//            data.electrode2_date = "2020-02-02";
            list1.add(data);
        }
        return list1;
    }
}

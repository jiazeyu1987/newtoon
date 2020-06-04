package com.example.administrator.new_ptns.data_handler;

import android.content.Context;

import com.blankj.utilcode.util.ToastUtils;

public class ContactData  extends AABaseData{

    public int id = -1;



    public String contact_number;


    public String patient_name;

    public String sex;

    public String id_card;

    public String phone_number;

    public String address;

    public String detail_address;



    public String operation_machanism;

    public String department;

    public String operation_doctor;

    public String operation_date;



    public String stimulator;

    public String electrode1;

    public String electrode2;

    public String stim_software;

    public String charging_coil;



    public String relative_name;

    public String relative_phone_number;

    public String relative;


    public String extra;


    public String adviser_info;


    public String getAge(){
        return "18";
    }


    public boolean CheckDataLegality(){
        if(patient_name==null){
            ToastUtils.showShort("请输入患者姓名");
            return false;
        }

        return true;
    }

}

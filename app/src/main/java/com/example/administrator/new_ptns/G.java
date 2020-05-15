package com.example.administrator.new_ptns;

import com.example.administrator.new_ptns.data_handler.PatientData;

import java.util.Date;

public class G {
    public static PatientData g_patient_data = null;
    public static Date g_date;

    public  static void setData(PatientData data1,Date date1){
        g_patient_data = data1;
        g_date = date1;
    }
}

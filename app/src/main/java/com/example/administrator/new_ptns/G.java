package com.example.administrator.new_ptns;

import com.example.administrator.new_ptns.data_handler.ContactData;
import com.example.administrator.new_ptns.data_handler.PatientData;

import java.util.Date;

public class G {
    public static String g_date = null;
    public static ContactData g_contact_data = null;
    public static boolean TEST = true;
    public  static void init(ContactData data1,String date1){
        g_contact_data = data1;
        g_date = date1;
    }
}

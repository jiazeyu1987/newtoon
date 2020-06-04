package com.example.administrator.new_ptns;

import com.example.administrator.new_ptns.data_handler.ContactData;
import com.example.administrator.new_ptns.data_handler.ElectrodeBundle;
import com.example.administrator.new_ptns.data_handler.PatientDao;
import com.example.administrator.new_ptns.data_handler.PatientData;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class G {
    public static String g_date = null;
    public static String g_xingqi = null;
    public static ContactData g_contact_data = new ContactData();
    public static PatientData g_patient_data = new PatientData();
    public static ArrayList<PatientData> patientDataArrayList = new ArrayList<>();
    public static boolean TEST = true;
    public static int doctor_id = 1;
    public  static void init(String date1,String xingqi){
        g_date = date1;
        g_xingqi = xingqi;
    }


    public static void modify_patient(PatientDao dao,PatientData patientData){
        PatientData patientData1 = getPatientLocal(patientData);
        if(patientData1!=null){
            dao.modify(patientData1);
            for(int i = 0 ; i < patientDataArrayList.size() ; i++){
                PatientData local = patientDataArrayList.get(i);
                if(local.id_card.equals(patientData.id_card)){
                    patientDataArrayList.set(i,patientData);
                }
            }
        }
    }


    public static void add_patient(PatientDao dao, PatientData patientData){
        PatientData patientData1 = getPatientLocal(patientData);
        if(patientData1==null){
            dao.insert(patientData);
            patientDataArrayList.add(patientData);
        }
    }

    public static PatientData getPatientLocal(PatientData patientData){
        for(int i = 0 ; i < patientDataArrayList.size() ; i++){
            PatientData local = patientDataArrayList.get(i);
            if(local.id_card.equals(patientData.id_card)){
                return local;
            }
        }
        return null;
    }

    public static PatientData getPatientLocalByIdCard(String id_card){
        for(int i = 0 ; i < patientDataArrayList.size() ; i++){
            PatientData local = patientDataArrayList.get(i);
            if(local.id_card.equals(id_card)){
                return local;
            }
        }
        return null;
    }
}

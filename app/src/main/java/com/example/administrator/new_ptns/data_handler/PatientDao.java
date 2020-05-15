package com.example.administrator.new_ptns.data_handler;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;

import java.util.ArrayList;


public class PatientDao {

    private PatientHelper helper;

    private Context context;

    private String db_name = "patient1.db";

    public PatientDao(Context context){

        this.context = context;

    }

    public void delete_all(){
        helper = new PatientHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Gson gson = new Gson();
        db.execSQL("delete from t_patient" );
        db.close();
    }

    public void insert(PatientData patient1){
        helper = new PatientHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Gson gson = new Gson();
        String date1 = gson.toJson(patient1);
        db.execSQL("insert into t_patient(date_1) values(?)" , new Object[]{date1});
        db.close();
    }

    public void modify(PatientData patient1){
        helper = new PatientHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Gson gson = new Gson();
        String date1 = gson.toJson(patient1);
        db.execSQL("update t_patient set date_1=? where id=?" , new Object[]{date1, patient1.id});
        db.close();
    }

    public void delete(PatientData patient1){
        helper = new PatientHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("delete from t_patient where id = ?" , new Object[]{patient1.id});
        db.close();
    }

    public ArrayList<PatientData> getAllPatients(){
        ArrayList<PatientData> list = new ArrayList<PatientData>();
        helper = new PatientHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select id,date_1 from t_patient", null);
        if(cursor == null){
            return null;
        }
        while(cursor.moveToNext()){
            String s1 = cursor.getString(1);
            Gson gson = new Gson();
            PatientData item = gson.fromJson(s1,PatientData.class);
            item.cal();
            item.id = cursor.getInt(0);
            list.add(item);
        }
        return list;
    }


}
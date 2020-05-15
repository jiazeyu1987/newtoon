package com.example.administrator.new_ptns.data_handler;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;

import java.util.ArrayList;


public class ImpedanceDao {

    private ImpedanceHelper helper;

    private Context context;

    private String db_name = "impedance1.db";

    public ImpedanceDao(Context context){

        this.context = context;

    }

    public void delete_all(){
        helper = new ImpedanceHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Gson gson = new Gson();
        db.execSQL("delete from t_impedance" );
        db.close();
    }

    public void insert(ImpedanceData impedance1){
        helper = new ImpedanceHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Gson gson = new Gson();
        String date1 = gson.toJson(impedance1);
        db.execSQL("insert into t_impedance(date_1) values(?)" , new Object[]{date1});
        db.close();
    }

    public void modify(ImpedanceData impedance1){
        helper = new ImpedanceHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Gson gson = new Gson();
        String date1 = gson.toJson(impedance1);
        db.execSQL("update t_impedance set date_1=? where id=?" , new Object[]{date1, impedance1.id});
        db.close();
    }

    public void delete(ImpedanceData impedance1){
        helper = new ImpedanceHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("delete from t_impedance where id = ?" , new Object[]{impedance1.id});
        db.close();
    }

    public ArrayList<ImpedanceData> getAllImpedances(){
        ArrayList<ImpedanceData> list = new ArrayList<ImpedanceData>();
        helper = new ImpedanceHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select id,date_1 from t_impedance", null);
        if(cursor == null){
            return null;
        }
        while(cursor.moveToNext()){
            String s1 = cursor.getString(1);
            Gson gson = new Gson();
            ImpedanceData item = gson.fromJson(s1,ImpedanceData.class);
            item.cal();
            item.id = cursor.getInt(0);
            list.add(item);
        }
        return list;
    }


}
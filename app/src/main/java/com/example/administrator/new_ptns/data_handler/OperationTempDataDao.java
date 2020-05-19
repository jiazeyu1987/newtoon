package com.example.administrator.new_ptns.data_handler;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;

import java.util.ArrayList;


public class OperationTempDataDao {

    private OperationTempDataHelper helper;

    private Context context;

    private String db_name = "operation_temp_data1.db";

    public OperationTempDataDao(Context context){

        this.context = context;

    }

    public void delete_all(){
        helper = new OperationTempDataHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Gson gson = new Gson();
        db.execSQL("delete from t_operation_temp_data" );
        db.close();
    }

    public void insert(OperationTempData operation_temp_data1){
        helper = new OperationTempDataHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Gson gson = new Gson();
        String date1 = gson.toJson(operation_temp_data1);
        db.execSQL("insert into t_operation_temp_data(date_1) values(?)" , new Object[]{date1});
        db.close();
    }

    public void modify(OperationTempData operation_temp_data1){
        helper = new OperationTempDataHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Gson gson = new Gson();
        String date1 = gson.toJson(operation_temp_data1);
        db.execSQL("update t_operation_temp_data set date_1=? where id=?" , new Object[]{date1, operation_temp_data1.id});
        db.close();
    }

    public void delete(OperationTempData operation_temp_data1){
        helper = new OperationTempDataHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("delete from t_operation_temp_data where id = ?" , new Object[]{operation_temp_data1.id});
        db.close();
    }

    public ArrayList<OperationTempData> getAllOperationTempDatas(){
        ArrayList<OperationTempData> list = new ArrayList<OperationTempData>();
        helper = new OperationTempDataHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select id,date_1 from t_operation_temp_data", null);
        if(cursor == null){
            return null;
        }
        while(cursor.moveToNext()){
            String s1 = cursor.getString(1);
            Gson gson = new Gson();
            OperationTempData item = gson.fromJson(s1,OperationTempData.class);
            item.cal();
            item.id = cursor.getInt(0);
            list.add(item);
        }
        return list;
    }


}
package com.example.administrator.dbs1.history_data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;

import java.util.ArrayList;


public class HistoryDao {

    private HistoryHelper helper;

    private Context context;

    private String db_name = "history1.db";

    public HistoryDao(Context context){

        this.context = context;

    }

    public void delete_all(){
        helper = new HistoryHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Gson gson = new Gson();
        db.execSQL("delete from t_history" );
        db.close();
    }

    public void insert(HistoryData history1){
        helper = new HistoryHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Gson gson = new Gson();
        String date1 = gson.toJson(history1);
        db.execSQL("insert into t_history(date_1) values(?)" , new Object[]{date1});
        db.close();
    }

    public void modify(HistoryData history1){
        helper = new HistoryHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Gson gson = new Gson();
        String date1 = gson.toJson(history1);
        db.execSQL("update t_history set date_1=? where id=?" , new Object[]{date1, history1.id});
        db.close();
    }

    public void delete(HistoryData history1){
        helper = new HistoryHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("delete from t_history where id = ?" , new Object[]{history1.id});
        db.close();
    }

    public ArrayList<HistoryData> getAllHistorys(){
        ArrayList<HistoryData> list = new ArrayList<HistoryData>();
        helper = new HistoryHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select id,date_1 from t_history", null);
        if(cursor == null){
            return null;
        }
        while(cursor.moveToNext()){
            String s1 = cursor.getString(1);
            Gson gson = new Gson();
            HistoryData item = gson.fromJson(s1,HistoryData.class);
            item.cal();
            item.id = cursor.getInt(0);
            list.add(item);
        }
        return list;
    }


}
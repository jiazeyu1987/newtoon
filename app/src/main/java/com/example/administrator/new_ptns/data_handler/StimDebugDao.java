package com.example.administrator.new_ptns.data_handler;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;

import java.util.ArrayList;


public class StimDebugDao {

    private StimDebugHelper helper;

    private Context context;

    private String db_name = "stimdebug1.db";

    public StimDebugDao(Context context){

        this.context = context;

    }

    public void delete_all(){
        helper = new StimDebugHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Gson gson = new Gson();
        db.execSQL("delete from t_stimdebug" );
        db.close();
    }

    public void insert(StimDebugData stimdebug1){
        helper = new StimDebugHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Gson gson = new Gson();
        String date1 = gson.toJson(stimdebug1);
        db.execSQL("insert into t_stimdebug(date_1) values(?)" , new Object[]{date1});
        db.close();
    }

    public void modify(StimDebugData stimdebug1){
        helper = new StimDebugHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Gson gson = new Gson();
        String date1 = gson.toJson(stimdebug1);
        db.execSQL("update t_stimdebug set date_1=? where id=?" , new Object[]{date1, stimdebug1.id});
        db.close();
    }

    public void delete(StimDebugData stimdebug1){
        helper = new StimDebugHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("delete from t_stimdebug where id = ?" , new Object[]{stimdebug1.id});
        db.close();
    }

    public ArrayList<StimDebugData> getAllStimDebugs(){
        ArrayList<StimDebugData> list = new ArrayList<StimDebugData>();
        helper = new StimDebugHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select id,date_1 from t_stimdebug", null);
        if(cursor == null){
            return null;
        }
        while(cursor.moveToNext()){
            String s1 = cursor.getString(1);
            Gson gson = new Gson();
            StimDebugData item = gson.fromJson(s1,StimDebugData.class);
            item.cal();
            item.id = cursor.getInt(0);
            list.add(item);
        }
        return list;
    }


}
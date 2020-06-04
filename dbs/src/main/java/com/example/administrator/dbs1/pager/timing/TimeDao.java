package com.example.administrator.dbs1.pager.timing;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;

import java.util.ArrayList;


public class TimeDao {

    private TimeHelper helper;

    private Context context;

    private String db_name = "time1.db";

    public TimeDao(Context context){

        this.context = context;

    }

    public void delete_all(){
        helper = new TimeHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Gson gson = new Gson();
        db.execSQL("delete from t_time" );
        db.close();
    }

    public void insert(PagerTimingItem time1){
        helper = new TimeHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Gson gson = new Gson();
        String date1 = gson.toJson(time1);
        db.execSQL("insert into t_time(date_1) values(?)" , new Object[]{date1});
        db.close();
    }

    public void modify(PagerTimingItem time1){
        helper = new TimeHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Gson gson = new Gson();
        String date1 = gson.toJson(time1);
        db.execSQL("update t_time set date_1=? where id=?" , new Object[]{date1, time1.id});
        db.close();
    }

    public void delete(PagerTimingItem time1){
        helper = new TimeHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("delete from t_time where id = ?" , new Object[]{time1.id});
        db.close();
    }

    public ArrayList<PagerTimingItem> getAllTimes(){
        ArrayList<PagerTimingItem> list = new ArrayList<PagerTimingItem>();
        helper = new TimeHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select id,date_1 from t_time", null);
        if(cursor == null){
            return null;
        }
        while(cursor.moveToNext()){
            String s1 = cursor.getString(1);
            Gson gson = new Gson();
            PagerTimingItem item = gson.fromJson(s1,PagerTimingItem.class);
            item.cal();
            item.id = cursor.getInt(0);
            list.add(item);
        }
        return list;
    }


}
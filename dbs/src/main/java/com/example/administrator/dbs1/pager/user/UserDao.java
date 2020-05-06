package com.example.administrator.dbs1.pager.user;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;

import java.util.ArrayList;


public class UserDao {

    private UserHelper helper;

    private Context context;

    private String db_name = "user1.db";

    public UserDao(Context context){

        this.context = context;

    }

    public void delete_all(){
        helper = new UserHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Gson gson = new Gson();
        db.execSQL("delete from t_user" );
        db.close();
    }

    public void insert(PagerUserItem user1){
        helper = new UserHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Gson gson = new Gson();
        String date1 = gson.toJson(user1);
        db.execSQL("insert into t_user(date_1) values(?)" , new Object[]{date1});
        db.close();
    }

    public void modify(PagerUserItem user1){
        helper = new UserHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Gson gson = new Gson();
        String date1 = gson.toJson(user1);
        db.execSQL("update t_user set date_1=? where id=?" , new Object[]{date1, user1.id});
        db.close();
    }

    public void delete(PagerUserItem user1){
        helper = new UserHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("delete from t_user where id = ?" , new Object[]{user1.id});
        db.close();
    }

    public ArrayList<PagerUserItem> getAllUsers(){
        ArrayList<PagerUserItem> list = new ArrayList<PagerUserItem>();
        helper = new UserHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select id,date_1 from t_user", null);
        if(cursor == null){
            return null;
        }
        while(cursor.moveToNext()){
            String s1 = cursor.getString(1);
            Gson gson = new Gson();
            PagerUserItem item = gson.fromJson(s1,PagerUserItem.class);
            item.cal();
            item.id = cursor.getInt(0);
            list.add(item);
        }
        return list;
    }


}
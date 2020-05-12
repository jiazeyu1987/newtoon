package com.example.administrator.new_ptns.data_handler;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;

import java.util.ArrayList;


public class ContactDao {

    private ContactHelper helper;

    private Context context;

    private String db_name = "contact1.db";

    public ContactDao(Context context){

        this.context = context;

    }

    public void delete_all(){
        helper = new ContactHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Gson gson = new Gson();
        db.execSQL("delete from t_contact" );
        db.close();
    }

    public void insert(ContactData contact1){
        helper = new ContactHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Gson gson = new Gson();
        String date1 = gson.toJson(contact1);
        db.execSQL("insert into t_contact(date_1) values(?)" , new Object[]{date1});
        db.close();
    }

    public void modify(ContactData contact1){
        helper = new ContactHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Gson gson = new Gson();
        String date1 = gson.toJson(contact1);
        db.execSQL("update t_contact set date_1=? where id=?" , new Object[]{date1, contact1.id});
        db.close();
    }

    public void delete(ContactData contact1){
        helper = new ContactHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("delete from t_contact where id = ?" , new Object[]{contact1.id});
        db.close();
    }

    public ArrayList<ContactData> getAllContacts(){
        ArrayList<ContactData> list = new ArrayList<ContactData>();
        helper = new ContactHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select id,date_1 from t_contact", null);
        if(cursor == null){
            return null;
        }
        while(cursor.moveToNext()){
            String s1 = cursor.getString(1);
            Gson gson = new Gson();
            ContactData item = gson.fromJson(s1,ContactData.class);
            item.cal();
            item.id = cursor.getInt(0);
            list.add(item);
        }
        return list;
    }


}
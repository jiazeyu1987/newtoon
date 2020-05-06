package com.example.administrator.new_ptns.pager.template;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;

import java.util.ArrayList;


public class TemplateDao {

    private TemplateHelper helper;

    private Context context;

    private String db_name = "template1.db";

    public TemplateDao(Context context){

        this.context = context;

    }

    public void delete_all(){
        helper = new TemplateHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Gson gson = new Gson();
        db.execSQL("delete from t_template" );
        db.close();
    }

    public void insert(PagerTemplateItem template1){
        helper = new TemplateHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Gson gson = new Gson();
        String date1 = gson.toJson(template1);
        db.execSQL("insert into t_template(str_1) values(?)" , new Object[]{date1});
        db.close();
    }

    public void modify(PagerTemplateItem template1){
        helper = new TemplateHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Gson gson = new Gson();
        String date1 = gson.toJson(template1);
        db.execSQL("update t_template set str_1=? where id=?" , new Object[]{date1, template1.id});
        db.close();
    }

    public void delete(PagerTemplateItem template1){
        helper = new TemplateHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("delete from t_template where id = ?" , new Object[]{template1.id});
        db.close();
    }

    public ArrayList<PagerTemplateItem> getAllTemplates(){
        ArrayList<PagerTemplateItem> list = new ArrayList<PagerTemplateItem>();
        helper = new TemplateHelper(context,db_name, null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select id,str_1 from t_template", null);
        if(cursor == null){
            return null;
        }
        while(cursor.moveToNext()){
            String s1 = cursor.getString(1);
            Gson gson = new Gson();
            PagerTemplateItem item = gson.fromJson(s1,PagerTemplateItem.class);
            item.cal();
            item.id = cursor.getInt(0);
            list.add(item);
        }
        return list;
    }


}
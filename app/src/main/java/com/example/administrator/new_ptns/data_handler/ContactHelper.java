package com.example.administrator.new_ptns.data_handler;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ContactHelper extends SQLiteOpenHelper {
    public static final String CREATE_STUDENT = "create table t_contact (" +
            "id integer primary key, date_1 varchar(50))";

    public ContactHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                         int version) {
        super(context, name, factory, version);
    }

    @Override

    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    @Override

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_STUDENT);
    }

    @Override

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}

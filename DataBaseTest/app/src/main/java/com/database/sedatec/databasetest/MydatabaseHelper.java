package com.database.sedatec.databasetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SedateC on 2017/7/23.
 */

public class MydatabaseHelper extends SQLiteOpenHelper {
     static String sql  = "create table Book("
            + "id integer primary key autoincrement," +
            "author text," +
            "price real," +
            "pages integer," +
            "name text)";
    public static final String CREATE_BOOK =sql;

    public static final String CREATE_CATEGORY="create table Category(" +
            "id integer primary key autoincrement," +
            "category_name text," +
            "category_code interger)";


    private Context mcontext;



    public MydatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mcontext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATEGORY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Book");
        db.execSQL("drop table if exists Category");
        onCreate(db);
    }
}

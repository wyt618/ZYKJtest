package com.example.zuoye;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final String CREATE_LAYOUT = "create table layout ("
    +"id integer primary key autoincrement,"
    +"btn_name text,"
    +"text1_name text,"
    +"text2_name text )";
    private  Context mContext;

    public MyDatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;

    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_LAYOUT);
        Toast.makeText(mContext,"创建成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

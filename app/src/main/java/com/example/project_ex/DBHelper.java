package com.example.project_ex;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public String TABLE_NAME = "id_list";
    public String ID = "id";
    public String PW = "pw";
    public String ADDRESS = "address";

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_query = "create table if not exists "+ TABLE_NAME +"("+
                ID + "text primary key, "+ PW +"text," + ADDRESS+"text;)";
        sqLiteDatabase.execSQL(create_query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String drop_query = "drop table " + TABLE_NAME + ";";
        sqLiteDatabase.execSQL(drop_query);

        onCreate(sqLiteDatabase);
    }
}

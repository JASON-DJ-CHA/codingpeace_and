package com.example.project_ex;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class SQLiteControl {

    DBHelper helper;
    SQLiteDatabase sqLiteDatabase;

    public SQLiteControl(DBHelper helper) {
        this.helper = helper;
    }

    public void insert(String id,String pw,String address){
        sqLiteDatabase = helper.getWritableDatabase();

        sqLiteDatabase.execSQL("insert into id_list values('"+id+"''"+pw+"''"+address+"')");

    }

    public String[] select(){

        sqLiteDatabase = helper.getWritableDatabase();

        Cursor c = sqLiteDatabase.query(helper.TABLE_NAME,null,null,null,null,null,null);

        String[] columnName = {helper.ID, helper.PW, helper.ADDRESS};

        String[] returnValue = new String[columnName.length];

        while (c.moveToNext()){
            for (int i = 0; i<returnValue.length;i++){
                returnValue[i] = c.getString(c.getColumnIndex(columnName[i]));
                Log.e("DB Select : ", i+"-"+returnValue[i]);
            }
        }
        c.close();
        return returnValue;
    }

}


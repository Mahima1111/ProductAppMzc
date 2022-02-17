package com.example.productappmzc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    static  String DbName="College.db";
    static  String TableName="product";
    static  String Col1="id";
    static  String Col2="productcode";
    static  String Col3="productname";
    static  String Col4="price";


    public DatabaseHelper( Context context) {
        super(context, DbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table "+TableName+
                "("+Col1+" integer primary key autoincrement,"
                   +Col2+" integer,"
                    +Col3+" text,"+Col4+" integer)";
        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
    public boolean InsertData(String productcode,String productname,String price)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put(Col2,productcode);
        c.put(Col3,productname);
        c.put(Col4,price);
        long status=db.insert(TableName,null,c);
        if(status==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public Cursor SearchData(String productcode)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String query="select * from " +TableName+
                "where " +Col2+ "="+productcode+"";
        Cursor c=db.rawQuery(Query,null);
        return c;


    }
}


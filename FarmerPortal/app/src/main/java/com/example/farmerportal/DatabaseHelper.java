package com.example.farmerportal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.net.PasswordAuthentication;

public class DatabaseHelper extends SQLiteOpenHelper {
    static  String name="database.db";
    static  int version=1;
    public  static  final String Table_Name="user_db";
    public  static  final String COL_1="Username";
    public  static  final String COL_2="Password";
    public  static  final String Col_3="Usertype";
    public  static  final String Col_4="Mobile";

    public DatabaseHelper(@Nullable Context context) {
        super(context, name, null, version);
        //it will create database and table
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+Table_Name+"(Username TEXT PRIMARY KEY,Password TEXT,Usertype TEXT,Mobile TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Table_Name);
        onCreate(db);
    }

    //method to insert data inside database
    public  boolean inserData(String Username,String Password,String Usertype,String Mobile){
        SQLiteDatabase  db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,Username);
        contentValues.put(COL_2,Password);
        contentValues.put(Col_3,Usertype);
        contentValues.put(Col_4,Mobile);
        long result=db.insert(Table_Name,null,contentValues);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }

     public int accessUser(String username,String password,String usertype){
        SQLiteDatabase  db=this.getWritableDatabase();
         Cursor res = db.rawQuery("select * from "+Table_Name+" where Username =?",new String[]{username});


         int total=res.getCount();
         return(total);//return the number of rows in the table satifying query
         //Toast.makeText(, res.getCount(), Toast.LENGTH_SHORT).show();
    }
}

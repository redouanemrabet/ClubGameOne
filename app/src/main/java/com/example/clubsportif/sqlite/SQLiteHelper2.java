package com.example.clubsportif.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper2 extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "UserDataBase";
    public static final String TABLE_NAME = "ContactTable";
    public static final String Table_Column_fullName = "fullName";
    public static final String Table_Column_subject = "subject";
    public static final String Table_Column_message = "message";

    public static final String Table_Column_ID = "id";


    public SQLiteHelper2(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + Table_Column_ID + " INTEGER PRIMARY KEY , " + Table_Column_fullName + " VARCHAR, " + Table_Column_subject+ " VARCHAR, " + Table_Column_message+ " VARCHAR)";
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

}

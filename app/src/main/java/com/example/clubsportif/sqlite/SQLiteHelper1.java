package com.example.clubsportif.sqlite;

import static com.example.clubsportif.sqlite.SQLiteHelper.DATABASE_NAME;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Date;

public class SQLiteHelper1 extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "UserDataBase";
    public static final String TABLE_NAME = "RegisterTable";
    public static final String Table_Column_fullName = "fullName";
    public static final String Table_Column_phone = "phone";
    public static final String Table_Column_address = "address";
    public static final String Table_Column_startDate = "startDate";
    public static final String Table_Column_endDate = "endDate";
    public static final String Table_Column_ID = "id";


    public SQLiteHelper1(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + Table_Column_ID + " INTEGER PRIMARY KEY , " + Table_Column_fullName + " VARCHAR, " + Table_Column_phone + " VARCHAR, " + Table_Column_address + " VARCHAR," + Table_Column_startDate + " VARCHAR," + Table_Column_endDate + " VARCHAR)";
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}


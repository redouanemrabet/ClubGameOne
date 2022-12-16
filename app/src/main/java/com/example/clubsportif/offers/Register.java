package com.example.clubsportif.offers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.clubsportif.R;
import com.example.clubsportif.sqlite.SQLiteHelper;
import com.example.clubsportif.sqlite.SQLiteHelper1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Register extends AppCompatActivity {
    EditText fullName;
    EditText phone;
    EditText address;
    EditText startDate;
    EditText endDate;
    SQLiteHelper1 sqLiteHelper;
    SQLiteDatabase sqLiteDatabase;
    boolean EditTextEmptyHolder;
    String F_Result = "Not_Found";
    String SQLiteDataBaseQueryHolder ;
    String fullNameHolder,addressHolder;
    String phoneHolder;
    String startDateHolder,endDateHolder;
    Button register_btn_end;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        fullName=findViewById(R.id.fullName);
        address=findViewById(R.id.address);
        phone=findViewById(R.id.phone);
        startDate=findViewById(R.id.start_date);
        endDate=findViewById(R.id.end_date);
        sqLiteHelper = new SQLiteHelper1(this);
        register_btn_end=findViewById(R.id.register_btn_end);
        register_btn_end.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                // Creating SQLite database if dose n't exists
                SQLiteDataBaseBuild();
                // Creating SQLite table if dose n't exists.
                SQLiteTableBuild();
                // Checking EditText is empty or Not.
                CheckEditTextStatus();
                // Method to check Email is already exists or not.

                // Empty EditText After done inserting process.
                //EmptyEditTextAfterDataInsert();
                insertDataIntoSQLiteDatabase();


            }

        });



    }
    public void insertDataIntoSQLiteDatabase(){
        // If editText is not empty then this block will executed.
        if(EditTextEmptyHolder == true)
        {
            // SQLite query to insert data into table.
            SQLiteDataBaseQueryHolder = "INSERT INTO "+ SQLiteHelper1.TABLE_NAME+" (fullName,phone,address,startDate,endDate) VALUES('"+fullNameHolder+"', '"+phoneHolder+"','"+addressHolder+"','"+startDateHolder+"','"+endDateHolder+"');";
            // Executing query.

            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
            // Closing SQLite database object.
            sqLiteDatabase.close();
            // Printing toast message after done inserting.
            fullName.getText().clear();
            phone.getText().clear();
            address.getText().clear();
            startDate.getText().clear();
            endDate.getText().clear();
            Toast.makeText(Register.this, "Your registration went well, you can go to our club to finish your registration, and thank you for your trust in our club", Toast.LENGTH_LONG).show();
        }
        // This block will execute if any of the registration EditText is empty.
        else {
            // Printing toast message if any of EditText is empty.
            Toast.makeText(Register.this,"Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();
        }
    }
    public void SQLiteDataBaseBuild(){
        sqLiteDatabase = openOrCreateDatabase(SQLiteHelper1.DATABASE_NAME, Context.MODE_PRIVATE, null);
    }
    public void SQLiteTableBuild() {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + SQLiteHelper1.TABLE_NAME + "(" + SQLiteHelper1.Table_Column_ID + " PRIMARY KEY , " + SQLiteHelper1.Table_Column_fullName + " VARCHAR, " + SQLiteHelper1.Table_Column_phone + " VARCHAR," + SQLiteHelper1.Table_Column_address + " VARCHAR," + SQLiteHelper1.Table_Column_startDate + " VARCHAR," + SQLiteHelper1.Table_Column_endDate + " VARCHAR);");
    }


    public void CheckEditTextStatus(){
        fullNameHolder=fullName.getText().toString();
        phoneHolder=phone.getText().toString();
        addressHolder=address.getText().toString();
        startDateHolder=startDate.getText().toString();
        endDateHolder=endDate.getText().toString();


        if(TextUtils.isEmpty(fullNameHolder)||TextUtils.isEmpty(addressHolder) || TextUtils.isEmpty(phoneHolder)||TextUtils.isEmpty(startDateHolder)||TextUtils.isEmpty(endDateHolder)){
            EditTextEmptyHolder=false;

        }
        else{
            EditTextEmptyHolder=true;
        }

    }
    public void EmptyEditTextAfterDataInsert(){
        fullName.getText().clear();
        phone.getText().clear();
        address.getText().clear();
        startDate.getText().clear();
        endDate.getText().clear();
    }


}

package com.example.clubsportif.contact;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.clubsportif.R;
import com.example.clubsportif.offers.Register;
import com.example.clubsportif.sqlite.SQLiteHelper1;
import com.example.clubsportif.sqlite.SQLiteHelper2;

public class ContactUs extends AppCompatActivity {
    EditText fullName;
    EditText subject;
    String SQLiteDataBaseQueryHolder ;
    EditText message;
    Button btn_contactus;
    SQLiteHelper2 sqLiteHelper;
    SQLiteDatabase sqLiteDatabase;
    boolean EditTextEmptyHolder;
    String F_Result = "Not_Found";
    String fullNameHolder,subjectHolder,messageHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_us);
        fullName=findViewById(R.id.fullNameContact);
        subject=findViewById(R.id.subject);
        message=findViewById(R.id.message);
        sqLiteHelper = new SQLiteHelper2(this);
        btn_contactus=findViewById(R.id.sendButton);
        btn_contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SQLiteDataBaseBuild();

                SQLiteTableBuild();

                CheckEditTextStatus();

                insertDataIntoSQLiteDatabase();
            }
        });



    }
    public void SQLiteDataBaseBuild(){
        sqLiteDatabase = openOrCreateDatabase(SQLiteHelper2.DATABASE_NAME, Context.MODE_PRIVATE, null);
    }
    public void SQLiteTableBuild() {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + SQLiteHelper2.TABLE_NAME + "(" + SQLiteHelper2.Table_Column_ID + " PRIMARY KEY , " + SQLiteHelper2.Table_Column_fullName + " VARCHAR, " + SQLiteHelper2.Table_Column_subject + " VARCHAR," + SQLiteHelper2.Table_Column_message + " VARCHAR);");
    }
    public void CheckEditTextStatus(){
        fullNameHolder=fullName.getText().toString();
        subjectHolder=subject.getText().toString();
        messageHolder=message.getText().toString();



        if(TextUtils.isEmpty(fullNameHolder)||TextUtils.isEmpty(subjectHolder) || TextUtils.isEmpty(messageHolder)){
            EditTextEmptyHolder=false;

        }
        else{
            EditTextEmptyHolder=true;
        }

    }
    public void insertDataIntoSQLiteDatabase(){
        // If editText is not empty then this block will executed.
        if(EditTextEmptyHolder == true)
        {
            // SQLite query to insert data into table.
            SQLiteDataBaseQueryHolder = "INSERT INTO "+ SQLiteHelper2.TABLE_NAME+" (fullName,subject,message) VALUES('"+fullNameHolder+"', '"+subjectHolder+"','"+messageHolder+"');";
            // Executing query.

            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
            // Closing SQLite database object.
            sqLiteDatabase.close();
            // Printing toast message after done inserting.
            fullName.getText().clear();
            message.getText().clear();
            subject.getText().clear();

            Toast.makeText(ContactUs.this, "Your registration went well, you can go to our club to finish your registration, and thank you for your trust in our club", Toast.LENGTH_LONG).show();
        }
        // This block will execute if any of the registration EditText is empty.
        else {
            // Printing toast message if any of EditText is empty.
            Toast.makeText(ContactUs.this,"Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();
        }
    }
}

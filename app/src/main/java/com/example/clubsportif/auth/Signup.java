package com.example.clubsportif.auth;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.clubsportif.R;
import com.example.clubsportif.sqlite.SQLiteHelper;

public class Signup  extends AppCompatActivity {
    EditText username;
    EditText password;
    EditText repeatPassword;
    Button signUpButton;

    TextView linkSignIn;
    SQLiteHelper sqLiteHelper;//class helper which contains information about your data base like the name of your database,table name, column name...
    SQLiteDatabase sqLiteDatabase;//object represent your database help to connect to your database,you can execute (des requetes) by help of this objet
    Cursor cursor;
    String repeatPasswordHolder, EmailHolder, PasswordHolder;
    boolean EditTextEmptyHolder;
    String F_Result = "Not_Found";
    String SQLiteDataBaseQueryHolder ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        repeatPassword=findViewById(R.id.confirmPassword);
        signUpButton=findViewById(R.id.signUpButton);
        linkSignIn=findViewById(R.id.linkSignIn);
        sqLiteHelper = new SQLiteHelper(this);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*String user=username.getText().toString().trim();
                String pass=password.getText().toString().trim();
                String repeatPass=repeatPassword.getText().toString().trim();
                if(user.isEmpty()){
                    username.setError("Email cannot be empty");
                }else if( pass.isEmpty()){
                    password.setError("the password cannot be empty");
                }else if(repeatPass.isEmpty()){
                    repeatPassword.setError("the confirm password cannot be empty");
                }else if(password.getText().toString()!=repeatPassword.getText().toString()){
                    Toast.makeText(Signup.this, "the passwords not matched!!!!", Toast.LENGTH_SHORT).show();
                }
               else{
                    System.out.println("ok!!!!!!!");
                }
*/

                // Creating SQLite database if dose n't exists
                SQLiteDataBaseBuild();
                // Creating SQLite table if dose n't exists.
                SQLiteTableBuild();
                // Checking EditText is empty or Not.
                CheckEditTextStatus();
                // Method to check Email is already exists or not.
                CheckingEmailAlreadyExistsOrNot();
                // Empty EditText After done inserting process.
                EmptyEditTextAfterDataInsert();

            }
        });
        linkSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

    }
    public void insertDataIntoSQLiteDatabase(){
        // If editText is not empty then this block will executed.
        if(EditTextEmptyHolder == true)
        {
            // SQLite query to insert data into table.
            SQLiteDataBaseQueryHolder = "INSERT INTO "+SQLiteHelper.TABLE_NAME+" (email,password) VALUES('"+EmailHolder+"', '"+PasswordHolder+"');";
            // Executing query.
            sqLiteDatabase.execSQL(SQLiteDataBaseQueryHolder);
            // Closing SQLite database object.
            sqLiteDatabase.close();
            // Printing toast message after done inserting.
            Toast.makeText(Signup.this,"User Registered Successfully", Toast.LENGTH_LONG).show();
        }
        // This block will execute if any of the registration EditText is empty.
        else {
            // Printing toast message if any of EditText is empty.
            Toast.makeText(Signup.this,"Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();
        }
    }
    public void SQLiteDataBaseBuild(){
        sqLiteDatabase = openOrCreateDatabase(SQLiteHelper.DATABASE_NAME, Context.MODE_PRIVATE, null);
    }
    public void SQLiteTableBuild() {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + SQLiteHelper.TABLE_NAME + "(" + SQLiteHelper.Table_Column_ID + " PRIMARY KEY , " + SQLiteHelper.Table_Column_1_Email + " VARCHAR, " + SQLiteHelper.Table_Column_2_Password + " VARCHAR);");
    }
    public void CheckEditTextStatus(){
        EmailHolder=username.getText().toString();
        PasswordHolder=password.getText().toString();
        repeatPasswordHolder=password.getText().toString();

        if(TextUtils.isEmpty(EmailHolder)||TextUtils.isEmpty(PasswordHolder) || TextUtils.isEmpty(repeatPasswordHolder)){
            EditTextEmptyHolder=false;

        }
        else{
            EditTextEmptyHolder=true;
        }

    }
    // Empty edittext after done inserting process method.
    public void EmptyEditTextAfterDataInsert(){
        username.getText().clear();
        password.getText().clear();
       repeatPassword.getText().clear();
    }
    public void CheckingEmailAlreadyExistsOrNot(){
        // Opening SQLite database write permission.
        sqLiteDatabase=sqLiteHelper.getWritableDatabase();
        // Adding search email query to cursor.
        cursor = sqLiteDatabase.query(SQLiteHelper.TABLE_NAME, null, " " + SQLiteHelper.Table_Column_1_Email + "=?", new String[]{EmailHolder}, null, null, null);
        while (cursor.moveToNext()) {
            if (cursor.isFirst()) {
                cursor.moveToFirst();
                // If Email is already exists then Result variable value set as Email Found.
                F_Result = "Email Found";
                // Closing cursor.
                cursor.close();
            }
        }
        // Calling method to check final result and insert data into SQLite database.
        CheckFinalResult();
    }
    // Checking result
    public void CheckFinalResult(){
        // Checking whether email is already exists or not.
        if(F_Result.equalsIgnoreCase("Email Found"))
        {
            // If email is exists then toast msg will display.
            Toast.makeText(Signup.this,"Email Already Exists",Toast.LENGTH_LONG).show();
        }
        else {
            // If email already dose n't exists then user registration details will entered to SQLite database.
            insertDataIntoSQLiteDatabase();
        }
        F_Result = "Not_Found" ;
    }
}

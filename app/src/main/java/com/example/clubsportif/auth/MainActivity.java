package com.example.clubsportif.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

import com.example.clubsportif.R;
import com.example.clubsportif.accueil.Accueil;
import com.example.clubsportif.sqlite.SQLiteHelper;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button loginButton;
    TextView linkSignup;
    FirebaseAuth firebaseAuth;
    String EmailHolder, PasswordHolder;
    Boolean EditTextEmptyHolder;
    SQLiteDatabase sqLiteDatabase;
    SQLiteHelper sqLiteHelper;
    Cursor cursor;
    String TempPassword = "NOT_FOUND" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        linkSignup = findViewById(R.id.linkSignup);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              /*  String user = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                if (user.isEmpty()) {
                    username.setError("Email cannot be empty");
                }
                if (pass.isEmpty()) {
                    password.setError("the password cannot be empty");
                } else {
                    System.out.println("every things is ok");
                }*/


                // Calling EditText is empty or no method.
                CheckEditTextStatus();
                // Calling login method.
                LoginFunction();

            }
        });
        linkSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Signup.class);
                startActivity(i);
            }
        });
    }
    // Login function starts from here.
    @SuppressLint("Range")
    public void LoginFunction(){
        if(EditTextEmptyHolder) {
            // Opening SQLite database write permission.
            //sqLiteDatabase = sqLiteHelper.getWritableDatabase();
            sqLiteDatabase = openOrCreateDatabase(SQLiteHelper.DATABASE_NAME, Context.MODE_PRIVATE, null);
            // Adding search email query to cursor.
            cursor = sqLiteDatabase.query(SQLiteHelper.TABLE_NAME, null, " " + SQLiteHelper.Table_Column_1_Email + "=?", new String[]{EmailHolder}, null, null, null);
            while (cursor.moveToNext()) {
                if (cursor.isFirst()) {
                    cursor.moveToFirst();
                    // Storing Password associated with entered email.
                    TempPassword = cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_Column_2_Password));
                    // Closing cursor.
                    cursor.close();
                }
            }
            // Calling method to check final result ..
            CheckFinalResult();
        }
        else {
            //If any of login EditText empty then this block will be executed.
            Toast.makeText(MainActivity.this,"Please Enter UserName or Password.",Toast.LENGTH_LONG).show();
        }
    }
    public void CheckFinalResult(){
        if(TempPassword.equalsIgnoreCase(PasswordHolder))
        {
            Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_LONG).show();
            Intent i = new Intent(getApplicationContext(), Accueil.class);
            startActivity(i);

        }
        else {
            Toast.makeText(MainActivity.this,"UserName or Password is Wrong, Please Try Again.",Toast.LENGTH_LONG).show();
        }
        TempPassword = "NOT_FOUND" ;
    }

    // Checking EditText is empty or not.
    public void CheckEditTextStatus() {
        // Getting value from All EditText and storing into String Variables.
        EmailHolder = username.getText().toString();
        PasswordHolder = password.getText().toString();
        // Checking EditText is empty or no using TextUtils.
        if (TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder)) {
            EditTextEmptyHolder = false;
        } else {
            EditTextEmptyHolder = true;
        }
    }
}

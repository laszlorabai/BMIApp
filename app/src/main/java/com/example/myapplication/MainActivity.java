package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getName();

    EditText userNameET;
    EditText passwordET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText userNameET = findViewById(R.id.editTextUserName);
        EditText passwordET = findViewById(R.id.editTextPassword);
    }

    public void login(View view){


        String userName = userNameET.getText().toString();
        String password = passwordET.getText().toString();

        Log.i(LOG_TAG, "Bejelentkezett: " + userName + ", jelszo:" + password );
    }


    public void register(View view) {
        Intent register = new Intent(this, RegisterActivity.class);
        startActivity(register);
    }
}
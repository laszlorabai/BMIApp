package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    private static final String LOG_TAG = RegisterActivity.class.getName();
    EditText usernameEditText;
    EditText userEmailEditText;
    EditText passwordEditText;
    EditText passwordAgainEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        int register_key = getIntent().getIntExtra("REGISTER_KEY", 0);

        if (register_key != 404) {
            finish();
        }
        usernameEditText = findViewById(R.id.userNameEditText);
        userEmailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        passwordAgainEditText = findViewById(R.id.passwordAgainEditText);
    }


    public void register(View view) {
        String userName = usernameEditText.getText().toString();
        String email = userEmailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String passwordAgain = passwordAgainEditText.getText().toString();

        if (!password.equals(passwordAgain)) {
            Log.e(LOG_TAG, "Nem egyeznek a jelszavak");
        }
        Log.i(LOG_TAG, "Regisztrált: " + userName + ", email:" + email);
    }

    public void cancel(View view) {
        finish();
    }
}
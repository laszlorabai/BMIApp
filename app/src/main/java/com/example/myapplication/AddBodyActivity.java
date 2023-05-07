package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddBodyActivity extends AppCompatActivity {

    private EditText weightEditText;
    private EditText dateEditText;
    private Button saveButton;
    private Button backButton;
    private AppDatabase db;
    private WeightDao weightDao;


    // Add your DAO and database instances here
    // private YourDatabase database;
    // private YourDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_body);

        weightEditText = findViewById(R.id.weightEditText);
        dateEditText = findViewById(R.id.dateEditText);
        saveButton = findViewById(R.id.saveButton);
        backButton = findViewById(R.id.backButton);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "weight_database")
                .allowMainThreadQueries()
                .build();
        weightDao = db.weightDao();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double weight = Double.parseDouble(weightEditText.getText().toString());
                String date = dateEditText.getText().toString();

                if (!TextUtils.isEmpty(weightEditText.getText()) && !TextUtils.isEmpty(dateEditText.getText())) {
                    Weight newWeight = new Weight(weight, date);
                    weightDao.insert(newWeight);
                    finish();
                } else {
                    Toast.makeText(AddBodyActivity.this, "Please enter weight and date.", Toast.LENGTH_SHORT).show();
                }
            }
        });


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}


package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class BodyActivity extends AppCompatActivity {
    private NotificationHandler mNotificationHandler;
    private FirebaseUser user;
    private Button addNewDataButton;
    private Button logoutButton;
    private AppDatabase db;
    private WeightDao weightDao;
    private RecyclerView weightRecyclerView;

    private static final String LOG_TAG = BodyActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body);
        addNewDataButton = findViewById(R.id.addNewDataButton);
        logoutButton = findViewById(R.id.logoutButton);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "weight_database")
                .allowMainThreadQueries()
                .build();
        weightDao = db.weightDao();
        weightRecyclerView = findViewById(R.id.weightRecyclerView);
        weightRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadData();
        mNotificationHandler = new NotificationHandler(this);

        addNewDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BodyActivity.this, AddBodyActivity.class);
                startActivity(intent);
            }
        });

        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            Log.d(LOG_TAG, "Validált felhasználó");
        } else {
            Log.d(LOG_TAG, "Invalid felhasználó");
            finish();
        }
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(BodyActivity.this, MainActivity.class);
                startActivity(intent);
                mNotificationHandler.send("Sikeres Kijelentkezés");
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }

    private void loadData() {
        List<Weight> weights = weightDao.getAll();
        WeightAdapter weightAdapter = new WeightAdapter(weights);
        weightRecyclerView.setAdapter(weightAdapter);
    }

}

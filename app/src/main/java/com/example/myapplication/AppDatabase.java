package com.example.myapplication;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Weight.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract WeightDao weightDao();
}

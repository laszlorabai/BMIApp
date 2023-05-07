package com.example.myapplication;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "weights")
public class Weight {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public double weight;
    public String date;

    public Weight(double weight, String date) {
        this.weight = weight;
        this.date = date;
    }
}


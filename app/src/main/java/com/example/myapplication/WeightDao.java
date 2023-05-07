package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WeightDao {
    @Query("SELECT * FROM weights")
    List<Weight> getAll();

    @Insert
    void insert(Weight weight);

    @Update
    void update(Weight weight);

    @Delete
    void delete(Weight weight);
}

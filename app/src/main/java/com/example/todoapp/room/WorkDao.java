package com.example.todoapp.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.todoapp.model.Work;

import java.util.List;

@Dao

public interface WorkDao {
    @Query("SELECT * FROM work")
    LiveData<List<Work>> getAll();

    @Insert
    void insert(Work work);

    @Delete
    void delete(Work work);

    @Update
    void update(Work work);


}

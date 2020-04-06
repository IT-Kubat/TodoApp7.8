package com.example.todoapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity

public class Work implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String title;
    private String description;

    public Work(String title, String description) {

        this.title = title;
        this.description = description;

    }

    public Work(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

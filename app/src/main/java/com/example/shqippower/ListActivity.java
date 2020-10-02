package com.example.shqippower;

import java.io.Serializable;
import java.sql.Time;

public class ListActivity implements Serializable {
    private String title;
    private String type;
    private String time;

    public ListActivity(String title, String type, String time){
        this.title = title;
        this.type = type;
        this.time = time;
    }

    public ListActivity(){}

    public String getTitle() { return title; }

    public String getType() { return type; }

    public String getTime() { return time; }

    public void setTitle(String title) { this.title = title; }

    public void setType(String type) { this.type = type; }

    public void setTime(String time) { this.time = time; }
}

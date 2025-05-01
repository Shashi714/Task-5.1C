package com.example.newsapp;
import java.io.Serializable;
public class News implements Serializable{
    public String title;
    public String description;
    public int imageResId;

    public News(String title, String description, int imageResId) {
        this.title = title;
        this.description = description;
        this.imageResId = imageResId;
    }
}
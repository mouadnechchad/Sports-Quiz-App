package com.euromedcompany.sportsquiz;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

//Sport class
public class Sport {
    private String name;
    private int imageResourceId;

    public Sport(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
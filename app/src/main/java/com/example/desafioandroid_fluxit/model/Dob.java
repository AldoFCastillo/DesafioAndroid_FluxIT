package com.example.desafioandroid_fluxit.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Dob implements Serializable {

    @SerializedName("date")
    private String date;
    @SerializedName("age")
    private String age;

    public Dob() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

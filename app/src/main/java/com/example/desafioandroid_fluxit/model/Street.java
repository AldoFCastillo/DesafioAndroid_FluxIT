package com.example.desafioandroid_fluxit.model;

import com.google.gson.annotations.SerializedName;

public class Street {

    @SerializedName("number")
    private Integer number;
    @SerializedName("name")
    private String name;

    public Street() {
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

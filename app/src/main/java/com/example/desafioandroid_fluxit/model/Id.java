package com.example.desafioandroid_fluxit.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Id implements Serializable {

    @SerializedName("name")
    private String name;
    @SerializedName("value")
    private String value;

    public Id() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

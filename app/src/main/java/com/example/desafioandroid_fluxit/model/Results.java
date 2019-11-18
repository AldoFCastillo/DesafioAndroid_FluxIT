package com.example.desafioandroid_fluxit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Results {

    @SerializedName("results")
    private List<Person> results = null;
    @SerializedName("info")
    private Info info;

}

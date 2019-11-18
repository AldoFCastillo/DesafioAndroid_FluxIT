package com.example.desafioandroid_fluxit.model;

import com.google.gson.annotations.SerializedName;

public class Info {

    @SerializedName("seed")
    private String seed;
    @SerializedName("results")
    private Integer results;
    @SerializedName("page")
    private Integer page;
    @SerializedName("version")
    private String version;
}

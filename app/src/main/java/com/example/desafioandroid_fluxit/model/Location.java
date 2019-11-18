package com.example.desafioandroid_fluxit.model;

import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("street")
    private Street street;
    @SerializedName("city")
    private String city;
    @SerializedName("state")
    private String state;
    @SerializedName("country")
    private String country;
    @SerializedName("postcode")
    private Integer postcode;
    @SerializedName("coordinates")
    private Coordinates coordinates;

}

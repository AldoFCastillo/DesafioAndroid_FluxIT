package com.example.desafioandroid_fluxit.model;

import com.google.gson.annotations.SerializedName;

public class Person {

    @SerializedName("gender")
    private String gender;
    @SerializedName("name")
    private Name name;
    @SerializedName("location")
    private Location location;
    @SerializedName("email")
    private String email;
    @SerializedName("dob")
    private Dob dob;
    @SerializedName("phone")
    private String phone;
    @SerializedName("cell")
    private String cell;
    @SerializedName("id")
    private Id id;
    @SerializedName("picture")
    private Picture picture;
    @SerializedName("nat")
    private String nat;
}

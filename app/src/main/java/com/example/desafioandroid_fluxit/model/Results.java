package com.example.desafioandroid_fluxit.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Results implements Serializable {

    @SerializedName("results")
    private List<Person> results = null;
    @SerializedName("info")
    private Info info;

    public Results() {
    }

    public List<Person> getResults() {
        return results;
    }

    public void setResults(List<Person> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}

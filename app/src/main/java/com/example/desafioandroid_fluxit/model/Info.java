package com.example.desafioandroid_fluxit.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Info implements Serializable {

    @SerializedName("seed")
    private String seed;
    @SerializedName("results")
    private String results;
    @SerializedName("page")
    private String page;
    @SerializedName("version")
    private String version;

    public Info() {
    }

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}

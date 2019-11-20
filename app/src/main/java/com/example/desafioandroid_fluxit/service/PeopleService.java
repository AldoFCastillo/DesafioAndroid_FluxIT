package com.example.desafioandroid_fluxit.service;

import com.example.desafioandroid_fluxit.model.Results;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PeopleService {

    @GET("?results=20")
    Call<Results> getResults();



}

package com.example.desafioandroid_fluxit.service;

import com.example.desafioandroid_fluxit.model.Results;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PeopleService {



    @GET("api/")
    Call<Results> getResults(@Query("results") Integer results);


}

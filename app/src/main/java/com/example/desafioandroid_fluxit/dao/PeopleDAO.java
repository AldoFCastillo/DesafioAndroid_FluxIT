package com.example.desafioandroid_fluxit.dao;

import com.example.desafioandroid_fluxit.model.Results;
import com.example.desafioandroid_fluxit.service.PeopleService;
import com.example.desafioandroid_fluxit.utils.ResultListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PeopleDAO {

    public static final String BASE_URL = "https://randomuser.me/api/";
    private Retrofit retrofit;
    private PeopleService peopleService;
    private showError showError;
    private Integer items = 20;


    public void setShowError(PeopleDAO.showError showError) {
        this.showError = showError;
    }

    public PeopleDAO() {

        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        peopleService = retrofit.create(PeopleService.class);

    }

    public void getPeopleList(final ResultListener<Results> listener) {

        Call<Results> resultsCall = peopleService.getResults();

        resultsCall.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                if (response.isSuccessful()) {
                    Results results = response.body();

                    listener.onFinish(results);
                } //else                    showError.error("Ocurrio un Error");
            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {

                String message = t.getMessage();
                System.out.println("Ha ocurrido un error" + message);
                t.printStackTrace();

            }
        });
    }


    public interface showError {
        void error(String error);
    }
}

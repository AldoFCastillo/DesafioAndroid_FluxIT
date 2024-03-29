package com.example.desafioandroid_fluxit.controller;

import com.example.desafioandroid_fluxit.dao.PeopleDAO;
import com.example.desafioandroid_fluxit.model.Results;
import com.example.desafioandroid_fluxit.utils.ResultListener;

public class PeopleController {

    private PeopleDAO peopleDAO;

    public PeopleController(PeopleDAO.ShowError showError) {
        this.peopleDAO = new PeopleDAO();
        peopleDAO.setShowError(showError);
    }

    public void getPeopleList(final ResultListener<Results> listener){
        peopleDAO.getPeopleList(new ResultListener<Results>() {
            @Override
            public void onFinish(Results result) {
                listener.onFinish(result);
            }
        });
    }




}

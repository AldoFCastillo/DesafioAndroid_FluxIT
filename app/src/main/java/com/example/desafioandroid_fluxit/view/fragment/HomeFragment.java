package com.example.desafioandroid_fluxit.view.fragment;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.desafioandroid_fluxit.R;
import com.example.desafioandroid_fluxit.controller.PeopleController;
import com.example.desafioandroid_fluxit.model.Person;
import com.example.desafioandroid_fluxit.model.Results;
import com.example.desafioandroid_fluxit.utils.ResultListener;
import com.example.desafioandroid_fluxit.view.adapter.PeopleAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements PeopleAdapter.PeopleAdapterListener {

    @BindView(R.id.recyclerViewHomeFragment)
    RecyclerView recyclerViewHomeFragment;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    private notifier aNotifier;

    private List<Person> personList = new ArrayList<>();


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.aNotifier = (notifier) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        showProgressView();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerViewHomeFragment.setLayoutManager(layoutManager);

        PeopleController peopleController = new PeopleController();
        callAPI(peopleController);
        refresh(peopleController);


        return view;
    }

    public void callAPI(PeopleController peopleController) {
        peopleController.getPeopleList(new ResultListener<Results>() {
            @Override
            public void onFinish(Results result) {
                personList = result.getResults();
                hideProgressView();
                PeopleAdapter peopleAdapter = new PeopleAdapter(personList, HomeFragment.this);
                recyclerViewHomeFragment.setAdapter(peopleAdapter);
                swipeRefreshLayout.setRefreshing(false);
                recyclerViewHomeFragment.setHasFixedSize(true);
                recyclerViewHomeFragment.setItemViewCacheSize(20);
            }
        });
    }

    public void refresh(PeopleController peopleController){
        swipeRefreshLayout.setOnRefreshListener(() -> {
            personList.clear();
            callAPI(peopleController);
        });
    }

    void showProgressView () {
        progressBar.setVisibility(View.VISIBLE);
    }

    void hideProgressView () {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void choice(Person person) {
        aNotifier.sendNotification(person);
    }

    public interface notifier {
        public void sendNotification(Person person);
    }

}

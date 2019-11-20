package com.example.desafioandroid_fluxit.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.SearchView;

import com.example.desafioandroid_fluxit.R;
import com.example.desafioandroid_fluxit.controller.PeopleController;
import com.example.desafioandroid_fluxit.model.Person;
import com.example.desafioandroid_fluxit.model.Results;
import com.example.desafioandroid_fluxit.utils.ResultListener;
import com.example.desafioandroid_fluxit.view.fragment.MapFragment;
import com.example.desafioandroid_fluxit.view.fragment.HomeFragment;
import com.google.android.material.snackbar.Snackbar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements HomeFragment.notifier{

    private HomeFragment homeFragment;
    private FragmentManager fragmentManager;
    @BindView(R.id.fragmentContainerMainActivity)
    CoordinatorLayout fragmentContainerMainActivity;
    private Results results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        handleIntent(getIntent());


        homeFragment = new HomeFragment();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction unaTransaccion = fragmentManager.beginTransaction();
        unaTransaccion.replace(R.id.fragmentContainerMainActivity, homeFragment);
        unaTransaccion.commit();


    }

    @Override
    public void sendNotification(Person person) {

        Intent intent = new Intent(this, DetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(DetailsActivity.KEY_PERSON, person);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);

        }
    }
}

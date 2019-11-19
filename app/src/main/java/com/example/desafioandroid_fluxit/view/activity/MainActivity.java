package com.example.desafioandroid_fluxit.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.desafioandroid_fluxit.R;
import com.example.desafioandroid_fluxit.model.Person;
import com.example.desafioandroid_fluxit.view.fragment.HomeFragment;
import com.google.android.material.snackbar.Snackbar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements HomeFragment.notifier{

    private HomeFragment homeFragment;
    private FragmentManager fragmentManager;
    @BindView(R.id.fragmentContainerMainActivity)
    CoordinatorLayout fragmentContainerMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


        homeFragment = new HomeFragment();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction unaTransaccion = fragmentManager.beginTransaction();
        unaTransaccion.replace(R.id.fragmentContainerMainActivity, homeFragment);
        unaTransaccion.commit();


    }

    @Override
    public void sendNotification(Person person) {
        String completeName = person.getName().getFirst();
        Snackbar.make(fragmentContainerMainActivity, "Seleccionaste " + completeName, Snackbar.LENGTH_SHORT).show();
    }
}

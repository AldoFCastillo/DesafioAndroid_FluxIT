package com.example.desafioandroid_fluxit.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.desafioandroid_fluxit.R;
import com.example.desafioandroid_fluxit.view.fragment.HomeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private HomeFragment homeFragment;
    private FragmentManager fragmentManager;
    @BindView(R.id.fragmentContainerMainActivity)
    ConstraintLayout fragmentContainerMainActivity;

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
}

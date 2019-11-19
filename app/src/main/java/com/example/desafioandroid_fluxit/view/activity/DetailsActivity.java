package com.example.desafioandroid_fluxit.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.desafioandroid_fluxit.R;
import com.example.desafioandroid_fluxit.model.Person;
import com.example.desafioandroid_fluxit.view.fragment.MapFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    private MapFragment mapFragment;

    public static final String KEY_PERSON = "person";


    @BindView(R.id.imageViewPhotoDetailsActivity)
    ImageView imageViewPhotoDetailsActivity;
    @BindView(R.id.textViewNameDetailsActivity)
    TextView textViewNameDetailsActivity;
    @BindView(R.id.textViewLastNameDetailsActivity)
    TextView textViewLastNameDetailsActivity;
    @BindView(R.id.textViewAgeDetailsActivity)
    TextView textViewAgeDetailsActivity;
    @BindView(R.id.textViewMailDetailsActivity)
    TextView textViewMailDetailsActivity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        Person person = (Person) bundle.getSerializable(KEY_PERSON);

        Glide.with(this).load(person.getPicture().getLarge()).into(imageViewPhotoDetailsActivity);
        textViewNameDetailsActivity.setText(person.getName().getFirst());
        textViewLastNameDetailsActivity.setText(person.getName().getLast());
        String anios = person.getDob().getAge() + " años";
        textViewAgeDetailsActivity.setText(anios);
        textViewMailDetailsActivity.setText(person.getEmail());


        /*mapFragment.setArguments(bundle);
        FragmentManager miFragmentManager = getSupportFragmentManager();
        FragmentTransaction unaTransaccion = miFragmentManager.beginTransaction();
        unaTransaccion.replace(R.id.detailsActivity, mapFragment);
        unaTransaccion.commit();*/
    }
}

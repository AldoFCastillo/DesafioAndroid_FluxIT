package com.example.desafioandroid_fluxit.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.desafioandroid_fluxit.R;
import com.example.desafioandroid_fluxit.model.Person;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

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
    @BindView(R.id.buttonMap)
    FloatingActionButton buttonMap;


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

        buttonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(DetailsActivity.this, MapActivity.class);
                    Bundle mapBundle = new Bundle();
                    Double latitude = person.getLocation().getCoordinates().getLatitude();
                    Double longitude = person.getLocation().getCoordinates().getLongitude();
                    mapBundle.putDouble(MapActivity.LATITUDE, latitude );
                    mapBundle.putDouble(MapActivity.LONGITUDE, longitude);
                    intent.putExtras(mapBundle);
                    startActivity(intent);
            }

        });


    }
}
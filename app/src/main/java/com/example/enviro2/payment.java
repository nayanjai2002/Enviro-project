package com.example.enviro2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class payment extends AppCompatActivity {
     Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        getSupportActionBar().setTitle("Bonus");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}

package com.example.farmerportal;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class dashboardfarmer extends AppCompatActivity {

// Variables
    TextView USER;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboardfarmer);
        String user=getIntent().getStringExtra("username");
        USER=(TextView)findViewById(R.id.placeuser);
        USER.setText(user);


        //Define Hooks



    }
}

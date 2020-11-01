package com.example.farmerportal;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class dashboardconsultant extends AppCompatActivity {


    TextView USER;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboardconsultant);
        String user=getIntent().getStringExtra("username");
        USER=(TextView)findViewById(R.id.placeuser);
        USER.setText(user);
    }
}

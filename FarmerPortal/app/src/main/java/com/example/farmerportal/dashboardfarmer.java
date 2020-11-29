package com.example.farmerportal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class dashboardfarmer extends AppCompatActivity {

// Variables
    TextView USER;


    Button btn,btndealer,btnconsultant,btnfinder,logout;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboardfarmer);

        USER=(TextView)findViewById(R.id.placeuser);

        btnfinder=findViewById(R.id.buttonfinder);
        btnfinder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(dashboardfarmer.this,googlemap.class);
                startActivity(it);
            }
        });

        final String user=getIntent().getStringExtra("username");
        USER.setText(user);

        btn=(Button)findViewById(R.id.buttonprofile);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //pass


                Intent it=new Intent(dashboardfarmer.this,farmerprofile.class);
                it.putExtra("user",user);
                startActivity(it);
            }
        });

        logout=findViewById(R.id.buttonlogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it =new Intent(dashboardfarmer.this,RegisterActivity.class);
                startActivity(it);
            }
        });

        btndealer=findViewById(R.id.buttondealer);
        btndealer.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent it =new Intent(dashboardfarmer.this,searchdealer.class);
                it.putExtra("user",user);
                startActivity(it);
            }
        });


        //
        btnconsultant=findViewById(R.id.buttonconsultant);
        btnconsultant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(dashboardfarmer.this,searchconsultant.class);
                it.putExtra("user",user);
                startActivity(it);
            }
        });


        //Define Hooks



    }
}

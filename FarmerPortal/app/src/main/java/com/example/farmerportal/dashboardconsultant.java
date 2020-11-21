package com.example.farmerportal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class dashboardconsultant extends AppCompatActivity {

    Button btn,btnfarmer,logout;
    TextView USER;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboardconsultant);
        final String user=getIntent().getStringExtra("username");
        USER=(TextView)findViewById(R.id.placeuser);
        USER.setText(user);
        btnfarmer=findViewById(R.id.buttonfinder);

        btnfarmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it =new Intent(dashboardconsultant.this,searchfarmer.class);
                startActivity(it);
            }
        });

        logout=findViewById(R.id.buttonlogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(dashboardconsultant.this,RegisterActivity.class);
                startActivity(it);
            }
        });

        btn=findViewById(R.id.buttonprofile);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(dashboardconsultant.this,consultantprofile.class);
                it.putExtra("user",user);
                startActivity(it);
            }
        });

    }
}

package com.example.farmerportal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class dashboarddealer extends AppCompatActivity {
    TextView USER;
    Button btn,btnfarmer,logout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboarddealer);
       final  String user=getIntent().getStringExtra("username");
        USER=(TextView)findViewById(R.id.placeuser);
        USER.setText(user);


        btnfarmer=findViewById(R.id.buttonfinder);

        btnfarmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it =new Intent(dashboarddealer.this,searchfarmer.class);
                it.putExtra("user", getIntent().getStringExtra("username"));
                startActivity(it);
            }
        });

        logout=findViewById(R.id.buttonlogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(dashboarddealer.this,RegisterActivity.class);
                startActivity(it);
            }
        });


        btn=(Button)findViewById(R.id.buttonprofile);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //pass


                Intent it=new Intent(dashboarddealer.this,dealerprofile.class);
                it.putExtra("user",user);
                startActivity(it);
            }
        });


    }
}

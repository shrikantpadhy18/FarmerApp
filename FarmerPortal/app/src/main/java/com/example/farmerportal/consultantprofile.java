package com.example.farmerportal;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class consultantprofile extends AppCompatActivity {

    TextView pno,uname;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultantprofile);
        String user=getIntent().getStringExtra("user");
        DatabaseHelper mydb=new DatabaseHelper(this);
        //String Phone=mydb.accessPhone(user);
        pno=findViewById(R.id.phone);
        uname=findViewById(R.id.username);
        //pno.setText(Phone);
        uname.setText(user);

    }
}


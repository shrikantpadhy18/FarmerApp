package com.example.farmerportal;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class farmerprofile extends AppCompatActivity {


    TextView pno,uname;
    ImageView source;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmerprofile);
        DatabaseHelper mydb=new DatabaseHelper(this);
        String user=getIntent().getStringExtra("user");

       // source=findViewById(R.id.source);
        //source.setImageBitmap(mydb.getImage(user));
        //String Phone=mydb.accessPhone(user);
        pno=findViewById(R.id.phone);
        uname=findViewById(R.id.username);
        //pno.setText(Phone);
        uname.setText(user);



    }
}

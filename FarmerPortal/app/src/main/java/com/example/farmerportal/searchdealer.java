package com.example.farmerportal;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class searchdealer extends AppCompatActivity {


    /**
     *
     */

    DatabaseHelper mydb;
    TextView usertype;
    TextView username;
    TextView phone;
    ///////////////////////////////////////////////////
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchdealer);
        mydb=new DatabaseHelper(this);
        ArrayList<String>ah=mydb.getDealers();

        int size=ah.size();
        int k=0;
        while(k<size) {
            for (int i = k; i < size; i++) {
                int j = i % 3;

                username = findViewById(R.id.username);
                phone = findViewById(R.id.mobile);
                usertype = findViewById(R.id.usertype);
                if (j == 0)
                    username.setText(ah.get(i));

                else if (j == 1)
                    phone.setText(ah.get(i));
                else{
                    usertype.setText(ah.get(i));
                    k += 1;
                    break;
                }

                k += 1;
            }
        }

    }
}

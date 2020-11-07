package com.example.farmerportal;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class searchdealer extends AppCompatActivity {


    /**
     *
     */


    RecyclerView recyclerView;
    dealeradapter adapter;
    List<Dealerstats>dealerstatsList;

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

        dealerstatsList=new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String user=null,type=null,pno=null;

        int size=ah.size();
        int k=0;
        while(k<size) {
            for (int i = k; i < size; i++) {
                int j = i % 3;


                if (j == 0)
                    user=ah.get(i);

                else if (j == 1)
                    type=ah.get(i);
                else{
                    pno=ah.get(i);
                    k += 1;
                    break;
                }

                k += 1;
            }

            dealerstatsList.add(new Dealerstats(
                    user,
                    type,
                    pno
            ));

        }

        adapter=new dealeradapter(this,dealerstatsList);
        recyclerView.setAdapter(adapter);



        }

    }


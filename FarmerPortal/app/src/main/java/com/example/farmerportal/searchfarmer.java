package com.example.farmerportal;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class searchfarmer extends AppCompatActivity {

    RecyclerView recyclerView;

    farmeradapter adapter;
    List<Farmerstats>farmerstatsList;
    DatabaseHelper mydb;
    TextView usertype;
    TextView username;
    TextView phone;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchfarmer);
        mydb=new DatabaseHelper(this);
        ArrayList<String> ah=mydb.getFarmers();
        farmerstatsList=new ArrayList<>();
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

            farmerstatsList.add(new Farmerstats(
                    user,
                    type,
                    pno
            ));

        }

        adapter=new farmeradapter(farmerstatsList, this);
        recyclerView.setAdapter(adapter);

    }
}

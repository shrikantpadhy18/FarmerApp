package com.example.farmerportal;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class searchconsultant extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView usertype;
    TextView username;
    TextView phone;
    consultantadapter adapter;

    List<Consultantstats>consultantstatslist;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchconsultant);

        DatabaseHelper mydb;
        mydb=new DatabaseHelper(this);

        ArrayList<String>ah=mydb.getConsultant();
        consultantstatslist=new ArrayList<>();
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

            consultantstatslist.add(new Consultantstats(
                    user,
                    type,
                    pno
            ));

        }


        adapter=new consultantadapter(consultantstatslist, this);
        recyclerView.setAdapter(adapter);

    }
}

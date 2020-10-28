package com.example.farmerportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText mtextusername,mtextpassword;
    Button mbuttonlogin;
    TextView mTextviewregister;
    Spinner drop;
    private static final String[]user={"Farmer","Dealer","Consultant"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drop=findViewById(R.id.spinner);
        mtextusername=findViewById(R.id.edittext_username);
        mtextpassword=findViewById(R.id.edittext_password);
        mbuttonlogin=findViewById(R.id.button_login);
        mTextviewregister=findViewById(R.id.textview_register);

        //adapter of user
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item,user);

        //passing this array adapter to the spinner

        drop.setAdapter(adapter);
        mTextviewregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent =new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(registerIntent);
            }
        });


    }
}

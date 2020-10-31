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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mtextusername,mtextpassword;
    Button mbuttonlogin;
    TextView mTextviewregister;
    Spinner drop;
    private static final String[]user={"Farmer","Dealer","Consultant"};
    DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drop=findViewById(R.id.spinner);
        mtextusername=findViewById(R.id.edittext_username);
        mtextpassword=findViewById(R.id.edittext_password);
        mbuttonlogin=findViewById(R.id.button_login);
        mTextviewregister=findViewById(R.id.textview_register);

        //database loaded
        mydb=new DatabaseHelper(this);
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


        search();
    }
    public  void search(){
       mbuttonlogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String username=mtextusername.getText().toString();
               String password=mtextpassword.getText().toString();
               String usertype=drop.getSelectedItem().toString();
               int count=mydb.accessUser(username,password,usertype);
               //If count is zero so user dont exist;
               if(count==0){
                   Toast.makeText(MainActivity.this, "SUCH USER DONT EXIST", Toast.LENGTH_SHORT).show();


               }
               else{
                   //After login it checks the type of user based on which it will redirected to activity

                   Toast.makeText(MainActivity.this, "LOGIN SUCCESSFUL NOW U WILL BE DIRECTED AS PER USER TYPE", Toast.LENGTH_SHORT).show();
                   //1)if the user is Farmer

                    if(usertype=="Farmer"){
                        Intent it=new Intent(MainActivity.this,dashboardfarmer.class);
                        it.putExtra("username",username);
                        startActivity(it);
                    }


                   //2)If the user is Dealer

                    else if(usertype=="Dealer"){

                   }


                   //3)If the user is Consultant
                    else{

                    }
               }
           }
       });
    }
}

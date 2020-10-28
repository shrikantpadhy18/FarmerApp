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





public class RegisterActivity extends AppCompatActivity {
    EditText mtextusername,mtextpassword;
    Button mbuttonregister;
    TextView mTextviewlogin;
    EditText mtextCnfPassword;
    EditText Phone;
    Spinner drop;

    //database part

    DatabaseHelper mydb;
    //Types of user
    private static final String[]user={"Farmer","Dealer","Consultant"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mtextusername=findViewById(R.id.edittext_username);
        mtextpassword=findViewById(R.id.edittext_password);
        mtextCnfPassword=findViewById(R.id.edittext_cnf_password);
        mbuttonregister=findViewById(R.id.button_register);
        mTextviewlogin=findViewById(R.id.textview_register);
        Phone=findViewById(R.id.phoneno);
        drop=findViewById(R.id.spinner);


    //adapter of user
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(RegisterActivity.this,
                android.R.layout.simple_spinner_item,user);

        //passing this array adapter to the spinner

        drop.setAdapter(adapter);
        mTextviewlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent LoginIntent =new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(LoginIntent);
            }
        });



    mydb=new DatabaseHelper(this);
    Adddata();
    }
    public  void  Adddata(){
        mbuttonregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username=mtextusername.getText().toString();
                String password=mtextpassword.getText().toString();
                String confirmpassword=mtextCnfPassword.getText().toString();
                String usertype=drop.toString();
                String number=Phone.toString();
                boolean isInserted=mydb.inserData(username,password,usertype,number);
                if(isInserted){
                    Toast.makeText(RegisterActivity.this,"SUCCESSFULLY REGISTERED AS "+usertype,Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(RegisterActivity.this," REGISTRATION UNSUCCESSFULL AS "+usertype,Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}




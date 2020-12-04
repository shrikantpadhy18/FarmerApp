package com.example.farmerportal;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


public class RegisterActivity extends AppCompatActivity {
    EditText mtextusername,mtextpassword;
    Button mbuttonregister,profile;
    TextView mTextviewlogin;
    EditText mtextCnfPassword;
    EditText Phone;
    Spinner drop;
    ImageView ivImage;
    Integer REQUEST_CAMERA=1,SELECT_FILE=0;


    //image view


    //database part

    DatabaseHelper mydb;


    //FOR IMAGE
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
        ivImage=findViewById(R.id.ivimage);
        profile=findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                selectimage();
            }
        });
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

    private void selectimage(){
        final CharSequence[] items={"Camera","Gallery","Cancel"};
        AlertDialog.Builder builder=new AlertDialog.Builder(RegisterActivity.this);
        builder.setTitle("Add Image");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(items[which].equals("Camera")){
                    Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent,REQUEST_CAMERA);

                }
                else if(items[which].equals("Gallery")){

                    Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    startActivityForResult(intent.createChooser(intent," Select File"),SELECT_FILE);

                }else if(items[which].equals("Cancel")){
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    public void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode== Activity.RESULT_OK){
            if(requestCode==REQUEST_CAMERA){
            Bundle bundle=data.getExtras();
            final Bitmap bmp=(Bitmap)bundle.get("data");
            ivImage.setImageBitmap(bmp);

            }
            else  if(requestCode==SELECT_FILE){


                try{
                    Uri selectedImageUri;
                    selectedImageUri = data.getData();
                    InputStream inputStream=getContentResolver().openInputStream(selectedImageUri);
                    Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
                    ivImage.setImageBitmap(bitmap);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }
    }



    public  void  Adddata(){
        mbuttonregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username=mtextusername.getText().toString();
                String password=mtextpassword.getText().toString();
                String confirmpassword=mtextCnfPassword.getText().toString();
                String usertype=drop.getSelectedItem().toString();

                String number=Phone.getText().toString();
                boolean isInserted=mydb.inserData(username,password,usertype,number,imageViewToByte(ivImage));
                if(isInserted==true && username.length()>0 && password.equals(confirmpassword) &&  password.length()>0 ){
                    Toast.makeText(RegisterActivity.this,"SUCCESSFULLY REGISTERED AS "+usertype,Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(RegisterActivity.this," REGISTRATION UNSUCCESSFULL AS "+usertype,Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private byte[] imageViewToByte(ImageView image){
        Bitmap bitmap =((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte [] byteArray=stream.toByteArray();
        return byteArray;
    }


}




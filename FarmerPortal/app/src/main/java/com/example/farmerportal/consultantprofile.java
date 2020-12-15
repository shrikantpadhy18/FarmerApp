package com.example.farmerportal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class consultantprofile extends AppCompatActivity {

    TextView pno,uname;
    private StorageReference storageReference;
    ImageView source;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultantprofile);
        String user=getIntent().getStringExtra("user");
        DatabaseHelper mydb=new DatabaseHelper(this);
        //String Phone=mydb.accessPhone(user);
        source=findViewById(R.id.source);
        storageReference= FirebaseStorage.getInstance().getReference().child("images/"+user);
        try {
            final File localfile=File.createTempFile(user,"jpeg");
            storageReference.getFile(localfile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(consultantprofile.this,"picture retrieved",Toast.LENGTH_SHORT).show();
                    Bitmap bitmap= BitmapFactory.decodeFile(localfile.getAbsolutePath());
                    source.setImageBitmap(bitmap);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(consultantprofile.this,"picture retrieved failed",Toast.LENGTH_SHORT).show();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }


        // source=findViewById(R.id.source);
        //source.setImageBitmap(mydb.getImage(user));
        //String Phone=mydb.accessPhone(user);

        uname=findViewById(R.id.username);

        uname.setText(user);




    }
}


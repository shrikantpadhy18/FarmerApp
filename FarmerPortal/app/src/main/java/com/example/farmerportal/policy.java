package com.example.farmerportal;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class policy extends AppCompatActivity {
    ListView lvProgram;

    String []programName={"Schemes 1","Schemes 2","Schemes 3","Schemes 4","Schemes 5","Schemes 6"};
    String []programDescription={"PRADHAN MANTRI FASAL BIMA YOJANA","PRADHAN MANTRI KISAN MAAN DHAN YOJANA","PRADHAN MANTRI KRISHI SINCHAYEE YOJANA","DIRECT BENEFIT TRANSFER SCHEME","PASHU KISAN CREDIT CARD YOJANA","PRADHAN MANTRI KISAAN SAMMAAN NIDHI YOJANA"};
    String [] urls={"https://vikaspedia.in/agriculture/agri-insurance/pradhan-mantri-fasal-bima-yojana","https://pmkisan.gov.in/Documents/PM-KMY%20-%20Salient%20Features.pdf","https://pmksy.gov.in/","https://dbtdacfw.gov.in/schemes1.aspx","https://krishijagran.com/agriculture-world/pashu-kisan-credit-card-yojana-eligibility-benefits-loan-amount-necessary-documents-methods-to-apply/","https://pmkisan.gov.in/"};
    int[] programImages={R.drawable.pradhanmantrifasalbimayojana,R.drawable.pradhanmantrikisanmaandhaanyojana,R.drawable.pradhanmantrikrishisinchayeeyojana,R.drawable.directbenefittransferscheme,R.drawable.pashukisancreditcardyojana,R.drawable.pradhanmantrikisansammaannidhiyojana};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy);
        lvProgram=findViewById(R.id.lvprogram);
        ProgramAdapter programAdapter=new ProgramAdapter(this,programName,programImages,programDescription,urls);
        lvProgram.setAdapter(programAdapter);


    }
}

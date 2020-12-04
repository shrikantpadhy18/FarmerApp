package com.example.farmerportal;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProgramViewHolder {

    ImageView itemImage;
    TextView programTitle;
    TextView programDescription;
    ProgramViewHolder(View v){
        itemImage=v.findViewById(R.id.imageView);
        programTitle=v.findViewById(R.id.textview1);
        programDescription=v.findViewById(R.id.textview2);

    }
}

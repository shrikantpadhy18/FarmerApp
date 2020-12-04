package com.example.farmerportal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class ProgramAdapter extends ArrayAdapter<String> {


    Context context;
    int [] images;
    String [] programName;
    String []  programDescription;
    String [] urls;
    public ProgramAdapter(Context context, String [] programName,int [] images,String [] programDescription,String []urls) {
        super(context, R.layout.single_item,R.id.textview1,programName);
        this.context=context;
        this.images=images;
        this.programName=programName;
        this.programDescription=programDescription;

        this.urls=urls;


    }

    public View getView(int position, View contentView, ViewGroup parent){
        View singleItem=contentView;
        ProgramViewHolder holder=null;
        if(singleItem==null){
            LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            singleItem=layoutInflater.inflate(R.layout.single_item,parent,false);
            holder=new ProgramViewHolder(singleItem);
            singleItem.setTag(holder);
        }

        else {
            holder= (ProgramViewHolder) singleItem.getTag();

        }

        holder.itemImage.setImageResource(images[position]);
        holder.programTitle.setText(programName[position]);
        holder.programDescription.setText(programDescription[position]);
        singleItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getContext(),"clicked"+programName[position],Toast.LENGTH_SHORT);
                Intent openLinksIntent=new Intent(Intent.ACTION_VIEW, Uri.parse(urls[position]));
                context.startActivity(openLinksIntent);
            }
        });
        return singleItem;

    }
}

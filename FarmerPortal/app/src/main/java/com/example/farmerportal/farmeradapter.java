package com.example.farmerportal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class farmeradapter  extends RecyclerView.Adapter<farmeradapter.farmerviewholder> {


    private List<Farmerstats> farmerstatslist;



    private Context mtx;

    public farmeradapter.farmerviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflatter=LayoutInflater.from(mtx);

        View view=inflatter.inflate(R.layout.list_layout,null);
        farmerviewholder holder=new farmerviewholder(view);


        return holder;
    }

    public farmeradapter(List<Farmerstats> farmerstatslist, Context mtx) {
        this.farmerstatslist = farmerstatslist;
        this.mtx = mtx;
    }

    @Override
    public void onBindViewHolder(@NonNull farmeradapter.farmerviewholder holder, int position) {
    Farmerstats farmer=farmerstatslist.get(position);
        holder.username.setText(farmer.getUsername());
        holder.usertype.setText(farmer.getUsertype());
        holder.phone.setText(farmer.getMobile());
    }

    @Override
    public int getItemCount() {
        return farmerstatslist.size();
    }

    class  farmerviewholder extends RecyclerView.ViewHolder{

        TextView username,usertype,phone;
        public farmerviewholder(@NonNull View itemView) {
            super(itemView);


            username=itemView.findViewById(R.id.username);
            usertype=itemView.findViewById(R.id.usertype);
            phone=itemView.findViewById(R.id.mobile);
        }
    }
}

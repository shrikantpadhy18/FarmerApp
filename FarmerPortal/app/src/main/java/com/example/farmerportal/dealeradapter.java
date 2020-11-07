package com.example.farmerportal;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//recycler adapter
//viewholder
public class dealeradapter extends  RecyclerView.Adapter<dealeradapter.dealerviewholder> {



    private Context mtx;
    private List<Dealerstats>dealerlist;


    public dealeradapter(Context mtx, List<Dealerstats> dealerlist) {
        this.mtx = mtx;
        this.dealerlist = dealerlist;
    }

    public dealerviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflatter=LayoutInflater.from(mtx);

        View view=inflatter.inflate(R.layout.list_layout,null);
        dealerviewholder holder =new dealerviewholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull dealerviewholder holder, int position) {
        Dealerstats dealer=dealerlist.get(position);
        holder.username.setText(dealer.getUsername());
        holder.usertype.setText(dealer.getUsertype());
        holder.phone.setText(dealer.getMobile());
    }

    @Override
    public int getItemCount() {
        return dealerlist.size();
    }

    class dealerviewholder extends RecyclerView.ViewHolder {

        TextView username,usertype,phone;
        public dealerviewholder(@NonNull View itemView) {
            super(itemView);
            username=itemView.findViewById(R.id.username);
            usertype=itemView.findViewById(R.id.usertype);
            phone=itemView.findViewById(R.id.mobile);

        }
    }

}

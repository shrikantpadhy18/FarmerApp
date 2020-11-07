package com.example.farmerportal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class consultantadapter extends RecyclerView.Adapter<consultantadapter.consultantviewholder>{

    private List<Consultantstats>consultantstatslist;
    private Context mtx;



    public consultantviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflatter=LayoutInflater.from(mtx);

        View view=inflatter.inflate(R.layout.list_layout,null);

        consultantviewholder holder=new consultantviewholder(view);
        return holder;
    }

    public consultantadapter(List<Consultantstats> consultantstatslist, Context mtx) {
        this.consultantstatslist = consultantstatslist;
        this.mtx = mtx;
    }

    @Override
    public void onBindViewHolder(@NonNull consultantviewholder holder, int position) {
        Consultantstats consultant=consultantstatslist.get(position);
        holder.username.setText(consultant.getUsername());
        holder.usertype.setText(consultant.getUsertype());
        holder.phone.setText(consultant.getMobile());
    }

    @Override
    public int getItemCount() {
        return consultantstatslist.size();
    }

    class consultantviewholder extends RecyclerView.ViewHolder{
        TextView username,usertype,phone;
        public consultantviewholder(@NonNull View itemView) {
            super(itemView);

            username=itemView.findViewById(R.id.username);
            usertype=itemView.findViewById(R.id.usertype);
            phone=itemView.findViewById(R.id.mobile);

        }
    }

}

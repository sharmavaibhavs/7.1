package com.example.sit305_7_1p;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemRecycler extends RecyclerView.Adapter<ItemRecycler.AlertsViewHolder> {

    Context context;
    ArrayList<DataModel> list;
    ItemClickListener ClickListener;

    //constructor for the adapter
    public ItemRecycler(@NonNull Context context, ArrayList<DataModel> alertsList, ItemClickListener ClickListener) {
        this.context = context;
        list = alertsList;
        this.ClickListener = ClickListener;
    }

    @NonNull
    @Override
    public AlertsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View ItemView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new AlertsViewHolder(ItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AlertsViewHolder holder, int position) {
        holder.LabelAlertListing.setText(list.get(position).getLostOrFound()+" "+list.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickListener.onItemClick(list.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class AlertsViewHolder extends RecyclerView.ViewHolder {
        TextView LabelAlertListing;
        public AlertsViewHolder(@NonNull View itemView) {
            super(itemView);
            LabelAlertListing =itemView.findViewById(R.id.LabelAlertListing);
        }
    }

    public interface ItemClickListener{
        public void onItemClick(DataModel alert);
    }
}

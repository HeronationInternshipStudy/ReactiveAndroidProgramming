package com.example.reactiveandroidprogramming;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class StockDataAdapter extends RecyclerView.Adapter<StockUpdateViewHolder> {
    private final List<String> data=new ArrayList<>();

    @NonNull
    @Override
    public StockUpdateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.stock_update_item,parent,false);
        StockUpdateViewHolder vh=new StockUpdateViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull StockUpdateViewHolder holder, int position) {
        holder.stockSymbol.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void add(String stockSymbol){
        this.data.add(stockSymbol);
        notifyItemInserted(data.size()-1);
    }

}
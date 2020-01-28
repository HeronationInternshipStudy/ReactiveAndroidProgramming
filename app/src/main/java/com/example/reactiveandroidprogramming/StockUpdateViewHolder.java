package com.example.reactiveandroidprogramming;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StockUpdateViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.stock_item_symbol)
    TextView stockSymbol;

    public StockUpdateViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}

package com.example.reactiveandroidprogramming;

import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StockUpdateViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.stock_item_symbol)
    TextView stockSymbol;

    @BindView(R.id.stock_item_price)
    TextView stockPrice;

    @BindView(R.id.stock_item_date)
    TextView stockDate;

    private static final NumberFormat PRICE_FORMAT=new DecimalFormat("#0.00");

    public StockUpdateViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol.setText(stockSymbol);
    }

    public void setStockPrice(Double stockPrice) {
        this.stockPrice.setText(PRICE_FORMAT.format(stockPrice.floatValue()));
    }

    public void setStockDate(Date stockDate) {
        this.stockDate.setText(DateFormat.format("yyyy-MM-dd hh:mm",stockDate));
    }
}

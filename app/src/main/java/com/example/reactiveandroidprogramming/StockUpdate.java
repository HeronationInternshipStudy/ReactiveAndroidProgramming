package com.example.reactiveandroidprogramming;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class StockUpdate implements Serializable {
    private final String stockSymbol;
    private final Double price;
    private final Date date;

    public StockUpdate(String stockSymbol, Double price, Date date) {
        this.stockSymbol = stockSymbol;
        this.price = price;
        this.date = date;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public Double getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }
}

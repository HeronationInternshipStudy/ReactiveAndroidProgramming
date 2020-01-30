package com.example.reactiveandroidprogramming;

import com.google.gson.annotations.SerializedName;

public class YahooStockQuote {
    private String symbol;

    @SerializedName("Name")
    private String name;

    @SerializedName("LastTradePriceOnly")
    private Double lastTradePriceOnly;

    @SerializedName("DaysLow")
    private Double daysLow;

    @SerializedName("DaysHigh")
    private Double daysHigh;

    @SerializedName("Volume")
    private Double volume;


}

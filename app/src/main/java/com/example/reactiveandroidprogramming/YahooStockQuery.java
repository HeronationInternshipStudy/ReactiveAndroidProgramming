package com.example.reactiveandroidprogramming;

import java.util.Date;

public class YahooStockQuery {
    private int count;
    private Date created;
    private YahooStockQuery results;

    public YahooStockQuery(int count, Date created, YahooStockQuery results) {
        this.count = count;
        this.created = created;
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public Date getCreated() {
        return created;
    }

    public YahooStockQuery getResults() {
        return results;
    }
}

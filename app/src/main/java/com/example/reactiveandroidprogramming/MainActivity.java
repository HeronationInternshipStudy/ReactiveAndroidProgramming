package com.example.reactiveandroidprogramming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {
    private LinearLayoutManager layoutManager;
    private StockDataAdapter stockDataAdapter;

    @BindView(R.id.stock_updates_recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        stockDataAdapter=new StockDataAdapter();
        recyclerView.setAdapter(stockDataAdapter);

        Observable.just(
                new StockUpdate("GOOGLE",12.43,new Date()),
                new StockUpdate("APPL",645.1 ,new Date()),
                new StockUpdate("TWTR",1.43, new Date())
        )
                .subscribe(stockDataAdapter::add);
    }
}

package com.example.reactiveandroidprogramming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.http.GET;
import retrofit2.http.Query;

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

        YahooService yahooService=new RetrofitYahooServiceFactory().create();
        String query="select * from yahoo.finance.quote where symbol in ('YHOO','AAPL','GOOG','MSFT')";
        String env="store://datatables.org/alltableswithkeys";

        Observable.just(
                new StockUpdate("GOOGLE",12.43,new Date()),
                new StockUpdate("APPL",645.1 ,new Date()),
                new StockUpdate("TWTR",1.43, new Date())
        )
                .subscribe(stockDataAdapter::add);

        Observable.just("First item","Second item")
                .subscribeOn(Schedulers.io())
                .doOnNext(e-> Log.d("App","on-next:"+Thread.currentThread().getName()+":"+e))
	            .observeOn(AndroidSchedulers.mainThread())
                .subscribe(e->Log.d("App","subscribe:"+Thread.currentThread().getName()
                +":"+e));
    }

    public interface YahooService {
        @GET("yql?format=json")
        Single<YahooStockResult> yqlQuery(
          @Query("q") String query,
          @Query("env") String env
        );
    }
}

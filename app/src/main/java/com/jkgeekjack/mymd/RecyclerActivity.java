package com.jkgeekjack.mymd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Product>products=new ArrayList<Product>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        initVar();
        initView();
    }

    private void initView() {
        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        //设置并列2行的layoutManager
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

//        设置线性布局的layoutManager
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(linearLayoutManager);

        //设置adapter
        RecyclerAdapter adapter=new RecyclerAdapter(products);
        recyclerView.setAdapter(adapter);
    }

    //新建一些数据
    private void initVar() {
        products.add(new Product(R.drawable.avastar,"hello"));
        products.add(new Product(R.drawable.avastar,"hello"));
        products.add(new Product(R.drawable.logo,"hello"));
        products.add(new Product(R.drawable.avastar,"hello"));
        products.add(new Product(R.drawable.iconfont_source,"hello"));
        products.add(new Product(R.drawable.iconfont_about,"hello"));
        products.add(new Product(R.drawable.iconfont_source,"hello"));
        products.add(new Product(R.drawable.avastar,"hello"));
    }
}

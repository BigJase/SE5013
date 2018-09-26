package com.example.jason.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProductScreen extends AppCompatActivity {

    RecyclerView recyclerView;
    ProductAdapter adapter;
    List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_screen);

        recyclerView = findViewById(R.id.product_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productList = new ArrayList<>();

        productList.add( new Product(
                1,
                "Shovel",
                "A tool used for digging",
                4.0,
                999,
                R.drawable.shovel));

        productList.add( new Product(
                1,
                "Shovel",
                "A tool used for digging",
                4.0,
                999,
                R.drawable.shovel));

        productList.add( new Product(
                1,
                "Shovel",
                "A tool used for digging",
                4.0,
                999,
                R.drawable.shovel));

        productList.add( new Product(
                1,
                "Shovel",
                "A tool used for digging",
                4.0,
                999,
                R.drawable.shovel));

        productList.add( new Product(
                1,
                "Shovel",
                "A tool used for digging",
                4.0,
                999,
                R.drawable.shovel));

        productList.add( new Product(
                1,
                "Shovel",
                "A tool used for digging",
                4.0,
                999,
                R.drawable.shovel));

        productList.add( new Product(
                1,
                "Shovel",
                "A tool used for digging",
                4.0,
                999,
                R.drawable.shovel));

        productList.add( new Product(
                1,
                "Shovel",
                "A tool used for digging",
                4.0,
                999,
                R.drawable.shovel));

        productList.add( new Product(
                1,
                "Shovel",
                "A tool used for digging",
                4.0,
                999,
                R.drawable.shovel));

        productList.add( new Product(
                1,
                "Shovel",
                "A tool used for digging",
                4.0,
                999,
                R.drawable.shovel));

        productList.add( new Product(
                1,
                "Shovel",
                "A tool used for digging",
                4.0,
                999,
                R.drawable.shovel));

        productList.add( new Product(
                1,
                "Shovel",
                "A tool used for digging",
                4.0,
                999,
                R.drawable.shovel));

        adapter = new ProductAdapter(this, productList);
        recyclerView.setAdapter(adapter);
    }


}

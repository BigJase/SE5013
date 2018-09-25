package com.example.jason.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProductAdapter adapter;

    List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productList = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        productList = new ArrayList<>();


        //adding some items to our list
        productList.add(
                new Product(
                        1,
                        "Pōhutukawa - Metrosideros excelsa",
                        "a coastal evergreen tree in the myrtle family, Myrtaceae, " +
                                "that produces a brilliant display of red " +
                                "(or occasionally orange, yellow or white flowers made up of a mass of stamens. " +
                                "Renowned for its vibrant colour and its ability to survive even perched on rocky, precarious cliffs.",
                        4.3,
                        475,
                        R.drawable.pohutukawa));

        productList.add(
                new Product(
                        1,
                        "Kōwhai",
                        "small woody legume trees within the genus Sophora that are native to New Zealand. Their natural habitat is beside streams and on the edges of forest, in lowland or mountain open areas. Kōwhai tend to be restricted to mild temperate maritime climates.\n" +
                                "The blooms of the kōwhai are widely regarded as being New Zealand's national flower.",
                        4.3,
                        350,
                        R.drawable.kowhai));

        productList.add(
                new Product(
                        1,
                        "Lemon Tree",
                        "citrus limon, is a species of small evergreen tree in the flowering plant family Rutaceae, native to South Asia, primarily North eastern India." +
                                 "The tree's ellipsoidal yellow fruit is used for culinary and non-culinary purposes throughout the world, primarily for its juice",
                        4.3,
                        120,
                        R.drawable.lemontree));

        adapter = new ProductAdapter(this, productList);
        recyclerView.setAdapter(adapter);

    }
}

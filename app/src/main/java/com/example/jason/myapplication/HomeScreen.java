package com.example.jason.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {

    Button bLogout;



    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        final Button tree_button = findViewById(R.id.trees_button);
        final Button products_button = findViewById(R.id.products_button);
        final Button cart_button = findViewById(R.id.cart_button);
        bLogout = (Button) findViewById(R.id.bLogout);


        tree_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(HomeScreen.this, TreesList.class);
                startActivity(intent);
            }
        });

        products_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(HomeScreen.this, ProductsList.class);
                startActivity(intent);
            }

        });

        bLogout.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(HomeScreen.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        cart_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(HomeScreen.this, CartScreen.class);
                startActivity(intent);
            }
        });

        System.out.println("Home screen oncreate done");
    }



}

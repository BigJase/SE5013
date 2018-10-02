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
        bLogout = (Button) findViewById(R.id.bLogout);


        tree_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(HomeScreen.this, viewList.class);
                startActivity(intent);
            }
        });

        products_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(HomeScreen.this, ProductScreen.class);
                startActivity(intent);
            }

        });

        bLogout.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(HomeScreen.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }



}

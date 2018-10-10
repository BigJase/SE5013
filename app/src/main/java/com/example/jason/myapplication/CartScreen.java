package com.example.jason.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

public class CartScreen extends AppCompatActivity {

    CartList cart = new CartList();
    List<Object> cartList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        final Button checkout_button = findViewById(R.id.checkout_button);

        final Button checkout = findViewById(R.id.checkout_button);

        checkout.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(CartScreen.this, CheckOut.class);
                startActivity(intent);
            }
        });

        cartList = cart.getCart();
    }
    /**
    private void populateCartListView() {
        ArrayAdapter<CartItem> adapter = new MyListAdapter();
        ListView list = findViewById(R.id.treesListView);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<CartList>{
        public MyListAdapter() {
            super(CartScreen.this, 0, cartList);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            // make sure we have a view to work with
            View itemView = convertView;
            if(itemView == null){
                itemView = getLayoutInflater().inflate(R.layout.activity_cart, parent, false);
            }

            //Find tree
            CartList currentItem = cartList.get(position);

            //Picture of tree:
            ImageView imageview = itemView.findViewById(R.id.itemPic1);
            imageview.setImageResource(currentTree.getTreePicture());

            // Description of tree:
            TextView description = itemView.findViewById(R.id.itemDescription1);
            description.setText(currentTree.getDescription());

            // Name of tree:
            TextView name = itemView.findViewById(R.id.itemName1);
            name.setText(currentTree.getTreeName());

            // Price of tree:
            TextView price = itemView.findViewById(R.id.itemPrice1);
            price.setText("$" + currentTree.getPrice());

            return itemView;
        }
    }
**/

    /**
    CartList cart = new CartList();
    List<Object> cartList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        final Button checkout_button = findViewById(R.id.checkout_button);

        final Button checkout = findViewById(R.id.checkout_button);

        checkout.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(CartScreen.this, CheckOut.class);
                startActivity(intent);
            }
        });
        cartList = cart.getCart();
    }

    private class MyListAdapter3 extends ArrayAdapter<Products> {
        public MyListAdapter3() {
            super(CartScreen.this, R.layout.activity_cart);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // make sure we have a view to work with
            View itemView = convertView;
            if(itemView == null) {
                itemView = getLayoutInflater().inflate(R.layout.activity_cart, parent, false);
            }

            return itemView;
        }
    } **/
}

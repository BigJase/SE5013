package com.example.jason.myapplication;

import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class CartList {

    private List<CartItem> cartItem = new ArrayList<>();

    private double price;
    private String name;

    public CartList(){

    }

    public List getCart(){
        return this.cartItem;
    }

    public void setCart(List cart){
        this.cartItem = cart;
    }
    public String getItemName(){
        return this.name;
    }

    public double getItemPrice(){
        return this.price;
    }
}

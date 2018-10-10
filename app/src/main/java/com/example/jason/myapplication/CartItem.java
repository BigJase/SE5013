package com.example.jason.myapplication;

public class CartItem {
    private String itemName;
    private double itemPrice;

    public CartItem(String itemName, double itemPrice){
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public String getItemName(){
        return this.itemName;
    }

    public double getItemPrice(){
        return this.itemPrice;
    }


}

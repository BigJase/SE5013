package com.example.jason.myapplication;

public class CartItem {

    private String itemName;
    private double itemPrice;

    public CartItem(){

    }
    public CartItem(String itemName, double itemPrice){
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public String getItemName(){
        System.out.println("getItemName/CartItem");return this.itemName;
    }

    public double getItemPrice(){
        System.out.println("getItemPrice/CartItem");return this.itemPrice;
    }

    public void setItemName(String name){
        this.itemName = name;
    }

    public void setItemPrice(double price){
        this.itemPrice = price;
    }


}

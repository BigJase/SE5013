package com.example.jason.myapplication;

public class Products {
    private String productName;
    private String description;
    private double rating;
    private double price;
    private int productPicture;

    public Products(String productName, String description, double rating, double price, int productPicture){
        super();
        this.productName = productName;
        this.description = description;
        this.rating = rating;
        this.price = price;
        this.productPicture = productPicture;
    }
    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public double getRating(){
        return rating;
    }

    public double getPrice() {
        return price;
    }

    public int getProductPicture() {
        return productPicture;
    }
}



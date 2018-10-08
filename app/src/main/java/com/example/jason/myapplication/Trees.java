package com.example.jason.myapplication;

public class Trees {
    private String treeName;
    private String description;
    private int height;
    private double price;
    private int treePicture;

    public Trees(String treeName, String description, int height, double price, int treePicture){
        super();
        this.treeName = treeName;
        this.description = description;
        this.height = height;
        this.price = price;
        this.treePicture = treePicture;
    }
    public String getTreeName() {
        return treeName;
    }

    public String getDescription() {
        return description;
    }

    public int getHeight() {
        return height;
    }

    public double getPrice() {
        return price;
    }

    public int getTreePicture(){
        return treePicture;
    }

}



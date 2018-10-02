package com.example.jason.myapplication;

public class Items {


    //i for items

    private String iName;
    private double iPrice;
    private int iType; //0 = Tree 1 = tool

    //??or iID: combined with tID 0654= tree 1234=Equipment

    private String iDes;

   public Items() {
       this(null, 0.0, 0, null);
   }

    public Items(String iName, double iPrice, int iType, String iDes) {

        this.iName = iName;
        this.iPrice = iPrice;
        this.iType = iType;
        this.iDes = iDes;
    }


    public String getiName(){
        return iName;
    }

    public double getiPrice(){
        return iPrice;
    }

    public int getiType(){
        return iType;
    }

    public String getiDes(){
        return iDes;
    }

    //check if item TYPE
    public int isTree(){

       while (iType > 9)
       {
            iType = iType / 10;
       }

       return iType;
    }












}

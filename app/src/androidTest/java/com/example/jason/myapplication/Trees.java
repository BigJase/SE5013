package com.example.jason.myapplication;

public class Trees extends Items{

    //t = Tree

    private String tType;
    private int thigh;
    private int tSpread;
    private int tGrowth;// time to full growth
    private String tDes;//need Tree Desc?
    private String tCare;

    public Trees(){
        this(null, 0.0, 0, null, null, 0, 0, 0, null, null );
    }

    public Trees (String iName, double iPrice, int iType, String iDes,
                   String tType, int thigh, int tSpread, int tGrowth, String tDes, String tCare){
        super(iName, iPrice, iType, iDes);

        this.tType = tType;
        this.thigh = thigh;
        this.tSpread = tSpread;
        this.tGrowth = tGrowth;
        this.tDes = tDes;
        this.tCare = tCare;
    }

    public String gettType(){
        return tType;
    }

    public int gettThigh(){
        return  thigh;
    }

    public int gettSpread(){
        return tSpread;
    }

    public int gettGrowth(){
        return tGrowth;
    }

    public String gettDes(){
        return tDes;
    }

    public String gettCare(){
        return tCare;
    }





}

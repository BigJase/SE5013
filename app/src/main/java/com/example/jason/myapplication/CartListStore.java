package com.example.jason.myapplication;

import java.util.ArrayList;
import java.util.List;

public class CartListStore {
    private List<CartItem> cartStore = new ArrayList<>();

    public CartListStore(){

    }

    public void storeArray(List array){
        this.cartStore = array;
    }

    public List getStoreArray(){
        return cartStore;
    }


}

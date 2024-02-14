package com.common;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private  List<Product> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    /*목차 1. 담기*/
    public void addItem(Product item){
        items.add(item);
    }
    /*목차 2. 꺼내기*/
    public List<Product> getItems(){
        return items;
    }
}

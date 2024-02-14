package com.common;

import java.util.Date;

public class Bread extends Product{

    private Date bakedDate; //생산 시간

    public Bread(String name,int price,  Date bakedDate) {
        super(price, name);
        this.bakedDate = bakedDate;
    }

    @Override
    public String toString() {
        return "Bread{" +
                "bakedDate=" + bakedDate +
                "} " + super.toString();
    }
}

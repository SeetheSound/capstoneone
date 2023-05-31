package com.techelevator;

import java.math.BigDecimal;


public class Candy extends Item{

    public Candy(){

    }
    public Candy(String snackLocation, String snackName, double snackPrice){
        super(snackLocation, snackName, snackPrice);
    }

    @Override
    public String getStatement() {
        return "Munch Munch, Yum!";
    }

}

package com.techelevator;

public class Drink extends Item{

    public Drink(){

    }
    public Drink(String snackLocation, String snackName, double snackPrice, String snackType){
        super(snackLocation, snackName, snackPrice);
    }


    @Override
    public String getStatement() {
        return "Glug Glug, Yum!";
    }
}

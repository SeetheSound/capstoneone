package com.techelevator;

public class Chips extends Item {



    public Chips(String snackLocation,String snackName, double snackPrice, String snackType){
        super(snackLocation, snackName, snackPrice);
    }

    public Chips() {
        super();

    }


    @Override
    public String getStatement() {
        return "Crunch Crunch, Yum";
    }
}

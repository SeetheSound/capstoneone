package com.techelevator;

import java.math.BigDecimal;

public abstract class Item {


    private String snackName;
    private double snackPrice;
    private String snackLocation;
    private String snackType;
    private boolean isDisburssed;
    private String statement;




    public Item(){

    }

    public Item(String location, String name, double price) {
        this.snackName = name;
        this.snackPrice = price;
        this.snackLocation = location;
    }



    /*public Item() {
    }*/

    public String getSnackName() {
        return snackName;

    }

    public double getSnackPrice() {
        return snackPrice;
    }


    public String getSnackLocation() {
        return snackLocation;
    }


    public String getSnackType() {
        return snackType;
    }


    public void setSnackName(String snackName) {
        this.snackName = snackName;
    }

    public void setSnackPrice(double snackPrice) {
        this.snackPrice = snackPrice;
    }

    public void setSnackLocation(String snackLocation) {
        this.snackLocation = snackLocation;
    }

    public void setSnackType(String snackType) {
        this.snackType = snackType;
    }

    //Creating the ItemDisbursementQuoteString

    public void disbursed(boolean isDisburssed){
        this.isDisburssed = isDisburssed;


    }


    public abstract String getStatement();
}



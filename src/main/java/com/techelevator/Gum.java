package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Item{

    public Gum(){

    }
    public Gum(String snackLocation, String snackName, double snackPrice, String snackType) {
        super(snackLocation, snackName, snackPrice);
    }

    @Override
    public String getStatement() {
        return "Chew Chew, Yum!";
    }
}

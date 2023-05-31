package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


public class VendingMachine {

    private Integer dollar;
    private double currentBalance;
    private int quarter;
    private int dime;
    private int nickel;
    private int penny;



    Map<Item, Integer> productsAndQuantity = new HashMap<>();//needs to be at top of vending machine class

    Chips chip = new Chips();
    Gum gum = new Gum();
    Drink drink = new Drink();
    Candy candy = new Candy();

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM,dd,yyyy HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();

    public static void main(String[] args){
        ///created text file
        try{
            File path = new File( "Log.txt");

           // File newFile = new File(path);
            if(path.createNewFile()){
                System.out.println("File created; " + path.getName() );
            } else{
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    String fileName = "Log.txt";




    public void loadFromFile()  {
        String file = "vendingmachine.csv";
       //Scanner scanner = new Scanner(new File(file));


        File input = new File(file);
        try (Scanner dataInput = new Scanner(input)) {
            while (dataInput.hasNextLine()) {
                Item item = new Item() {
                    @Override
                    public String getStatement() {
                        return null;
                    }
                };
                String lineOfInput = dataInput.nextLine();

                String[] parts = lineOfInput.split("\\|");

                String snackLocation = parts[0];
                String snackPrice = parts[2];
                String snackName = parts[1];
                String snackType = parts[3];

                item.setSnackLocation(snackLocation);
                item.setSnackName(snackName);
                double price = Double.parseDouble(parts[2]);
                item.setSnackPrice(price);
                item.setSnackType(snackType);

                productsAndQuantity.put(item, 5);


            }
        }         catch (FileNotFoundException e){

        }
    }

    public void displayFromFile()  {
        System.out.println("Slot | Product | Price | Type | Quantity");
        for(Map.Entry<Item, Integer> entry : productsAndQuantity.entrySet()){
            System.out.println(entry.getKey().getSnackLocation() + " | " + entry.getKey().getSnackName() + " | " + entry.getKey().getSnackPrice() + " | " + entry.getKey().getSnackType() + " | " + entry.getValue());
        }
    }


    //
    public boolean selectProduct(String productSelected) {

        boolean slot = false;

        for (Map.Entry<Item, Integer> entry : productsAndQuantity.entrySet()) {
            if (entry.getKey().getSnackLocation().equals(productSelected)) {
                slot = true;
                String message = "Test";//(dtf)  +  (now + entry.getKey().getSnackName() + entry.getKey().getSnackPrice());

                //

                try (PrintWriter write = new PrintWriter(newFile)){
                    write.println(message);

                }catch (FileNotFoundException e){
                    System.out.println("error");
                }
            }
        }
        if (!slot) {
            System.out.println("Not valid Selection ");
        }


        return slot;
    }

//creating method for quantity and product left
    public void quantityAmount(String snackLocation) {
        String productName = "";
        for (Map.Entry<Item, Integer> entry : productsAndQuantity.entrySet()) {
            if (entry.getKey().getSnackLocation().equals(snackLocation) && entry.getValue() == 0) {
                System.out.println("Sorry " + entry.getKey().getSnackName() + "Item is sold out.");
            } else if (entry.getKey().getSnackLocation().equals(snackLocation)) {
                currentBalance = currentBalance - entry.getKey().getSnackPrice();
                int currentQuantity = entry.getValue();
                entry.setValue(currentQuantity - 1);
                productName = entry.getKey().getSnackName();
            } //else if(entry.getKey().getSnackType())
        }
        System.out.println("Here is your " + productName + ". Your remaining balance is " + currentBalance);
    }




    public double feedMoney(double money){
        currentBalance =+ money;

        String message = "Feed Money: " + "$";

        // trying something

        try (PrintWriter write = new PrintWriter(newFile)){
            write.println(message);

        }catch (FileNotFoundException e){
            System.out.println("error");
        }
        return currentBalance;
    }

    public void getBalance(){
        System.out.println("Your change is " + currentBalance);
    }
    public void getChange(){

        double change = currentBalance;
        while(currentBalance >= .25){
            currentBalance -= .25;
            quarter++;
        }
        while(currentBalance >= .10){
            currentBalance -= .10;
            dime++;
        }
        while(currentBalance >= 0.05){
            currentBalance -= 0.05;
            nickel++;
        }
        while(currentBalance >= 0){
            currentBalance -= penny;
            penny++;
        }

    }


    //public void logTransaction() {










}

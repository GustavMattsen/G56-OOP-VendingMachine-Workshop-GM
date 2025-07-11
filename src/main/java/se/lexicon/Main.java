package se.lexicon;

import model.*;

public class Main {
    public static void main(String[] args) {

        //Create product instances
        Candy candy = new Candy(1, 12.99, "Mint Candy", true);
        Soda soda = new Soda(2, 15.50, "Cola", true);
        Chips chips = new Chips(3, 18.75, "BBQ Chips", "Barbecue");

        //Add them to an array
        Product[] products = { candy, soda, chips };

        //Create a vending machine
        VendingMachineImpl vm = new VendingMachineImpl(products);

        //Display all products
        System.out.println("Available Products:");
        for (String info : vm.getProducts()) {
            System.out.println(info);
        }

        System.out.println("\n---Testing vending machine---");

        //Add valid currency
        vm.addCurrency(20);
        System.out.println("Balance after deposit: " + vm.getBalance() + " SEK");

        //Attempt to purchase a product
        Product boughtProduct = vm.request(1); //ID 1 = Mint Candy
        if (boughtProduct != null) {
            System.out.println("You have purchased: " + boughtProduct.getProductName());
            System.out.println("Usage: " + boughtProduct.use());
        }

        //Get a description of a product
        System.out.println("\nDescription of product with ID 2:");
        System.out.println(vm.getDescription(2)); //Should describe Cola

        //Try requesting an invalid product
        System.out.println("\nTrying to request a product with invalid ID 99:");
        vm.request(99);

        //End session
        int change = vm.endSession();
        System.out.println("Change returned: " + change + " SEK");
        System.out.println("Balance after session: " + vm.getBalance() + " SEK");
    }
}


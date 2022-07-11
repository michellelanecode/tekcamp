package com.teksystems.bootcamp.facade;

import java.util.ArrayList;
import java.util.Scanner;

public class CashRegister {
    Scanner customerInfo = new Scanner(System.in);
    BillingSystem billing;
    PaymentSystem payments;
    ShippingSystem shipping;
    ArrayList<String> cartItems = new ArrayList<>();
    double cartTotal = 0;
    public CashRegister(BillingSystem billing, PaymentSystem payments, ShippingSystem shipping) {
        this.billing = billing;
        this.payments = payments;
        this.shipping = shipping;
    }
    public boolean verifyInventory(String purchase){
        boolean found = false;
        for(Inventory item: Inventory.values()) {
            if (item.name().equalsIgnoreCase(purchase)) {
                found = true;
                break;
            }
        }
        return found;
    }
    public void checkOut(){
          System.out.println("Enter address:");
          shipping.setAddress(customerInfo.nextLine());
          System.out.println("Enter 7 digit account number:");
          payments.setAccount(customerInfo.nextInt());
          System.out.println("Generating bill.......");
          payments.makePayment();
          billing.generateBill(cartItems, cartTotal);
    }

    public String shop(String item){
       if (verifyInventory(item)){
           addToCart(item);
           return "Added " + item + " to cart \n Current total:" + cartTotal;
       } else {
           return "Attempted to purchase " + item + " \n Item not available";
       }
    }

    public void addToCart(String item){
        cartItems.add(item);
        cartTotal += Inventory.valueOf(item.toUpperCase()).cost;
    }
}

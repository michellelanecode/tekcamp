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
          System.out.println("Enter address");
          shipping.setAddress(customerInfo.nextLine());
          System.out.println("Enter paymentInfo");
          payments.setAccount(customerInfo.nextInt());
          System.out.println("Generating bill.......");
          payments.makePayment();
          billing.generateBill(cartItems, cartTotal);
    }

    public void shop(String item){
       if (verifyInventory(item)){
           addToCart(item);
           System.out.println("Added " + item + " to cart");
           System.out.println("Current total: " + cartTotal);
       } else {
           System.out.println("Attempted to purchase " + item);
           System.out.println("Item not available");
       }
    }

    public void addToCart(String item){
        cartItems.add(item);
        cartTotal += Inventory.valueOf(item.toUpperCase()).cost;
    }
}

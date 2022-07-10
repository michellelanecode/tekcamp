package com.teksystems.bootcamp.facade;

import java.util.ArrayList;

public class BillingSystem {
    PaymentSystem payment;
    ShippingSystem shipping;

    int orderNumber;

    public BillingSystem(PaymentSystem payment, ShippingSystem shipping) {
        this.payment = payment;
        this.shipping = shipping;
    }
    public void generateBill(ArrayList cartItems, double cartTotal){
        System.out.println("_____________________");
        System.out.println("Purchased: ");
        cartItems.forEach(item -> System.out.println(Inventory.valueOf(item.toString().toUpperCase()) + " " +
                Inventory.valueOf(item.toString().toUpperCase()).cost
                ));
        System.out.println("_____________________");
        System.out.println("Mail To: " + shipping.address);
        System.out.println("Account number: " + payment.accountNumber);
        System.out.println("_____________________");
        System.out.println("Total: " + cartTotal);
        System.out.println("_____________________");
        System.out.println("Order status: " + payment.paymentStatus);
        System.out.println("_____________________");
        System.out.println("Payment Completion Status");
        if (payment.paymentStatus.equals("failed")){
            System.out.println("Account number invalid. Enter 7 digits only");
        } else {
            generateOrderNumber();
            System.out.println("Order " + orderNumber +  " successfully created");
        }
    }

    public void generateOrderNumber(){
       orderNumber = (int) Math.floor(Math.random()*(1000+1)+1000);
    }
}

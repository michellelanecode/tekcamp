package com.teksystems.bootcamp;

import com.teksystems.bootcamp.facade.BillingSystem;
import com.teksystems.bootcamp.facade.CashRegister;
import com.teksystems.bootcamp.facade.PaymentSystem;
import com.teksystems.bootcamp.facade.ShippingSystem;

public class Main {

    public static void main(String[] args) {

        // prints out naughty and nice list gifts
//        SantasFactory santa = new SantasFactory();
//        Gift gift;
//        for(NaughtyNiceList name: NaughtyNiceList.values()){
//            gift = santa.makeGift(name.status);
//            System.out.println("Name: " + name );
//            System.out.println("Status: " + name.status.toLowerCase());
//            System.out.println("Gift: " + gift.getGift());
//            System.out.println("__________");
//        }


//        / facade tests
        PaymentSystem payment = new PaymentSystem();
        ShippingSystem shipping = new ShippingSystem();
        BillingSystem billing = new BillingSystem(payment, shipping);


        CashRegister store = new CashRegister(billing, payment, shipping);

        store.shop("cheese");
        store.shop("butter");

    }
}

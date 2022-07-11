package com.teksystems.bootcamp;

import com.teksystems.bootcamp.facade.BillingSystem;
import com.teksystems.bootcamp.facade.CashRegister;
import com.teksystems.bootcamp.facade.PaymentSystem;
import com.teksystems.bootcamp.facade.ShippingSystem;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FacadeTests {

    PaymentSystem payment = new PaymentSystem();
    ShippingSystem shipping = new ShippingSystem();
    BillingSystem billing = new BillingSystem(payment, shipping);

    CashRegister store = new CashRegister(billing, payment, shipping);



    @Test
    public void returnItemNotFound(){
        assertEquals(store.addToCart("cheese"), "Item not found");
    }


}
package com.teksystems.bootcamp.facade;

public class PaymentSystem {
    String paymentStatus;
    int accountNumber;


    public void setAccount(int cardNumber) {
        this.accountNumber = cardNumber;
    }

    public void makePayment() {
        if (String.valueOf(accountNumber).length() == 7 ) {
            paymentStatus = "complete";
        } else {
            paymentStatus = "failed";
        }
    }
}

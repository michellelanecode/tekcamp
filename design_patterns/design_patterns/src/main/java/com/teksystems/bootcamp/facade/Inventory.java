package com.teksystems.bootcamp.facade;

public enum Inventory {
    TOAST(3.25),
    BUTTER(5.65),
    SPRINGWATER(1.50),
    SHIRT(8.00),
    SHOES(15.00),
    CANDLE(5.00),
    COMPUTER(300.00),
    BOOK(24.50);

    public final double cost;
    Inventory(double cost) {
        this.cost = cost;
    }

}

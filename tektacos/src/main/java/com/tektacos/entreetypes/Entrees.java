package com.tektacos.entreetypes;

public enum Entrees {
    BASIC(5.00),
    DELUXE(8.00),
    VEGGIE(4.50),
    CYA(5.00),
    NOENTREE(0.00);

    public final double cost;

    Entrees(double cost) {
        this.cost = cost;
    }

}
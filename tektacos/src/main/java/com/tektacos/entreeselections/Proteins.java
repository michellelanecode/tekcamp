package com.tektacos.entreeselections;

public enum Proteins {
    BEEF(5.00),
    STEAK(7.00),
    BLACKBEANS(3.00),
    CHICKEN(5.00),
    SHREDDEDPORK(8.00),

    NOPROTEIN(0.00);

    public final double cost;

    Proteins(double cost){
        this.cost = cost;
    }

}

package com.teksystems.bootcamp.factories;

public class Toy implements Gift {
    @Override
    public void getGift() {
        System.out.println("gift of toy");
    }

}

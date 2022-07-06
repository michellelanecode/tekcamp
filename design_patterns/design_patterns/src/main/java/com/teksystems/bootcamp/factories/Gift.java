package com.teksystems.bootcamp.factories;

public abstract class Gift {
    SantasFactory factory = new SantasFactory();
    public abstract String giftWrap(String name);

}

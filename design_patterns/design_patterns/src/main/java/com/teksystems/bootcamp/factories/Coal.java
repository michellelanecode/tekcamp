package com.teksystems.bootcamp.factories;

public class Coal extends Gift{
    @Override
    public String giftWrap(String name) {
        return "Name: " + name + " Gift: " + factory.checkList(name);
    }
}

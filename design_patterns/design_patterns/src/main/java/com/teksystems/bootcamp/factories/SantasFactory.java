package com.teksystems.bootcamp.factories;

public class SantasFactory {

    public Gift makeGift (String status){

        if (status.equalsIgnoreCase("Naughty")){
            return new Coal();
        }else if (status.equalsIgnoreCase("Nice")){
            return new Toy();
        }
        return null;
    }
}

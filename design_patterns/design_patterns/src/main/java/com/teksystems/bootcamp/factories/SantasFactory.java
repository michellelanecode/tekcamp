package com.teksystems.bootcamp.factories;

public class SantasFactory {

    public Gift makeGift (String status){

        if (status.equalsIgnoreCase("Nty")){
            return new Coal();
        }else if (status.equalsIgnoreCase("Nce")){
            return new Toy();
        }
        return null;
    }
}

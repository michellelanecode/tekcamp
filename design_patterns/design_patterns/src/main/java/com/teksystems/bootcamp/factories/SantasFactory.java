package com.teksystems.bootcamp.factories;

public class SantasFactory {

    public String checkList(String status){
       switch(status){
           case "nty":
               return new Coal().getGift();
           case "nce":
               return new Toy().getGift();
       }
        return status;
    }
}

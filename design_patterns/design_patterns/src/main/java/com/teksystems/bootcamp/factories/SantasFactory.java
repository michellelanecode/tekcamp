package com.teksystems.bootcamp.factories;

public class SantasFactory {

    public String checkList(String name){
        if (name.matches("[a-rA-R]+")){
            return "Naughty";
        } else {
            return "Nice";
        }
    }
}

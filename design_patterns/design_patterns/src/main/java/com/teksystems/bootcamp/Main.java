package com.teksystems.bootcamp;

import com.teksystems.bootcamp.factories.Gift;
import com.teksystems.bootcamp.factories.NaughtyNiceList;
import com.teksystems.bootcamp.factories.SantasFactory;

public class Main {

    public static void main(String[] args) {
        SantasFactory santa = new SantasFactory();
        Gift gift;
        for(NaughtyNiceList name: NaughtyNiceList.values()){
            gift = santa.makeGift(name.status);
            System.out.println("Name: " + name + " Status: " + name.status.toLowerCase() + " Gift: " + gift.getGift());
        }


    }
}

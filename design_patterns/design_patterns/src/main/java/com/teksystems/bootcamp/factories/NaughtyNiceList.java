package com.teksystems.bootcamp.factories;

public enum NaughtyNiceList {
    PAMELA("Naughty"),
    MONIQUE("nice"),
    ROSEMARIE("Nice"),
    MOMMOM("naughty"),
    TIANNA("nice"),
    POPOP("naughty"),
    ;

    public final String status;

    NaughtyNiceList(String status){
        this.status = status;
    }

}

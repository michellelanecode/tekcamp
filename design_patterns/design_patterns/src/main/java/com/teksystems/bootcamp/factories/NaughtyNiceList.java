package com.teksystems.bootcamp.factories;

public enum NaughtyNiceList {
    PAMELA("NTY"),
    MONIQUE("nty"),
    ROSEMARIE("NCE"),
    MOMMOM("nty"),
    TIANNA("nce"),
    POPOP("nce"),
    ;

    private final String status;

    NaughtyNiceList(String status){
        this.status = status;
    }

}

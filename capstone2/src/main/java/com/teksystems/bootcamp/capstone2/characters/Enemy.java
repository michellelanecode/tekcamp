package com.teksystems.bootcamp.capstone2.characters;

public class Enemy {
    private final String healthType;
    private int healthTypeLevel = 50;

    public Enemy(String healthType) {
        this.healthType = healthType;
    }

    public int getHealthTypeLevel() {
        return healthTypeLevel;
    }

    public void damage(){

    }
}

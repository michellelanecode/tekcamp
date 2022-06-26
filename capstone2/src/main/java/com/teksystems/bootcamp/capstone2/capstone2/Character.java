package com.teksystems.bootcamp.capstone2.capstone2;

public abstract class Character {
    private final String healthType;
    private int healthTypeLevel = 60;
    private final String superPower;
    private final int damagePoints = 15;

   public Character(String healthType, String superPower){
       this.healthType = healthType;
       this.superPower = superPower;
   }

    public String getHealthType() {
        return healthType;
    }

    public int getHealthTypeLevel() {
        return healthTypeLevel;
    }

    public void setHealthTypeLevel(int healthTypeLevel) {
        this.healthTypeLevel = healthTypeLevel;
    }

    public String getSuperPower() {
        return superPower;
    }

    public int getDamagePoints() {
        return damagePoints;
    }
}

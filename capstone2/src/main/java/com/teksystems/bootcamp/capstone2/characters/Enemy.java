package com.teksystems.bootcamp.capstone2.characters;

public class Enemy {
    private final String healthType;
    private int healthTypeLevel = 50;

    private int damagePoints = 10;

    public Enemy(String healthType) {
        this.healthType = healthType;
    }

    public Integer getHealthTypeLevel() {
        return healthTypeLevel;
    }

    public void setHealthTypeLevel(int healthTypeLevel) {
        this.healthTypeLevel = healthTypeLevel;
    }

    public int getDamagePoints() {
        return damagePoints;
    }

    public void faint(){

    }

    public void attack(Magi enemy){
        int enemyHealth = enemy.getHealthTypeLevel();
        int damagePoints = this.getDamagePoints();
        if (enemyHealth <= damagePoints){
            enemy.setHealthTypeLevel(0);
            //trigger game over
        } else {
            //enemy damage function
            enemy.setHealthTypeLevel(enemyHealth - damagePoints);
        }
    }


}

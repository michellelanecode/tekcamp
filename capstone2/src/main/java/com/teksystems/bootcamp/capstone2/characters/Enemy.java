package com.teksystems.bootcamp.capstone2.characters;

import javafx.scene.image.ImageView;

public class Enemy extends Character{
    private int healthTypeLevel = 200;

    private int damagePoints = 10;

    public Enemy(String healthType, ImageView characterSprite) {
        super(healthType, characterSprite);
    }


    public int getHealthTypeLevel() {
        return healthTypeLevel;
    }
    public void setHealthTypeLevel(int healthTypeLevel) {
        this.healthTypeLevel = healthTypeLevel;
    }
    public int getDamagePoints() {
        return damagePoints;
    }

    public void attack(Magi enemy){
        int enemyHealth = enemy.getHealthTypeLevel();
        int damagePoints = this.getDamagePoints();
        if (enemyHealth <= damagePoints){
            enemy.setHealthTypeLevel(enemyHealth - damagePoints);
            enemy.faint();
        } else {
            enemy.setHealthTypeLevel(enemyHealth - damagePoints);
        }
    }
}

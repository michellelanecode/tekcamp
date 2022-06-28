package com.teksystems.bootcamp.capstone2.characters;

import javafx.scene.image.Image;

public class Enemy {
    private final String healthType;
    private int healthTypeLevel = 200;

    private Image enemyImage;
    private int damagePoints = 10;

    public Enemy(String healthType) {
        this.healthType = healthType;
        this.enemyImage = enemyImage;
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


    public void faint(){
        Image newEnemyImage = new Image("file:faintedEnemy.png");

        this.enemyImage = newEnemyImage;
    }

    public Image getEnemyImage(){
        return enemyImage;
    }

}

package com.teksystems.bootcamp.capstone2.characters;

import javafx.animation.Animation;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class Enemy extends Character{
    private int healthTypeLevel = 200;

    private int damagePoints = 40;

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

    public Animation attack(ImageView characterSprite, ImageView enemySprite, Magi enemy, Rectangle enemyHealthBar){
        int enemyHealth = enemy.getHealthTypeLevel();
        int damagePoints = this.getDamagePoints();
            enemy.setHealthTypeLevel(enemyHealth - damagePoints);
            return bossHit(characterSprite, enemySprite,enemyHealthBar, enemy);
    }
}

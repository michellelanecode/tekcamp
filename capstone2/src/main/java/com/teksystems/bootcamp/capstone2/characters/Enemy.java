package com.teksystems.bootcamp.capstone2.characters;

import com.teksystems.bootcamp.capstone2.capstone2.CharacterSelectionController;
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

    public Animation returnAttackAnimation(ImageView characterSprite, ImageView enemySprite, Magi enemy, Rectangle enemyHealthBar){
        int enemyHealth = enemy.getHealthLevel();
        int damagePoints = this.getDamagePoints();
        enemy.setHealthTypeLevel(enemyHealth - damagePoints);
        CharacterSelectionController.player.setEnemyHealth(enemy.getHealthLevel());
        return returnBossHitAnimation(characterSprite, enemySprite, enemyHealthBar);
    }
}

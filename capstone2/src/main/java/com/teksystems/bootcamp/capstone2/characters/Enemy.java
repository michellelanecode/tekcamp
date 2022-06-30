package com.teksystems.bootcamp.capstone2.characters;

import com.teksystems.bootcamp.capstone2.controllers.CharacterSelectionController;
import com.teksystems.bootcamp.capstone2.player.PlayerInformation;
import javafx.animation.Animation;
import javafx.scene.image.ImageView;

public class Enemy extends Character{
    private int healthTypeLevel = 200;
    private int damagePoints = 40;

    private final PlayerInformation player = CharacterSelectionController.playerInformation;

    public int getHealthTypeLevel() {
        return healthTypeLevel;
    }
    public void setHealthTypeLevel(int healthTypeLevel) {
        this.healthTypeLevel = healthTypeLevel;
    }
    public int getDamagePoints() {
        return damagePoints;
    }

    public Animation returnMagiAttackAnimation(ImageView characterSprite, ImageView enemySprite){
        int enemyHealth = player.getPlayerHealth();
        int damagePoints = this.getDamagePoints();
       player.setPlayerHealth(enemyHealth - damagePoints);
        return returnBossHitAnimation(characterSprite, enemySprite);
    }
    public Animation returnJoeAttackAnimation(ImageView characterSprite, ImageView enemySprite){
        int enemyHealth = player.getPlayerHealth();
        int damagePoints = this.getDamagePoints();
        player.setPlayerHealth(enemyHealth - damagePoints);
        return returnBossHitAnimation(characterSprite, enemySprite);
    }


}

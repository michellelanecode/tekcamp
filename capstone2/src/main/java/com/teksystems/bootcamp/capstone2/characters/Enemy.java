package com.teksystems.bootcamp.capstone2.characters;

import com.teksystems.bootcamp.capstone2.player.PlayerInformation;
import javafx.animation.Animation;
import javafx.scene.image.ImageView;

public class Enemy extends Character{

    private int damagePoints = 40;


    public Animation returnMagiAttackAnimation(ImageView characterSprite, ImageView enemySprite){
        PlayerInformation player = getPlayer();
        int enemyHealth = player.getPlayerHealth();
        int damagePoints = this.getDamagePoints();
       player.setPlayerHealth(enemyHealth - damagePoints);
        return returnBossHitAnimation(characterSprite, enemySprite);
    }
    public Animation returnJoeAttackAnimation(ImageView characterSprite, ImageView enemySprite){
        PlayerInformation player = getPlayer();
        int enemyHealth = player.getPlayerHealth();
        int damagePoints = this.getDamagePoints();
        player.setPlayerHealth(enemyHealth - damagePoints);
        return returnBossHitAnimation(characterSprite, enemySprite);
    }


}

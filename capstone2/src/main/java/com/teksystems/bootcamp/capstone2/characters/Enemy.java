package com.teksystems.bootcamp.capstone2.characters;

import com.teksystems.bootcamp.capstone2.audio.GameMusic;
import com.teksystems.bootcamp.capstone2.player.PlayerAnimations;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class Enemy extends Character{
    protected Magi enemyMagi;
    protected AvgJoe enemyJoe;
    protected int damagePoints = 40;

    public void setEnemyMagi(Magi enemyMagi) {
        this.enemyMagi = enemyMagi;
    }

    public void setEnemyJoe(AvgJoe enemyJoe) {
        this.enemyJoe = enemyJoe;
    }

    public void attack(ImageView characterSprite, ImageView enemySprite, Rectangle enemyHealthBar){
        if (!enemyJoe.equals(null)){
            enemyJoe.setHealthLevel(enemyJoe.getHealthLevel() - damagePoints);
        } else if (!enemyMagi.equals(null)){
            enemyMagi.setHealthLevel(enemyMagi.getHealthLevel() - damagePoints);
        }
        new GameMusic().getHitSound().play();
        new PlayerAnimations().userEnemytAttack(characterSprite, enemySprite, enemyHealthBar, damagePoints).play();
    }



}

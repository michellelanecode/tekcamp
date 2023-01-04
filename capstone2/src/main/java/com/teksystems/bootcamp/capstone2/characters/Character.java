package com.teksystems.bootcamp.capstone2.characters;

import com.teksystems.bootcamp.capstone2.audio.GameMusic;
import com.teksystems.bootcamp.capstone2.controllers.ToBeHumaansController;
import com.teksystems.bootcamp.capstone2.player.PlayerAnimations;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public abstract class Character {
    public int healthLevel = 200;
    public final int damagePoints = 50;

    public int getHealthLevel(){
        return healthLevel;
    }

    public int getDamagePoints() {
        return damagePoints;
    }

    public void setHealthLevel(int newlevel){
        healthLevel = newlevel;
    }
    public void faint(Rectangle enemyHealthBar, ImageView fainter, int angle, Enemy enemy){
        enemy.setHealthLevel(0);
        new PlayerAnimations().updateHealthBar(enemyHealthBar, enemy.getHealthLevel());
        ToBeHumaansController.playerController.getNowPlaying().stop();
        ToBeHumaansController.playerController.setNowPlaying(new GameMusic().getFaintMusic());
        ToBeHumaansController.playerController.getNowPlaying().play();
        new PlayerAnimations().userRotate(fainter, angle).play();
    }

    public void attack(ImageView characterSprite, ImageView enemySprite, Rectangle enemyHealthBar, Enemy enemy){
        enemy.setHealthLevel(enemy.getHealthLevel() - damagePoints);
        new PlayerAnimations().userAttack(characterSprite, enemySprite, enemyHealthBar, damagePoints).play();
    }

}

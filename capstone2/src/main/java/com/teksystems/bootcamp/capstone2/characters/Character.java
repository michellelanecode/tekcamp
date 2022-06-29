package com.teksystems.bootcamp.capstone2.characters;

import com.teksystems.bootcamp.capstone2.capstone2.magiFightSceneController;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;

public abstract class Character {
    private final String healthType;
    private int healthTypeLevel = 200;
    private final int damagePoints = 20;
    private ImageView characterSprite;
   public Character(String healthType, ImageView characterSprite){
       this.healthType = healthType;
       this.characterSprite = characterSprite;
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
    public int getDamagePoints() {
        return damagePoints;
    }
    public void faint(){
        magiFightSceneController.getBossBattleMusic().stop();
        AudioClip faintMusic = new AudioClip("https://vgmsite.com/soundtracks/street-fighter-ii-the-world-warrior-arcade/uvpuolxyky/07%20Stage%20End.mp3");
        faintMusic.setVolume(0.05);
        faintMusic.play();
        RotateTransition faintAnimation = new RotateTransition(Duration.millis(100), this.getCharacterSprite());
        faintAnimation.setToAngle(90);
        faintAnimation.setCycleCount(1);
        faintAnimation.play();
    }
    public ImageView getCharacterSprite(){
       return characterSprite;
    }

    public void attack(Enemy enemy){
        int enemyHealth = enemy.getHealthTypeLevel();
        int damagePoints = this.getDamagePoints();
       if (enemyHealth <= damagePoints){
           enemy.setHealthTypeLevel(enemyHealth - damagePoints);
           enemy.faint();
       } else {
           enemy.setHealthTypeLevel(enemyHealth - damagePoints);
       }
    }

    public void animateHit(ImageView target) {
        FadeTransition blink = new FadeTransition(Duration.millis(1000), target);
        blink.setFromValue(0.2);
        blink.setToValue(1.0);
        blink.setCycleCount(3);
        blink.play();
    }
}

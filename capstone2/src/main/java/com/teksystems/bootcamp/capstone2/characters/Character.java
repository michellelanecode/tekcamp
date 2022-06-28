package com.teksystems.bootcamp.capstone2.characters;

import javafx.scene.image.Image;

public abstract class Character {
    private final String healthType;
    private int healthTypeLevel = 200;
    private final int damagePoints = 20;
    private Image character;
   public Character(String healthType){
       this.healthType = healthType;


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

        Image characterImage = new Image("file:faintedMagi.png");
        character = characterImage;
    }

    public Image getCharacter(){
       return character;
    }


}

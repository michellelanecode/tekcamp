package com.teksystems.bootcamp.capstone2.characters;

import javafx.scene.image.ImageView;

public class Magi extends Character {

    public Magi(String healthType, ImageView characterSprite) {
        super(healthType, characterSprite);
    }

    public void eatMushroom(){
       int health = getHealthTypeLevel();
      setHealthTypeLevel(health - 30);
    }
    public void swim(){
        int health = getHealthTypeLevel();
        setHealthTypeLevel(health - 20);
    }
    public void walkAround(){
        int health = getHealthTypeLevel();
        setHealthTypeLevel(health - 10);
    }
}

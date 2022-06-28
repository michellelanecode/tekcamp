package com.teksystems.bootcamp.capstone2.characters;

public class Magi extends Character {
    public Magi (){
        super("magic");
    }

    public void eatMushroom(){
       int health = getHealthTypeLevel();
      setHealthTypeLevel(health - 30);
        System.out.println(health);
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

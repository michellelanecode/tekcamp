package com.teksystems.bootcamp.capstone2.characters;

public class Magi extends Character {
    public Magi (){
        super("magic", "magic");
    }
    public void castSpell(Enemy enemy) {
        enemy.damage();
    }
    public void eatMushroom(){
       int health = getHealthTypeLevel();
       health = health - 15;
        System.out.println(health);
    }

}

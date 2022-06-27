package com.teksystems.bootcamp.capstone2.characters;

public class Magi extends Character {
    public Magi (){
        super("magic", "magic");
    }

    public void castSpell(Enemy enemy) {
        int enemyHealth = enemy.getHealthTypeLevel();
        int damagePoints = this.getDamagePoints();
        if (enemyHealth <= damagePoints){
            enemy.setHealthTypeLevel(0);
           //trigger game over
        } else {
            //enemy damage function
            enemy.setHealthTypeLevel(enemyHealth - damagePoints);
        }
    }

    public void eatMushroom(){
       int health = getHealthTypeLevel();
       health = health - 15;
        System.out.println(health);
    }

}

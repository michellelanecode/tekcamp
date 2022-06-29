package com.teksystems.bootcamp.capstone2.capstone2;

import com.teksystems.bootcamp.capstone2.characters.AvgJoe;
import com.teksystems.bootcamp.capstone2.characters.Enemy;
import com.teksystems.bootcamp.capstone2.characters.Magi;
import com.teksystems.bootcamp.capstone2.characters.Princess;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Player {

    private Magi magi;

    private Princess princess;

    private AvgJoe joe;

    private Enemy enemy;

    private int magiHealth;
    private int princessHealth;
    private int avgJoeHealth;


    private Rectangle playerHealthBar;

    private Rectangle enemyHealthBar;

    private Integer playerHealth;

    private Integer enemyHealth;

    public void setMagi(Magi magi) {
        this.magi = magi;
    }

    public void setPrincess(Princess princess) {
        this.princess = princess;
    }

    public void setJoe(AvgJoe joe) {
        this.joe = joe;
    }
    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }


    public Magi getMagi() {
        return magi;
    }

    public AvgJoe getJoe() {
        return joe;
    }

    public Princess getPrincess() {
        return princess;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
    }

    public void setEnemyHealth(int enemyHealth) {
        this.enemyHealth = enemyHealth;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public void updatePlayerHealth(Rectangle healthBar, int damage) {
        KeyValue widthValue = new KeyValue(healthBar.widthProperty(), healthBar.getWidth() - damage);
        KeyFrame frame = new KeyFrame(Duration.seconds(1.5), widthValue);
        Timeline timeline = new Timeline(frame);
        timeline.play();
        setPlayerHealth(playerHealth - damage);
        setPlayerHealthBar(healthBar);
    }

    public void updateEnemyHealth(Rectangle healthBar, int damage){
        KeyValue widthValue = new KeyValue(healthBar.widthProperty(), healthBar.getWidth() - damage);
        KeyFrame frame = new KeyFrame(Duration.seconds(1.5), widthValue);
        Timeline timeline = new Timeline(frame);
        timeline.play();
        setEnemyHealth(enemyHealth - damage);
        setEnemyHealthBar(healthBar);
    }

    public void setPlayerHealthBar(Rectangle playerHealthBar) {
        playerHealthBar.setWidth(playerHealth);
        this.playerHealthBar = playerHealthBar;
    }

    public void setEnemyHealthBar(Rectangle enemyHealthBar) {
        enemyHealthBar.setWidth(enemyHealth);
        this.enemyHealthBar = enemyHealthBar;
    }

    public Rectangle getPlayerHealthBar() {
        return playerHealthBar;
    }

    public Rectangle getEnemyHealthBar() {
        return enemyHealthBar;
    }

}


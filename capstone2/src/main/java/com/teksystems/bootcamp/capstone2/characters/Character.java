package com.teksystems.bootcamp.capstone2.characters;

import com.teksystems.bootcamp.capstone2.capstone2.CharacterSelectionController;
import com.teksystems.bootcamp.capstone2.capstone2.Player;
import javafx.animation.*;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public abstract class Character {
    private final String healthType;

    private int healthLevel = 200;
    private final int damagePoints = 40;
    private ImageView characterSprite;

    private Player currentPlayer = CharacterSelectionController.player;;
   public Character(String healthType, ImageView characterSprite){
       this.healthType = healthType;
       this.characterSprite = characterSprite;
   }
    public String getHealthType() {
        return healthType;
    }
    public int getHealthLevel() {
        return healthLevel;
    }
    public void setHealthTypeLevel(int healthTypeLevel) {
        this.healthLevel = healthTypeLevel;
    }
    public int getDamagePoints() {
        return damagePoints;
    }
    public Animation returnfaintAnimation(Rectangle enemyHealthBar){
        KeyValue widthValue = new KeyValue(enemyHealthBar.widthProperty(), enemyHealthBar.getWidth() - enemyHealthBar.getWidth());
        KeyFrame frame = new KeyFrame(Duration.seconds(1.5), widthValue);
        Timeline timeline = new Timeline(frame);
        RotateTransition faintAnimation = new RotateTransition(Duration.millis(700), this.getCharacterSprite());
        faintAnimation.setToAngle(90);
        faintAnimation.setCycleCount(1);
        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(
                timeline, faintAnimation
        );
        sequentialTransition.setCycleCount(1);
        return sequentialTransition;
    }
    public ImageView getCharacterSprite(){
       return characterSprite;
    }

    public Animation returnAttackAnimation(ImageView characterSprite, ImageView enemySprite, Enemy enemy, Rectangle enemyHealthBar){
        int enemyHealth = enemy.getHealthTypeLevel();
        int damagePoints = this.getDamagePoints();
        enemy.setHealthTypeLevel(enemyHealth - damagePoints);
        CharacterSelectionController.player.setEnemyHealth(enemy.getHealthLevel());
        return returnHeroHitAnimation(characterSprite, enemySprite, enemyHealthBar);

    }

    public Animation returnHeroHitAnimation(ImageView hero, ImageView target, Rectangle enemyHealthBar) {
        TranslateTransition walk = new TranslateTransition(Duration.millis(500), hero);
        walk.setByX(270);
        walk.setCycleCount(1);

        RotateTransition kick = new RotateTransition(Duration.millis(200), hero);
        kick.setToAngle(-90);
        kick.setAutoReverse(true);
        kick.setCycleCount(2);

        FadeTransition blink = new FadeTransition(Duration.millis(500), target);
        blink.setFromValue(0.2);
        blink.setToValue(1.0);
        blink.setCycleCount(3);
        blink.play();

        KeyValue widthValue = new KeyValue(enemyHealthBar.widthProperty(), enemyHealthBar.getWidth() - 40);
        KeyFrame frame = new KeyFrame(Duration.seconds(1.5), widthValue);
        Timeline timeline = new Timeline(frame);

        TranslateTransition walkBack = new TranslateTransition(Duration.millis(500), hero);
        walkBack.setByX(-270);
        walkBack.setCycleCount(1);
        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(
                walk, kick, timeline, blink, walkBack
        );
        sequentialTransition.setCycleCount(1);
       return sequentialTransition;
    }

    public Animation returnBossHitAnimation(ImageView boss, ImageView target, Rectangle enemyHealthBar){
        TranslateTransition walk = new TranslateTransition(Duration.millis(500), boss);
        walk.setByX(-270);
        walk.setCycleCount(1);

        RotateTransition kick = new RotateTransition(Duration.millis(200), boss);
        kick.setToAngle(90);
        kick.setAutoReverse(true);;
        kick.setCycleCount(2);

        FadeTransition blink = new FadeTransition(Duration.millis(500), target);
        blink.setFromValue(0.2);
        blink.setToValue(1.0);
        blink.setCycleCount(3);
        blink.play();

        KeyValue widthValue = new KeyValue(enemyHealthBar.widthProperty(), enemyHealthBar.getWidth() - 40);
        KeyFrame frame = new KeyFrame(Duration.seconds(1.5), widthValue);
        Timeline timeline = new Timeline(frame);

        TranslateTransition walkBack = new TranslateTransition(Duration.millis(500), boss);
        walkBack.setByX(270);
        walkBack.setCycleCount(1);
        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(
                walk, kick, timeline, blink, walkBack
        );
        sequentialTransition.setCycleCount(1);
    return sequentialTransition;
    }
}

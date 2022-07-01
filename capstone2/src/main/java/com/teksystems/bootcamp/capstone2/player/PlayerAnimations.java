package com.teksystems.bootcamp.capstone2.player;

import javafx.animation.*;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class PlayerAnimations {

    public SequentialTransition busAnimation(ImageView bus, Rectangle health, ImageView sprite){
        TranslateTransition jumpAction = moveVertical( sprite, -30);
        jumpAction.setDuration(Duration.millis(500));
        RotateTransition shake = userRotate(sprite, 20);
        shake.setAutoReverse(true);
        shake.setCycleCount(4);
        shake.setDuration(Duration.millis(500));

        TranslateTransition driveAway = moveHorizontal(bus, -300);
        TranslateTransition driveAway2 = moveHorizontal(bus, -1000);
        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(
                driveAway, jumpAction, shake, moveVertical(sprite, 30), driveAway2, updateHealthBar(health, 20)
        );
        sequentialTransition.setCycleCount(1);
      return sequentialTransition;
    }

    public SequentialTransition walkToWork(ImageView image, Rectangle health){
        TranslateTransition walk = moveVertical(image, 130);
        RotateTransition turn = userRotate(image, -30);
        TranslateTransition walkaway = moveHorizontal(image, 300);
        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(
                walk, turn, walkaway, updateHealthBar(health,10)
        );
        sequentialTransition.setCycleCount(1);
       return sequentialTransition;
    }





    public SequentialTransition eatMushroom(ImageView image, ImageView mushroom, Rectangle characterHealth){
        SequentialTransition eatObject = new SequentialTransition(
                moveHorizontal(image, 300),
                showBlink(new FadeTransition(Duration.millis(1000), mushroom)),
                updateHealthBar(characterHealth, 15)
        );
        eatObject.setCycleCount(1);
        return eatObject;
    }

    public SequentialTransition swim(ImageView user, Rectangle characterHealth){
        SequentialTransition swim = new SequentialTransition(
                moveHorizontal(user, -250),
                userRotate(user, -180),
                moveVertical(user, 120),
                userRotate(user, -90),
                moveHorizontal(user, -500),
                updateHealthBar(characterHealth, 15)
        );
        swim.setCycleCount(1);
        return swim;
    }


    public SequentialTransition jumpOver(ImageView user, Rectangle characterHealth){
        SequentialTransition jumpOver = new SequentialTransition(
                moveHorizontal(user, -250),
                jump(user, -150, -200),
                showBlink(new FadeTransition(Duration.millis(1000), user)),
                userRotate(user, -180),
                moveVertical(user, 500),
                updateHealthBar(characterHealth, 20)
        );
        jumpOver.setCycleCount(1);
    return jumpOver;
//        getPlayer().updatePlayerHealth(characterHealth, 30);
//        getPlayer().setPlayerHealthBar(getPlayer().getPlayerHealthBar());
//        Alert warning = new Alert(Alert.AlertType.NONE, "You tried to jump over the lake?! Lose 30 health points!", ButtonType.CLOSE );
//        warning.setX(566);
//        warning.setY(285);
//        warning.show();
    }

    public Timeline updateHealthBar(Rectangle healthBar, int damage) {
        KeyValue widthValue = new KeyValue(healthBar.widthProperty(), healthBar.getWidth() - damage);
        KeyFrame frame = new KeyFrame(Duration.seconds(1.5), widthValue);
        Timeline timeline = new Timeline(frame);
        return timeline;
    }

    public TranslateTransition jump(ImageView image, int x, int y) {
        TranslateTransition jump = new TranslateTransition(Duration.millis(2000), image);
        jump.setByY(y);
        jump.setByX(x);
        jump.setCycleCount(1);
        return jump;
    }

    public TranslateTransition moveVertical(ImageView image, int y) {
        TranslateTransition move = new TranslateTransition(Duration.millis(2000), image);
        move.setByY(y);
        move.setCycleCount(1);
        return move;
    }

    public RotateTransition userRotate(ImageView image, int angle) {
        RotateTransition rotate = new RotateTransition(Duration.millis(100), image);
        rotate.setToAngle(angle);
        rotate.setCycleCount(1);
        return rotate;
    }


    public FadeTransition showBlink(FadeTransition target) {
        FadeTransition blink = target;
        blink.setFromValue(0.2);
        blink.setToValue(1.0);
        blink.setCycleCount(3);
        return blink;
    }

    public TranslateTransition moveHorizontal(ImageView hero, int x) {
        TranslateTransition walk = new TranslateTransition(Duration.millis(500), hero);
        walk.setByX(x);
        walk.setCycleCount(1);
        return walk;
    }

    public RotateTransition kick (ImageView image, int angle){
        RotateTransition kick = userRotate(image, angle);
        kick.setAutoReverse(true);
        kick.setCycleCount(2);
        return kick;
    }

    public SequentialTransition userAttack(ImageView characterSprite, ImageView enemySprite, Rectangle userEnemyHealthBar, int damage){
        SequentialTransition userMove = new SequentialTransition(
                moveHorizontal(characterSprite, 270),
                kick(characterSprite, -50),
                showBlink(new FadeTransition(Duration.millis(1000), enemySprite)),
                updateHealthBar(userEnemyHealthBar, damage),
                moveHorizontal(characterSprite, -270)
        );
        userMove.setCycleCount(1);
        return userMove;
    }

    public SequentialTransition userEnemytAttack(ImageView characterSprite, ImageView enemySprite, Rectangle userHealthBar, int damage){
        SequentialTransition userEnemyMove = new SequentialTransition(
                moveHorizontal(enemySprite, -270),
                kick(enemySprite, 50),
                showBlink(new FadeTransition(Duration.millis(1000), characterSprite)),
                updateHealthBar(userHealthBar, damage),
                moveHorizontal(enemySprite, 270)
        );
        userEnemyMove.setCycleCount(1);
        return userEnemyMove;
    }


    public Animation fight(ImageView characterSprite, ImageView enemySprite, Rectangle userHealthBar, Rectangle enemyHealthBar, int userDamage, int userEnemyDamage) {
        SequentialTransition userFight = new SequentialTransition(
                userAttack(characterSprite, enemySprite, enemyHealthBar, userDamage),
                userEnemytAttack(characterSprite, enemySprite, userHealthBar, userEnemyDamage)
        );
        userFight.setCycleCount(1);
        return userFight;
    }
}


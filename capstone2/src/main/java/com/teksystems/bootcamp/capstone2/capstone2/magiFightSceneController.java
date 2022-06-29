package com.teksystems.bootcamp.capstone2.capstone2;

import com.teksystems.bootcamp.capstone2.characters.Enemy;
import com.teksystems.bootcamp.capstone2.characters.Magi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class magiFightSceneController implements Initializable {

    @FXML
    private Rectangle characterHealth = new Rectangle();
    @FXML
    private Rectangle enemyHealth = new Rectangle();
    @FXML
    private Text enemyHealthType;
    @FXML
    private Text characterHealthType;
    @FXML
    private ImageView enemySprite;
    @FXML
    private ImageView characterSprite;
    @FXML
    private final Magi character = ToBeHumaansMainController.getCharacter();
    @FXML
    private Enemy enemy;

    private static AudioClip bossBattleMusic = new AudioClip("https://vgmsite.com/soundtracks/duck-tales/ksfvgilqyf/08%20Boss.mp3");
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        magiCharacterSceneController.getSceneMusic().stop();
        bossBattleMusic.setVolume(0.03);
        bossBattleMusic.play();
        enemy = new Enemy("Magic", enemySprite);
        enemyHealthType.setText("Magic");
        characterHealthType.setText("Magic");
        enemyHealth.setWidth(enemy.getHealthTypeLevel());
        characterHealth.setWidth(character.getHealthTypeLevel());



    }

    @FXML
    public void attack() {
        character.attack(enemy);
        character.animateHit(enemySprite);
        enemyHealth.setWidth(enemy.getHealthTypeLevel());
        enemy.attack(character);
        enemy.animateHit(characterSprite);
        characterHealth.setWidth(character.getHealthTypeLevel());
    }

    @FXML public void endGame(ActionEvent event) throws IOException, InterruptedException {
        AudioClip gameOver = new AudioClip("https://vgmsite.com/soundtracks/super-mario-bros.-3/vajfqlsc/36%20-%20Game%20Over.mp3");
        gameOver.setVolume(0.05);
        gameOver.play();
        Parent root = FXMLLoader.load(getClass().getResource("endGame.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    public static AudioClip getBossBattleMusic(){
        return bossBattleMusic;
    }
}

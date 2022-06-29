package com.teksystems.bootcamp.capstone2.capstone2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PlayerControl {
    @FXML
    public void endGame(ActionEvent event) throws IOException, InterruptedException {
        Parent root = FXMLLoader.load(getClass().getResource("endGame.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void startGame(ActionEvent event) throws IOException {
        new CharacterSelectionController().startGame(event);
    }
}

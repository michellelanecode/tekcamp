package com.teksystems.bootcamp.capstone2.capstone2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ToBeHumaansController {
    @FXML
    private Stage stage;
    private Parent root;
    private Scene scene;

@FXML
    public void switchToCharacterScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("characterscene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

@FXML
    public void startForestQuest(ActionEvent event) throws IOException {
    System.out.println(event);
        Parent root = FXMLLoader.load(getClass().getResource("forest1.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML public void startForestQuestPt2(ActionEvent event) throws IOException {
        System.out.println(event);
        Parent root = FXMLLoader.load(getClass().getResource("forest2.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML public void startFightScene(ActionEvent event) throws IOException {
        System.out.println(event);
        Parent root = FXMLLoader.load(getClass().getResource("startFightScene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

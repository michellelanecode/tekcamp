module com.teksystems.bootcamp.capstone.capstone {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.teksystems.bootcamp.capstone2.controllers to javafx.fxml;
    exports com.teksystems.bootcamp.capstone2.controllers;
    exports com.teksystems.bootcamp.capstone2.characters;
    opens com.teksystems.bootcamp.capstone2.characters to javafx.fxml;
    exports com.teksystems.bootcamp.capstone2.audio;
    opens com.teksystems.bootcamp.capstone2.audio to javafx.fxml;
    exports com.teksystems.bootcamp.capstone2.player;
    opens com.teksystems.bootcamp.capstone2.player to javafx.fxml;


}
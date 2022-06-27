module com.teksystems.bootcamp.capstone2.capstone2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.teksystems.bootcamp.capstone2.capstone2 to javafx.fxml;
    exports com.teksystems.bootcamp.capstone2.capstone2;
    exports com.teksystems.bootcamp.capstone2.questActions;
    opens com.teksystems.bootcamp.capstone2.questActions to javafx.fxml;
    exports com.teksystems.bootcamp.capstone2.characters;
    opens com.teksystems.bootcamp.capstone2.characters to javafx.fxml;
    exports com.teksystems.bootcamp.capstone2.characterActions;
    opens com.teksystems.bootcamp.capstone2.characterActions to javafx.fxml;
}
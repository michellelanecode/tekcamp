module com.teksystems.bootcamp.capstone.capstone {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.teksystems.bootcamp.capstone2.capstone2 to javafx.fxml;
    exports com.teksystems.bootcamp.capstone2.capstone2;
    exports com.teksystems.bootcamp.capstone2.characters;
    opens com.teksystems.bootcamp.capstone2.characters to javafx.fxml;


}
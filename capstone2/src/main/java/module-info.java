module com.teksystems.bootcamp.capstone2.capstone2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.teksystems.bootcamp.capstone2.capstone2 to javafx.fxml;
    exports com.teksystems.bootcamp.capstone2.capstone2;
}
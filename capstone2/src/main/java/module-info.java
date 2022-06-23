module com.example.tobehumaan {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tobehumaan to javafx.fxml;
    exports com.example.tobehumaan;
}
module com.sujey.mangos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.sujey.mangos to javafx.fxml;
    exports com.sujey.mangos;
    exports com.sujey.mangos.controllers;
    opens com.sujey.mangos.controllers to javafx.fxml;
}
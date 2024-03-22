module ua.nure.chess {
    requires javafx.controls;
    requires javafx.fxml;


    opens ua.nure.chess to javafx.fxml;
    exports ua.nure.chess;
}
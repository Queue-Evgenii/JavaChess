package ua.nure.chess;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ua.nure.chess.models.board.Board;

public class Chess extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Group group = new Group();
        group.getChildren().add(new Board());

        VBox vbox = new VBox(group);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 800, 600);
        stage.setTitle("Chess Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

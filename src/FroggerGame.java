import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FroggerGame extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Frogger");

        Pane background = new Pane();
        background.setMinWidth(800);
        background.setMinHeight(700);

        Scene scene = new Scene(background, 800, 700);
        Game frogger = new Game(background, scene);

        stage.setScene(scene);
        stage.show();

        frogger.play();
    }
}



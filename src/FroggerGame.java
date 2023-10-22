import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
        background.setStyle("-fx-background-color: black;");
        Button btn = new Button("Play Game");
        btn.setPrefSize(200,100);
        btn.setTranslateX(300);
        btn.setTranslateY(300);
        ImageView img = new ImageView("/image/logo.png");
        background.getChildren().addAll(btn, img);

        Scene scene = new Scene(background, 800, 700);
        stage.setScene(scene);
        stage.show();

        btn.setOnAction((ActionEvent event) -> {
            background.getChildren().removeAll(btn, img);
            Game frogger = new Game(background, scene);
            frogger.play();
        });
    }
}



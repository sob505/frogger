import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/*
    FroggerGame (Project 3)
    Sachi Barnaby
    Start here in the main class. Run this class to start the game. A game menu will appear, and you can click the
    "Play Game" button to start playing the game. Use the arrow keys on the main keyboard to move the frog that starts
    at the bottom of the screen. Get all the way to the top without hitting vehicles or falling in the water to win!

    You also have three lives as indicated by the frogs in the bottom left corner. If you run out of lives before
    completing the level, you lose.
 */

public class FroggerGame extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Frogger");

        // Set up background pane
        Pane background = new Pane();
        background.setMinWidth(800);
        background.setMinHeight(700);
        background.setStyle("-fx-background-color: black;");
        // Create button to play game
        Button btn = new Button("Play Game");
        btn.setPrefSize(200,100);
        btn.setTranslateX(300);
        btn.setTranslateY(300);
        // Add logo image
        ImageView img = new ImageView("/image/logo.png");
        background.getChildren().addAll(btn, img);

        Scene scene = new Scene(background, 800, 750);
        stage.setScene(scene);
        stage.show();

        // Start game when button is pressed
        btn.setOnAction((ActionEvent event) -> {
            background.getChildren().removeAll(btn, img);
            Game frogger = new Game(background, scene);
            frogger.play();
        });
    }
}



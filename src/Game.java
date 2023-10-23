import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Game {
    private Frog player;
    private final Background background;
    private AnimationTimer timer;
    private final Pane pane;
    private final Scene scene;
    // Set up the game
    public Game(Pane pane, Scene scene) {
        this.pane = pane;
        this.scene = scene;
        keyListener(this.scene);
        this.background = new Background(pane);
        this.player = new Frog();
        this.pane.getChildren().addAll(this.player.getFrog());
    }

    // Run the animation timer throughout the game
    public void play() {
        this.timer = new AnimationTimer() {
            private Duration lastUpdate = Duration.of(10, ChronoUnit.NANOS);
            @Override
            public void handle(long now) {
                Duration nowDur = Duration.of(now, ChronoUnit.NANOS);
                if (nowDur.minus(lastUpdate).toMillis() > 25) {
                    lastUpdate = nowDur;
                    background.move();
                    checkCollisions();
                }
            }
        };
        this.timer.start();
    }

    // Check if the frog collided with a vehicle
    public void checkCollisions() {
        BackgroundPiece[][] pieces = this.background.getBackgroundPieces();
        for (int i = 0; i < pieces.length; i++) {
            for(int j = 0; j < pieces[i].length; j++) {
                if (pieces[i][j] != null && this.player.getFrog().intersects(pieces[i][j].getShape().getBoundsInLocal())) {
                    if (pieces[i][j].getType().equals("Vehicle")) {
                        lose("Collision");
                        return;
                    } else {
                        moveFrogWithLog(pieces[i][j]);
                        return;
                    }
                }
            }
        }
        checkSplash();
    }
    // Check if the frog fell in the water
    private void checkSplash() {
        for(int i = 1; i < 6; i++) {
            if(this.player.getFrog().intersects(this.background.getBackground()[i].getBoundsInLocal())) {
                lose("Splash");
                break;
            }
        }

    }
    // Move the player frog when arrow keys are pressed
    private void keyListener(Scene scene) {
        scene.setOnKeyPressed(ke -> {
            KeyCode keyCode = ke.getCode();
            if (keyCode.isArrowKey()) {
                player.moveFrog(keyCode);
                checkCollisions();
            }
        });
    }
    // Run this if you lose the game
    private void lose(String type) {
        this.timer.stop();
        this.pane.getChildren().removeAll();
        Button btn = new Button("Play again?");
        btn.setPrefSize(100,50);
        btn.setTranslateX(350);
        btn.setTranslateY(325);
        this.pane.getChildren().add(btn);

        btn.setOnAction((ActionEvent event) -> {
            this.pane.getChildren().remove(btn);
            Game frogger = new Game(this.pane, this.scene);
            frogger.play();
        });
    }
    // If a frog is sitting on a turtle or log, it should move with the object
    private void moveFrogWithLog(BackgroundPiece piece) {
        this.player.getFrog().setCenterX(this.player.getFrog().getCenterX() + piece.getSpeed());
    }
}

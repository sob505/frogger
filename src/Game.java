import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static javafx.scene.shape.Shape.intersect;

public class Game {
    private Frog player;
    private final Background background;
    private AnimationTimer timer;
    private final Pane pane;
    private final Scene scene;
    public Game(Pane pane, Scene scene) {
        this.pane = pane;
        this.scene = scene;
        keyListener(this.scene);
        this.background = new Background(pane);
        this.player = new Frog();
        this.pane.getChildren().addAll(this.player.getFrog());
    }

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

    public void checkCollisions() {
        BackgroundPiece[][] pieces = this.background.getBackgroundPieces();
        for (int i = 0; i < pieces.length; i++) {
            for(int j = 0; j < pieces[i].length; j++) {
                if (pieces[i][j] != null && this.player.getFrog().intersects(pieces[i][j].getShape().getBoundsInLocal())) {
                    lose();
                    break;
                }
            }
        }
    }
    private void keyListener(Scene scene) {
        scene.setOnKeyPressed(ke -> {
            KeyCode keyCode = ke.getCode();
            if (keyCode.isArrowKey()) {
                player.moveFrog(keyCode);
                checkCollisions();
            }
        });
    }
    private void lose() {
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
}

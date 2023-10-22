import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Game {
    private Frog player;
    private final Background background;
    private final Pane pane;
    public Game(Pane pane, Scene scene) {
        this.pane = pane;
        keyListener(scene);
        this.background = new Background(pane);
        this.player = new Frog();
        pane.getChildren().addAll(this.player.getFrog());
    }

    public void play() {
        AnimationTimer timer = new AnimationTimer() {
            private Duration lastUpdate = Duration.of(10, ChronoUnit.NANOS);
            @Override
            public void handle(long now) {
                Duration nowDur = Duration.of(now, ChronoUnit.NANOS);
                if (nowDur.minus(lastUpdate).toMillis() > 25) {
                    lastUpdate = nowDur;
                    background.move();
                }
            }
        };
        timer.start();
    }

    private void keyListener(Scene scene) {
        scene.setOnKeyPressed(ke -> {
            KeyCode keyCode = ke.getCode();
            if (keyCode.isArrowKey()) {
                player.moveFrog(keyCode);
                return;
            } else
                return;
        });
    }
}

import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Game {
    private Frog player;
    private final Background background;
    private final Pane pane;
    public Game(Pane pane) {
        this.pane = pane;
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
}

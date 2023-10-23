import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;

import java.util.Objects;

public class Frog extends Node {
    private Ellipse frog;
    private final AudioClip hop = new AudioClip(Objects.requireNonNull(getClass().getResource("/sound/sound-frogger-hop.wav")).toExternalForm());;
    public Frog() {
        this.frog = new Ellipse(20,20);
        Image frogImage = new Image("/image/frog.png");
        this.frog.setFill(new ImagePattern(frogImage));
        this.frog.setCenterX(400);
        this.frog.setCenterY(650);
    }

    public void resetFrog() {

    }

    public void moveFrog(KeyCode keyCode) {
        if(keyCode.equals(KeyCode.UP)) {
            // Check that the frog is not going out of bounds
            if(this.frog.getCenterY() - 40 >= 40) {
                this.frog.setCenterY(this.frog.getCenterY() - 50);
                this.frog.setRotate(0);
            }
        } else if (keyCode.equals(KeyCode.DOWN)) {
            // Check bounds
            if(this.frog.getCenterY() + 40 <= 700 - 40) {
                this.frog.setCenterY(this.frog.getCenterY() + 50);
                this.frog.setRotate(180);
            }
        } else if (keyCode.equals(KeyCode.LEFT)) {
            // Check bounds
            if(this.frog.getCenterX() - 40 >= 60) {
                this.frog.setCenterX(this.frog.getCenterX() - 40);
                this.frog.setRotate(-90);
            }
        } else if (keyCode.equals(KeyCode.RIGHT)) {
            // Check bounds
            if(this.frog.getCenterX() + 40 <= 740) {
                this.frog.setCenterX(this.frog.getCenterX() + 40);
                this.frog.setRotate(90);
            }
        }
        this.hop.play();
    }
    public Ellipse getFrog() { return this.frog; }
}

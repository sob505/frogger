import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Frog extends Node {
    private Circle frog;
    public Frog() {
        this.frog = new Circle(20, Paint.valueOf("Green"));
        this.frog.setCenterX(400);
        this.frog.setCenterY(650);
        this.frog.setStroke(Paint.valueOf("Black"));
    }

    public void moveFrog(KeyCode keyCode) {
        if(keyCode.equals(KeyCode.UP)) {
            // Check that the frog is not going out of bounds
            if(this.frog.getCenterY() - 40 >= 40) {
                this.frog.setCenterY(this.frog.getCenterY() - 40);
            }
        } else if (keyCode.equals(KeyCode.DOWN)) {
            // Check bounds
            if(this.frog.getCenterY() + 40 <= 700 - 40) {
                this.frog.setCenterY(this.frog.getCenterY() + 40);
            }
        } else if (keyCode.equals(KeyCode.LEFT)) {
            // Check bounds
            if(this.frog.getCenterX() - 40 >= 60) {
                this.frog.setCenterX(this.frog.getCenterX() - 40);
            }
        } else if (keyCode.equals(KeyCode.RIGHT)) {
            // Check bounds
            if(this.frog.getCenterX() + 40 <= 740) {
                this.frog.setCenterX(this.frog.getCenterX() + 40);
            }
        }

    }
    public Circle getFrog() { return this.frog; }
}

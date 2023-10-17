import javafx.scene.Node;
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

    public void moveFrog() {
        this.frog.setCenterY(this.frog.getCenterY()-1);
    }
    public Circle getFrog() { return this.frog; }
}

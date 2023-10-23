import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public abstract class BackgroundPiece {
    private final int row;
    private double speed;
    private final Rectangle shape;
    private final String type;

    // Set up the background pieces
    public BackgroundPiece(int row, double speed, int width, Image img, String type) {
        this.row = row;
        this.speed = speed;
        this.shape = new Rectangle();
        this.shape.setHeight(40);
        this.shape.setWidth(width);
        this.shape.setFill(new ImagePattern(img));
        this.type = type;
    }

    public abstract void move();

    public Rectangle getShape() { return shape; }
    public double getX() { return this.shape.getX(); }
    public double getY() { return this.shape.getY(); }
    public void setX(double x) { this.shape.setX(x); }
    public void setY(double y) { this.shape.setY(y); }

    public double getWidth() { return this.shape.getWidth(); }
    public String getType() { return this.type; }
    public double getSpeed() { return this.speed; }
    public void setSpeed(double speed) { this.speed = speed; }
}

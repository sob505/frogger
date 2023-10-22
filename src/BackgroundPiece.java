import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public abstract class BackgroundPiece {
    private final int row;
    private final int direction;
    private final Rectangle shape;

    public BackgroundPiece(int row, int direction, int width, Image img) {
        this.row = row;
        this.direction = direction;
        this.shape = new Rectangle();
        this.shape.setHeight(40);
        this.shape.setWidth(width);
        this.shape.setFill(Paint.valueOf("White"));
        this.shape.setFill(new ImagePattern(img));
    }

    public abstract void move();

    public Rectangle getShape() { return shape; }
    public double getX() { return this.shape.getX(); }
    public double getY() { return this.shape.getY(); }
    public void setX(double x) { this.shape.setX(x); }
    public void setY(double y) { this.shape.setY(y); }

    public double getWidth() { return this.shape.getWidth(); }
    public void setRotate(double rotate) { this.shape.setRotate(rotate); }
}

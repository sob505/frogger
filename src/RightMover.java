import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class RightMover extends BackgroundPiece {
    public RightMover(int row, int width, Image img, int spacing, String type, double rowSpeed) {
        super(row, rowSpeed, width, img, type);
        super.setX(spacing);
    }

    @Override
    public void move() {
        if(super.getX() > 825) {
            super.setX(0 - super.getWidth());
        } else {
            super.setX(super.getX() + super.getSpeed());
        }
    }
}

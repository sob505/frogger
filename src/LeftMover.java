import javafx.scene.image.Image;

import java.util.Random;

public class LeftMover extends BackgroundPiece {
    public LeftMover(int row, int width, Image img, int spacing, String type, double rowSpeed) {
        super(row, -1 * rowSpeed, width, img, type);
        super.setX(spacing);
    }

    @Override
    public void move() {
        if(super.getX() + super.getWidth() < -10) {
            super.setX(750);
        } else {
            super.setX(super.getX() + super.getSpeed());
        }
    }
}

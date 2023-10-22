import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class RightMover extends BackgroundPiece {
    private static final int direction = 1;
    public RightMover(int row, int width, Image img, int spacing) {
        super(row, direction, width, img);
        super.setX(spacing);
    }

    @Override
    public void move() {

    }
}

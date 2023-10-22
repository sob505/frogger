import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class RightMover extends BackgroundPiece {
    private static final int direction = 1;
    public RightMover(int row, int width, Image img) {
        super(row, direction, width, img);
    }

    @Override
    public void move() {

    }
}

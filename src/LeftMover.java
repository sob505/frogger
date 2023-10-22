import javafx.scene.image.Image;

public class LeftMover extends BackgroundPiece{
    private static final int direction = -1;
    public LeftMover(int row, int width, Image img) {
        super(row, direction, width, img);
    }

    @Override
    public void move() {

    }
}

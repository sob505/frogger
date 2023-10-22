import javafx.scene.image.Image;

public class FloatFactory implements LocationFactory {
    @Override // Only logs move to the right in the river
    public RightMover makeRightMover(int row, int index) {
        int width;
        // Determine length of log depending on which row its in
        switch (row) {
            case 1:
                width = 160;
                break;
            case 3:
                width = 240;
                break;
            case 4:
                width = 120;
                break;
            default:
                width = 0;
                break;
        }
        switch (index) {

        }

        Image img = new Image("/image/log.png");
        return new RightMover(row, width, img);
    }

    @Override // Turtles move to the left in the river
    public LeftMover makeLeftMover(int row, int index) {
        Image img = new Image("/image/turtle.png");;
        int width = 0;
        switch (row) {
            case 2:
                img = new Image("/image/turtles2.png");
                width = 80;
                break;
            case 5:
                img = new Image("/image/turtles3.png");
                width = 120;
                break;
        }
        return new LeftMover(row, width, img);
    }
}

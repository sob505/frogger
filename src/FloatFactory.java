import javafx.scene.image.Image;

public class FloatFactory implements LocationFactory {
    @Override // Only logs move to the right in the river
    public RightMover makeRightMover(int row, int index) {
        int width = 0;
        int spacing = 0;
        Image img = new Image("/image/log.png");
        // Determine length of log depending on which row its in
        switch (row) {
            case 1:
                width = 160;
                spacing = (width + 40) * index;
                img = new Image("/image/log3.png");
                break;
            case 3:
                width = 240;
                spacing = (width + 120) * index;
                img = new Image("/image/log4.png");
                break;
            case 4:
                width = 120;
                spacing = (width + 180) * index;
                img = new Image("/image/log2.png");
                break;
        }
        return new RightMover(row, width, img, spacing);
    }

    @Override // Turtles move to the left in the river
    public LeftMover makeLeftMover(int row, int index) {
        Image img = new Image("/image/turtle.png");;
        int width = 0;
        int spacing = 40;
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
        return new LeftMover(row, width, img, (spacing + width) * index);
    }
}

import javafx.scene.image.Image;

public class VehicleFactory implements LocationFactory {
    @Override // Green car and tractor move right
    public RightMover makeRightMover(int row, int index) {
        Image img = new Image("/image/frog.png");
        switch (row) {
            case 8:
                img = new Image("/image/greenCar.png");
                break;
            case 10:
                img = new Image("/image/Tractor.png");
                break;
        }
        return new RightMover(row, 50, img);
    }

    @Override // Truck, purple car, and yellow car move left
    public LeftMover makeLeftMover(int row, int index) {
        int width = 50;
        Image img = new Image("/image/frog.png");
        switch (row) {
            case 7:
                width = 100;
                img = new Image("/image/Truck.png");
                break;
            case 9:
                img = new Image("/image/purpleCar.png");
                break;
            case 11:
                img = new Image("/image/yellow-car.png");
                break;
        }
        return new LeftMover(row, width, img);
    }
}

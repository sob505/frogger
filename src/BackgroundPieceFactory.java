public class BackgroundPieceFactory {
    BackgroundPiece piece;

    public BackgroundPiece createPiece(int row, int index, double rowSpeed) {
        switch(row) {
            case 1, 3, 4:
                piece = new FloatFactory().makeRightMover(row, index, rowSpeed);
                break;
            case 2, 5:
                piece = new FloatFactory().makeLeftMover(row, index, rowSpeed);
                break;
            case 8, 10:
                piece = new VehicleFactory().makeRightMover(row, index, rowSpeed);
                break;
            case 7, 9, 11:
                piece = new VehicleFactory().makeLeftMover(row, index, rowSpeed);
                break;
            default: // for rows 6 and 12
                break;
        }
        return piece;
    }
}

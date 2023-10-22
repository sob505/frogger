public class BackgroundPieceFactory {
    BackgroundPiece piece;

    public BackgroundPiece createPiece(int row, int index) {
        switch(row) {
            case 1, 3, 4:
                piece = new FloatFactory().makeRightMover(row, index);
                break;
            case 2, 5:
                piece = new FloatFactory().makeLeftMover(row, index);
                break;
            case 8, 10:
                piece = new VehicleFactory().makeRightMover(row, index);
                break;
            case 7, 9, 11:
                piece = new VehicleFactory().makeLeftMover(row, index);
                break;
            default: // for rows 0, 6, and 12
                break;
        }
        return piece;
    }
}

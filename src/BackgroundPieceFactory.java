public class BackgroundPieceFactory {
    BackgroundPiece piece;

    public BackgroundPiece createPiece(int row) {
        switch(row) {
            case 1, 3, 4:
                piece = new FloatFactory().makeRightMover(row);
                break;
            case 2, 5:
                piece = new FloatFactory().makeLeftMover(row);
                break;
            case 8, 10:
                piece = new VehicleFactory().makeRightMover(row);
                break;
            case 7, 9, 11:
                piece = new VehicleFactory().makeLeftMover(row);
                break;
            default: // for rows 0, 6, and 12
                break;
        }
        return piece;
    }
}

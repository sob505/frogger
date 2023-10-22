public interface LocationFactory {
    public RightMover makeRightMover(int row, int index, double rowSpeed);
    public LeftMover makeLeftMover(int row, int index, double rowSpeed);
}

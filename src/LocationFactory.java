public interface LocationFactory {
    public RightMover makeRightMover(int row, int index);
    public LeftMover makeLeftMover(int row, int index);
}

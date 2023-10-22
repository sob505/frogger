public interface LocationFactory {
    public RightMover makeRightMover(int row);
    public LeftMover makeLeftMover(int row);
}

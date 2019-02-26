package shapes;

/**
 * Represents an above operation: putting two IShapes one on top of the other, with their centers aligned.
 */
public class Above implements IOperation {

  private IShape top;
  private IShape bottom;

  public Above(IShape top, IShape bottom) {
    this.top = top;
    this.bottom = bottom;
  }
}

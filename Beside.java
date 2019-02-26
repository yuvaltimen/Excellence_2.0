package shapes;

/**
 * Represents a beside operation: putting two IShapes side-by-side, with their centers aligned.
 */
public class Beside implements IOperation {

  private IShape left;
  private IShape right;

  public Beside(IShape left, IShape right) {
    this.left = left;
    this.right = right;
  }
}

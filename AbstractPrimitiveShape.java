package shapes;

import java.util.List;
import java.awt.Color;

/**
 * Represents the abstract class for a primitive shape.
 * In this case, a primitive shape is one that cannot be made from combining 1 or more
 * IShapes with the given combo operations.
 */
public abstract class AbstractPrimitiveShape extends AbstractShape {

  protected Dimension2D dimension;


  /**
   * Default constructor.
   *
   * @param posn The position of this shape.
   * @param color The color of this shape.
   */

  public AbstractPrimitiveShape(String name, Dimension2D posn, Color color, List<Morph> instructions,
                                Dimension2D dimension) {
    super(name, posn, color, instructions);
    this.dimension = dimension;
  }

  /**
   * Scales the current shape based on the scale factor.
   */

  @Override
  protected void scale(Dimension2D scl) {
    Dimension2D newDim = this.dimension.mult(scl);
    this.dimension = newDim;
  }

}

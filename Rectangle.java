package shapes;

import java.awt.*;
import java.util.List;

/**
 * Represents a Rectangular shape.
 */
public class Rectangle extends AbstractPrimitiveShape {

  /**
   * Default constructor.
   *
   * @param name The name of this shape
   * @param posn the position of this shape.
   * @param color the color of this shape.
   * @param instructions the set of instructions on how this shape changes with each tick.
   * @param dimension the dimensions of the shape.
   */
  public Rectangle(String name, Dimension2D posn, Color color, List<Morph> instructions, Dimension2D dimension) {
    super(name, posn, color, instructions, dimension);
  }

  /**
   * Draws the ellipse.
   */

  @Override
  public void display() {
    //TODO: Fill in method body

  }

  @Override
  public String getType() {
    return "rectangle";
  }
}

package shapes;

import java.awt.*;
import java.util.List;

/**
 * Represents an Elliptical shape.
 */
public class Ellipse extends AbstractPrimitiveShape {


  /**
   * Default constructor.
   *
   * @param name The name of this shape.
   * @param posn the position of this shape.
   * @param color the color of this shape.
   * @param instructions the set of instructions on how this shape changes with each tick.
   * @param dimension the dimensions of the shape.
   */
  public Ellipse(String name, Dimension2D posn, Color color, List<Morph> instructions, Dimension2D dimension) {
    super(name, posn, color, instructions, dimension);
  }

  /**
   * Draws the ellipse.
   */

  @Override
  public void display() {
    /*
    THIS METHOD IS INTENTIONALLY LEFT BLANK
    IT WILL BE IMPLEMENTED IN THE VIEW PORTION OF THE ASSIGNMENT
    */
  }

  @Override
  public String getType() {
    return "ellipse";
  }
}

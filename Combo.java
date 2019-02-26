package shapes;

import java.awt.*;
import java.util.List;

/**
 * Represents a combination of two or more IShapes, combined by some operation.
 */
public class Combo extends AbstractShape {

  private IOperation op;

  /**
   * Default constructor.
   *
   * @param name The name of this shape.
   * @param posn The position of this shape.
   * @param color The color of this shape.
   * @param instructions The set of instructions detailing how this shape changes with each tick.
   */

  public Combo(String name, Dimension2D posn, Color color, List<Morph> instructions, IOperation op) {
    super(name, posn, color, instructions);
    this.op = op;
  }


  /**
   * Return the type of this shape.
   */

  @Override
  public String getType() {
    return "combo";
  }

  /**
   * Reads the list of instructions and changes the shape as described.
   */

  @Override
  public void transition() {
    //TODO: fill in method body
  }

  /**
   * Draws this combo.
   */

  @Override
  public void display() {
    //TODO: fill in method body
  }


}

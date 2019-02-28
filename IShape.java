package shapes;

/**
 * Represents a shape in an animation.
 */
public interface IShape {

  /**
   * Reads the list of instructions and changes the shape as described.
   */

  void transition(int tick);


  /**
   * Draws the shape.
   */

  void display();

  /**
   * Retrieves the name of this shape.
   * @return the name of this shape.
   */

  String getName();

  /**
   *
   * @return the type formatted as a string.
   */

  String getType();

  /**
   * Evaluates each Morph in this shapes list of instructions.
   * @return the instructions formatted as a string.
   */

  String textMotions();
}

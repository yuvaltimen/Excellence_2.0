package shapes;

import java.awt.*;
import java.util.List;

/**
 * Represents an abstract class for a shape.
 * Contains its position as a Dimension2D, a Color color, and a list of ITransitions describing
 * how the shape should change with each tick.
 */
public abstract class AbstractShape implements IShape {

  private String name;
  private Dimension2D posn;
  private Color color;
  private List<Morph> instructions;

  /**
   * Default constructor.
   */

  public AbstractShape(String name, Dimension2D posn, Color color, List<Morph> instructions) {
    this.name = name;
    this.posn = posn;
    this.color = color;
    this.instructions = instructions;
  }

  /**
   * Retrieves the name of this shape.
   * @return the name of this shape.
   */

  @Override
  public String getName() {
    return this.name;
  }

  /**
   * Returns the instructions of this shape formatted as a string.
   */

  @Override
  public String textMotions() {
    StringBuilder sb = new StringBuilder();

    int morphSize = this.instructions.size();

    for (int i = 0; i < morphSize; i++) {
      Morph m = this.instructions.get(i);
      String line = String.format(this.name + " %3d %3d %3d %3d %3d %3d %3d %3d   "
              + "%3d %3d %3d %3d %3d %3d %3d %3d",
              m.getStartTick(),
              Math.round(m.getInitPosn().getX()),
              Math.round(m.getInitPosn().getY()),
              Math.round(m.getInitDim().getX()),
              Math.round(m.getInitDim().getY()),
              m.getInitColor()[0],
              m.getInitColor()[1],
              m.getInitColor()[2],
              m.getEndTick(),
              Math.round(m.getEndPosn().getX()),
              Math.round(m.getEndPosn().getY()),
              Math.round(m.getEndDim().getX()),
              Math.round(m.getEndDim().getY()),
              m.getEndColor()[0],
              m.getEndColor()[1],
              m.getEndColor()[2]);
      sb.append("motion " + line);
      if (i < morphSize - 1) {
        sb.append("\n");
      }
    }
    return sb.toString();
  }

  /**
   * Reads the list of instructions and changes the shape as described.
   */

  @Override
  public abstract void transition();

}

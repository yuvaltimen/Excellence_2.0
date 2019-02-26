import shapes.IShape;
import shapes.Morph;

import java.util.List;

/**
 * Implementing class of Animatable. Represents the model for an animation.
 */
public class AnimationModel implements Animatable {

  private List<IShape> shapes;

  /**
   * Default constructor.
   */

  public AnimationModel(List<IShape> shapes) {
    this.shapes = shapes;
  }


  /**
   * Draws the animation.
   */

  @Override
  public void drawAnimation() {
    //TODO: fill in method body
  }


  /**
   * Describes the animation in a text format.
   */

  @Override
  public String outputText() {
    StringBuilder sb = new StringBuilder();

    int shapeLength = this.shapes.size();

    for (int j = 0; j < shapeLength; j++) {
      IShape s = this.shapes.get(j);

      sb.append("shape " + s.getName() + " " + s.getType() + "\n");
      sb.append(s.textMotions());

      if (j < shapeLength - 1) {
        sb.append("\n\n");
      }

    }
    return sb.toString();

    /*
    For this method I'm thinking the following:

    for (IShape s : shapes) {
    print("shape" + shapeVariableName + shapeType + \n)
    for (Morph m : s.instructions) {
    println("motion" + shapeVariableName + m.printInitConds() + " " + m.printFinalConds())
    }
    println(\n)
    }

     */
  }
}

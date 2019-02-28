import shapes.IShape;

import java.util.List;

/**
 * Implementing class of Animatable. Represents the model for an animation.
 */
public class AnimationModel implements Animatable {

  private List<IShape> shapes;
  private int tick;

  /**
   * Default constructor.
   */

  public AnimationModel(List<IShape> shapes) {
    this.shapes = shapes;
    this.tick = 0;
  }


  /**
   * Draws the animation.
   */

  @Override
  public void drawAnimation() {
    //TODO: fill in method body
  }

  /**
   * Runs the model of the animation for some number of ticks.
   */

  public void runAnimation(int finTick) {
    while (this.tick < finTick) {
      this.changeFrame();
      this.tick++;
    }
  }

  /**
   * Updates the list of shapes for the current tick
   */

  public void changeFrame() {

    //changes the shapes for the current frame
    for (IShape s : this.shapes) {
      s.transition(this.tick);
    }
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

  }
}

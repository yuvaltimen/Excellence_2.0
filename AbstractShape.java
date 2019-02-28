package shapes;

import java.awt.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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
    checkValidMorphs(instructions);
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
   * Inner class for the IComparator to sort Morphs.
   */

  private static class MorphTickComp implements Comparator<Morph> {

    public MorphTickComp() {

    }

    /**
     * Compare method for morphs.
     * @param m1 the first morph.
     * @param m2 the second morph.
     * @return positive int if m1 comes first, negative int if m2 comes first, 0 if they're equal.
     */

    @Override
    public int compare(Morph m1, Morph m2) {
      return m1.compareTo(m2);
    }

    /**
     * Returns the number of ticks between two Morphs.
     * @param m1 the first morph.
     * @param m2 the second morph.
     * @return the space between the morphs.
     */

    public int howMuchPadding(Morph m1, Morph m2) {
      return m2.getStartTick() - m1.getEndTick();
    }
  }

  /**
   * Check that all of the Morphs in the given list are valid.
   * This includes checking no overlapping, and sorting the list.
   */

  private static void checkValidMorphs(List<Morph> instructions) {
    //first sort the list by startTick:
    MorphTickComp comp = new MorphTickComp();
    instructions.sort(comp);

    //check that the sorted list is all valid:
    //[this iterates over the first n-1 elements]
    for (int i = 0; i < instructions.size() - 1; i++) {
      if (comp.howMuchPadding(instructions.get(i), instructions.get(i + 1)) < 0) {
        System.out.println(comp.howMuchPadding(instructions.get(i), instructions.get(i + 1)));
        throw new IllegalArgumentException("Overlapping times in instructions.");
      }
    }


    //pad the list if needed:
    for (int i = 0; i < instructions.size() - 1; i++) {
      int padDist = comp.howMuchPadding(instructions.get(i), instructions.get(i + 1));
      if (padDist > 0) {
        padInstructions(instructions, i, padDist);
      }
    }

  }


  /**
   * Pads the instructions with identity Morphs where specified.
   */

  private static void padInstructions(List<Morph> morphs, int idx, int dur) {
   //gets the current element in List
    Morph current = morphs.get(idx);

    Morph next = morphs.get(idx + 1);

    int initTick = current.getEndTick();

    int sR = current.getEndColor()[0];
    int sG = current.getEndColor()[1];
    int sB = current.getEndColor()[2];

    int eT = next.getStartTick();

    Dimension2D endPosn = current.getEndPosn();
    Dimension2D endDim = current.getEndDim();


    //creates a new Morph will all the same properties of the previous morph but a different time frame
    Morph toAdd = new Morph(initTick, endPosn, endDim, sR, sG, sB, eT, endPosn,
            endDim, sR, sG, sB);

    morphs.add(idx + 1, toAdd);

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
   * Transition the shape accoring to the current tick.
   * @param tick
   */

  @Override
  public void transition(int tick) {
    //TODO: fill in method body
    //DO WE NEED TO TRY() THIS?
    Morph curInstruction = this.instructions.get(0);
    for (Morph m : this.instructions) {
      if (tick >= m.getStartTick() && tick <= m.getEndTick()) {
        curInstruction = m;
      }
    }

    //update the values
    this.move(curInstruction.movePerTick());
    this.scale(curInstruction.scalePerTick());
    this.colorize(curInstruction.colorPerTick());
  }

  /**
   * Moves the shape by the given amount.
   */

  private void move(Dimension2D dist) {
    Dimension2D newPos = this.posn.add(dist);
    this.posn = newPos;
  }

  /**
   * Scales the shape by the given amount.
   */

  protected abstract void scale(Dimension2D scl);

  /**
   * Changes the color as specified
   */

  private void colorize(int[] rgb) {

    int[] curColor = new int[3];

    curColor[0] = this.color.getRed();
    curColor[1] = this.color.getGreen();
    curColor[2] = this.color.getBlue();

    this.color = new Color(curColor[0] + rgb[0], curColor[1] + rgb[1], curColor[2] + rgb[2]);
  }

}

package shapes;

/**
 * Represents the abstract class for a shapes.Morph. Contains the common information
 * between all extending classes.
 */
public class Morph {

  private int startTick;
  private Dimension2D initPosn;
  private Dimension2D initDim;
  private int initR;
  private int initG;
  private int initB;

  private int endTick;
  private Dimension2D endPosn;
  private Dimension2D endDim;
  private int endR;
  private int endG;
  private int endB;


  public Morph(int sT, Dimension2D sP, Dimension2D sD, int sR, int sG, int sB, int eT, Dimension2D eP,
               Dimension2D eD, int eR, int eG, int eB) {

    this.startTick = sT;
    this.initPosn = sP;
    this.initDim = sD;
    this.initR = sR;
    this.initG = sG;
    this.initB = sB;

    this.endTick = eT;
    this.endPosn = eP;
    this.endDim = eD;
    this.endR = eR;
    this.endG = eG;
    this.endB = eB;
  }

  /**
   * Getter methods for formatting the output text and some other nefarious purposes.
   */

  public int getStartTick() {
    return this.startTick;
  }

  public Dimension2D getInitPosn() {
    return this.initPosn;
  }

  public Dimension2D getInitDim() {
    return this.initDim;
  }

  public int[] getInitColor() {
    int[] initColor = new int[3];
    initColor[0] = this.initR;
    initColor[1] = this.initG;
    initColor[2] = this.initB;
    return initColor;
  }

  public int getEndTick() {
    return this.endTick;
  }

  public Dimension2D getEndPosn() {
    return this.endPosn;
  }

  public Dimension2D getEndDim() {
    return this.endDim;
  }

  public int[] getEndColor() {
    int[] endColor = new int[3];
    endColor[0] = this.endR;
    endColor[1] = this.endG;
    endColor[2] = this.endB;
    return endColor;
  }



  /**
   * Returns the amount of distance (as a Dimension2D) to be added to the current position on each tick.
   */

  public Dimension2D movePerTick() {

    int tickDiff = this.endTick - this.startTick;
    double invTickDiff = 1.0 / tickDiff;

    Dimension2D tempPosn = this.endPosn.add(this.initPosn.mult(-1));


    Dimension2D posn = tempPosn.mult((float)invTickDiff); //Sorry for casting :(

    return posn;
  }

  /**
   * Returns the size to scale the shape over each tick, represented as a Dimension2D.
   */

  public Dimension2D scalePerTick() {
    int tickDiff = this.endTick - this.startTick;

    double invTickDiff = 1.0 / tickDiff;

    Dimension2D invInitDim = new Dimension2D(1/this.initDim.getY(), 1/this.initDim.getY());

    Dimension2D tempDim = this.endDim.mult(invInitDim);

    Dimension2D dim = tempDim.mult((float)invTickDiff);

    return dim;
  }

  /**
   * Returns an array of ints which are to be added component-wise to the RGB color each tick.
   */

  public int[] colorPerTick() {
    int[] toAddPerTick = new int[3];

    int tickDiff = this.endTick - this.startTick;

    int rDiff = this.endR - this.initR;
    int gDiff = this.endG - this.initG;
    int bDiff = this.endB - this.initB;

    int rFin = Math.floorDiv(rDiff, tickDiff);
    int gFin = Math.floorDiv(gDiff, tickDiff);
    int bFin = Math.floorDiv(bDiff, tickDiff);

    toAddPerTick[0] = rFin;
    toAddPerTick[1] = gFin;
    toAddPerTick[2] = bFin;

    return toAddPerTick;
  }

}

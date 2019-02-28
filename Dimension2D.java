package shapes;

import java.util.Objects;

/**
 * Represents a 2-dimensional position on a Cartesian grid.
 */
public class Dimension2D {

  private float x;
  private float y;

  /**
   * Default constructor.
   */
  public Dimension2D(float x, float y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Copy constructor.
   */
  public Dimension2D(Dimension2D posn) {
    this.x = posn.getX();
    this.y = posn.getY();
  }

  /**
   * Overriding the equals method and hashcode method
   */

  @Override
  public boolean equals(Object o) {
    boolean equals = true;
    if (o instanceof Dimension2D) {
      Dimension2D given = (Dimension2D) o;

      equals &= ((given.getX() == this.getX())
              && (given.getY() == this.getY()));

    }
    return equals;
  }

  public int hashcode() {

    return Objects.hash(this.getX(), this.getY());
  }

  /**
   * Getter method for the X field.
   * @return the x position of this Posn.
   */
  public float getX() {
    return this.x;
  }

  /**
   * Getter method for the Y field.
   * @return the y position of this Posn.
   */

  public float getY() {
    return this.y;
  }

  /**
   * Method for adding a given Dimension2D to this one.
   */

  public Dimension2D add(Dimension2D other) {
    return new Dimension2D(this.getX() + other.getX(), this.getY() + other.getX());
  }

  /**
   * Method for scaling this position by a given floating point value.
   */

  public Dimension2D mult(float scalar) {
    return new Dimension2D(this.getX() * scalar, this.getY() * scalar);
  }

  /**
   * Method for scaling this position by 2 given floating point values.
   */

  public Dimension2D mult(float sX, float sY) {
    return new Dimension2D(this.getX() * sX, this.getY() * sY);
  }

  /**
   * Method for scaling this position component-wise by another Dimension2D.
   */

  public Dimension2D mult(Dimension2D sc) {
    return new Dimension2D(this.getX() * sc.getX(), this.getY() * sc.getY());
  }

  /**
   * Method for scaling this position by a given int scalar value.
   */

  public Dimension2D mult(int scalar) {
    return new Dimension2D(this.getX() * scalar, this.getY() * scalar);
  }

  /**
   * Method for scaling this position by 2 given int scalar values.
   */

  public Dimension2D mult(int sX, int sY) {
    return new Dimension2D(this.getX() * sX, this.getY() * sY);
  }
}

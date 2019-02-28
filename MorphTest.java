
import org.junit.Test;
import shapes.*;
import shapes.Rectangle;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

/**
 * testing class for a Morph
 */

public class MorphTest {


  Morph mA1 = new Morph(0, new Dimension2D(100, 50), new Dimension2D(50, 100), 150, 10, 40,
          8, new Dimension2D(200, 200), new Dimension2D(50, 100), 255, 0, 0);

  Morph mA2 = new Morph(8, new Dimension2D(100, 50), new Dimension2D(50, 100), 150, 10, 40,
          10, new Dimension2D(200, 200), new Dimension2D(50, 100), 150, 10, 10);

  Morph mA3 = new Morph(10, new Dimension2D(100, 50), new Dimension2D(50, 100), 150, 10, 40,
          15, new Dimension2D(150, 150), new Dimension2D(50, 100), 150, 10, 10);

  Morph mA4 = new Morph(10, new Dimension2D(150, 150), new Dimension2D(50, 100), 150, 10, 40,
          15, new Dimension2D(150, 400), new Dimension2D(50, 100), 150, 10, 10);

  Morph mA5 = new Morph(15, new Dimension2D(150, 400), new Dimension2D(50, 100), 150, 10, 40,
          19, new Dimension2D(150, 60), new Dimension2D(50, 100), 150, 10, 10);

  Morph mA6 = new Morph(19, new Dimension2D(150, 60), new Dimension2D(50, 100), 150, 10, 40,
          31, new Dimension2D(15, 60), new Dimension2D(50, 100), 150, 10, 10);



  Morph mB1 = new Morph(8, new Dimension2D(220, 100), new Dimension2D(30, 30), 0, 0, 255,
          20, new Dimension2D(145, 55), new Dimension2D(30, 30), 0, 0, 255);

  Morph mB2 = new Morph(20, new Dimension2D(83, 50), new Dimension2D(30, 30), 0, 0, 255,
          43, new Dimension2D(70, 50), new Dimension2D(30, 30), 0, 0, 255);

  Morph mB3 = new Morph(43, new Dimension2D(440, 250), new Dimension2D(30, 30), 0, 0, 255,
          70, new Dimension2D(440, 370), new Dimension2D(30, 30), 0, 170, 85);

  Morph mB4 = new Morph(70, new Dimension2D(440, 370), new Dimension2D(30, 30), 0, 170, 85,
          80, new Dimension2D(100, 400), new Dimension2D(30, 30), 0, 255, 0);

  Morph mB5 = new Morph(80, new Dimension2D(100, 400), new Dimension2D(30, 30), 0, 255, 0,
          100, new Dimension2D(15, 60), new Dimension2D(30, 30), 0, 255, 0);


  Morph mC1 = new Morph(15, new Dimension2D(12, 0), new Dimension2D(100, 50), 50, 200, 50,
          34, new Dimension2D(440, 70), new Dimension2D(100, 50), 0, 0, 255);

  Morph mC2 = new Morph(34, new Dimension2D(250, 50), new Dimension2D(100, 50), 0, 0, 255,
          56, new Dimension2D(340, 20), new Dimension2D(100, 50), 0, 0, 255);

  Morph mC3 = new Morph(56, new Dimension2D(340, 20), new Dimension2D(100, 50), 0, 0, 255,
          64, new Dimension2D(440, 30), new Dimension2D(100, 50), 0, 170, 85);

  Morph mC4 = new Morph(64, new Dimension2D(440, 30), new Dimension2D(100, 50), 0, 170, 85,
          80, new Dimension2D(50, 50), new Dimension2D(100, 50), 0, 255, 0);


  /**
   * // TO DO: FILL IN TESTS FOR GETTER METHODS
   */
  @Test
  public void testGetStartTick() {


  }


  /**
   * test method movePerTick
   */

  @Test
  public void testMovePerTick() {

    assertEquals(mA1.movePerTick(), new Dimension2D(12.5f,12.5f));
    assertEquals(mA2.movePerTick(), new Dimension2D(50f,50f));
    assertEquals(mA3.movePerTick(), new Dimension2D(10f,10f));

    assertEquals(mB1.movePerTick(), new Dimension2D(-6.25f,-13.75f));
    assertEquals(mC3.movePerTick(), new Dimension2D(12.5f,-38.75f));

  }


  /**
   * test method ScalePerTick
   */

  @Test
  public void testScalePerTick() {

    assertEquals(mA1.scalePerTick(), new Dimension2D(.0625f,0.125f));
    assertEquals(mA2.scalePerTick(), new Dimension2D(.25f,0.5f));
    assertEquals(mA3.scalePerTick(), new Dimension2D(.1f,.2f));

    assertEquals(mB4.scalePerTick(), new Dimension2D(0.1f,0.1f));
    assertEquals(mC3.scalePerTick(), new Dimension2D(0.25f,0.125f));




  }


  /**
   * test method ScalePerTick
   */

  @Test
  public void testColorPerTick() {

    int[] exp1 = new int[3];
    exp1[0] = 13;
    exp1[1] = -2;
    exp1[2] = -5;

    int[] exp2 = new int[3];
    exp2[0] = 0;
    exp2[1] = 0;
    exp2[2] = -15;

    int[] exp3 = new int[3];
    exp3[0] = 0;
    exp3[1] = 0;
    exp3[2] = -6;

    int[] exp4 = new int[3];
    exp4[0] = 0;
    exp4[1] = 8;
    exp4[2] = -9;

    int[] exp5 = new int[3];
    exp5[0] = 0;
    exp5[1] = 5;
    exp5[2] = -6;

    assertArrayEquals(exp1, mA1.colorPerTick());
    assertArrayEquals(exp2, mA2.colorPerTick());
    assertArrayEquals(exp3, mA3.colorPerTick());

    assertArrayEquals(exp4, mB4.colorPerTick());
    assertArrayEquals(exp5, mC4.colorPerTick());

  }

  //throw an IllegalArgumentException if the end tick comes before the start tick
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_Exception1() {
    Morph test1 = new Morph(9, new Dimension2D(440, 30), new Dimension2D(100, 50), 0, 170, 85,
            8, new Dimension2D(50, 50), new Dimension2D(100, 50), 0, 255, 0);
  }

  //throw an IllegalArgumentException if the end tick comes before the start tick
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_Exception2() {
    Morph test1 = new Morph(90, new Dimension2D(440, 30), new Dimension2D(100, 50), 0, 170, 85,
            0, new Dimension2D(50, 50), new Dimension2D(100, 50), 0, 255, 0);
  }


}

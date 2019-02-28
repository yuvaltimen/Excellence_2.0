
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import shapes.*;
import shapes.Rectangle;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

/**
 * testing class for IShape interface
 */

public class IShapeTest {

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



  Morph mB1 = new Morph(8, new Dimension2D(320, 100), new Dimension2D(30, 30), 0, 0, 255,
          20, new Dimension2D(440, 70), new Dimension2D(30, 30), 0, 0, 255);

  Morph mB2 = new Morph(20, new Dimension2D(250, 50), new Dimension2D(30, 30), 0, 0, 255,
          43, new Dimension2D(440, 250), new Dimension2D(30, 30), 0, 0, 255);

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


  List<Morph> rectInstructions = Arrays.asList(mA1, mA2, mA3, mA4, mA5, mA6);

  String motionsA = "motion A   0 100  50  50 100 150  10  40     8 200 200  50 100 255   0   0\n" +
          "motion A   8 100  50  50 100 150  10  40    10 200 200  50 100 150  10  10\n" +
          "motion A  10 100  50  50 100 150  10  40    15 150 150  50 100 150  10  10\n" +
          "motion A  10 150 150  50 100 150  10  40    15 150 400  50 100 150  10  10\n" +
          "motion A  15 150 400  50 100 150  10  40    19 150  60  50 100 150  10  10\n" +
          "motion A  19 150  60  50 100 150  10  40    31  15  60  50 100 150  10  10";


  List<Morph> ellInstructions = Arrays.asList(mB1, mB2, mB3, mB4, mB5);

  String motionsB = "motion B   8 320 100  30  30   0   0 255    20 440  70  30  30   0   0 255\n" +
          "motion B  20 250  50  30  30   0   0 255    43 440 250  30  30   0   0 255\n" +
          "motion B  43 440 250  30  30   0   0 255    70 440 370  30  30   0 170  85\n" +
          "motion B  70 440 370  30  30   0 170  85    80 100 400  30  30   0 255   0\n" +
          "motion B  80 100 400  30  30   0 255   0   100  15  60  30  30   0 255   0";


  List<Morph> combInstructions = Arrays.asList(mC1, mC2, mC3, mC4);

  String motionsC = "motion C  15  12   0 100  50  50 200  50    34 440  70 100  50   0   0 255\n" +
          "motion C  34 250  50 100  50   0   0 255    56 340  20 100  50   0   0 255\n" +
          "motion C  56 340  20 100  50   0   0 255    64 440  30 100  50   0 170  85\n" +
          "motion C  64 440  30 100  50   0 170  85    80  50  50 100  50   0 255   0";





  IShape a = new Rectangle("A", new Dimension2D(200, 200), new Color(255, 0, 0), rectInstructions,
          new Dimension2D(50, 100));

  IShape b = new Ellipse("B", new Dimension2D(440, 70), new Color(0, 0, 255), ellInstructions,
          new Dimension2D(120, 60));

  IOperation beside = new Beside(a, b);

  IShape c = new Combo("C", new Dimension2D(440, 70), new Color(80, 45, 100),
          combInstructions, beside);

  /**
   * test for transition method
   */
  @Test
  public void testTransition() {
    //TO DO: Fill in
  }


  /**
   * test for getName method
   */
  @Test
  public void testGetName() {

    assertEquals(a.getName(), "A");
    assertEquals(b.getName(), "B");
    assertEquals(c.getName(), "C");


  }

  /**
   * test for getType method
   */
  @Test
  public void testGetType() {

    assertEquals(a.getType(), "rectangle");
    assertEquals(b.getType(), "ellipse");
    assertEquals(c.getType(), "combo");


  }


  /**
   * test for getMotions method
   */
  @Test
  public void testTextMotions() {
    assertEquals(a.textMotions(), motionsA);
    assertEquals(b.textMotions(), motionsB);
    assertEquals(c.textMotions(), motionsC);


  }

}

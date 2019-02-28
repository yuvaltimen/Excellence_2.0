
import org.junit.Test;
import shapes.*;
import shapes.Rectangle;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * testing class for AbstractShape class
 */


public class AbstractShapeTest {



  /**
   * test for textMotions method
   */

  @Test
  public void textMotions() {


    Morph mR1 = new Morph(1, new Dimension2D(200, 200), new Dimension2D(50, 100), 255, 0, 0,
            10, new Dimension2D(200, 200), new Dimension2D(50, 100), 255, 0, 0);

    Morph mR2 = new Morph(10, new Dimension2D(200, 200), new Dimension2D(50, 100), 255, 0, 0,
            50, new Dimension2D(300, 300), new Dimension2D(50, 100), 255, 0, 0);

    Morph mR3 = new Morph(50, new Dimension2D(300, 300), new Dimension2D(50, 100), 255, 0, 0,
            51, new Dimension2D(300, 300), new Dimension2D(50, 100), 255, 0, 0);

    Morph mR4 = new Morph(51, new Dimension2D(300, 300), new Dimension2D(50, 100), 255, 0, 0,
            70, new Dimension2D(300, 300), new Dimension2D(25, 100), 255, 0, 0);

    Morph mR5 = new Morph(70, new Dimension2D(300, 300), new Dimension2D(25, 100), 255, 0, 0,
            100, new Dimension2D(200, 200), new Dimension2D(25, 100), 255, 0, 0);


    List<Morph> rectInstructions = Arrays.asList(mR1, mR2, mR3, mR4, mR5);


    IShape a = new Rectangle("A", new Dimension2D(200, 200), new Color(255, 0, 0),
            rectInstructions, new Dimension2D(50, 100));


    String exp1 =
            "motion A   1 200 200  50 100 255   0   0    10 200 200  50 100 255   0   0\n" +
                    "motion A  10 200 200  50 100 255   0   0    50 300 300  50 100 255   0   0\n" +
                    "motion A  50 300 300  50 100 255   0   0    51 300 300  50 100 255   0   0\n" +
                    "motion A  51 300 300  50 100 255   0   0    70 300 300  25 100 255   0   0\n" +
                    "motion A  70 300 300  25 100 255   0   0   100 200 200  25 100 255   0   0";

    assertEquals(exp1, a.textMotions());

  }

  /**
   * Test that the given set of instructions throws the instruction.
   */


  @Test(expected = IllegalArgumentException.class)
  public void testNotValid() {
    Morph m1 = new Morph(0, new Dimension2D(0, 0), new Dimension2D(0, 10), 0, 0, 0,
            10, new Dimension2D(0, 0), new Dimension2D(0, 0), 0, 0, 0);

    Morph m2 = new Morph(5, new Dimension2D(0, 0), new Dimension2D(0, 10), 0, 0, 0,
            10, new Dimension2D(0, 0), new Dimension2D(0, 0), 0, 0, 0);


    List<Morph> mrp = new ArrayList<>();
    mrp.add(m1);
    mrp.add(m2);
    IShape ell = new Ellipse("E", new Dimension2D(0, 0), new Color(0), mrp, new Dimension2D(0, 0));
  }



  /**
   * Test that the given set of instructions remains the same size.
   */


  @Test
  public void testNoPadding() {
    Morph m1 = new Morph(0, new Dimension2D(0, 0), new Dimension2D(0, 10), 0, 0, 0,
            10, new Dimension2D(0, 0), new Dimension2D(0, 0), 0, 0, 0);

    Morph m2 = new Morph(10, new Dimension2D(0, 0), new Dimension2D(0, 10), 0, 0, 0,
            15, new Dimension2D(0, 0), new Dimension2D(0, 0), 0, 0, 0);


    List<Morph> mrp = new ArrayList<>();
    mrp.add(m1);
    mrp.add(m2);

    List<Morph> preCopy = new ArrayList<>();

    for (int i = 0; i < mrp.size(); i++) {
      preCopy.add(mrp.get(i));
    }

    IShape ell = new Ellipse("E", new Dimension2D(0, 0), new Color(0), mrp, new Dimension2D(0, 0));

    List<Morph> postCopy = new ArrayList<>();

    for (int i = 0; i < mrp.size(); i++) {
      postCopy.add(mrp.get(i));
    }

    assertEquals(postCopy.size(), preCopy.size());
  }

  /**
   * Test that the given set of instructions increases size.
   */


  @Test
  public void testPadding() {
    Morph m1 = new Morph(0, new Dimension2D(0, 0), new Dimension2D(0, 10), 0, 0, 0,
            10, new Dimension2D(0, 0), new Dimension2D(0, 0), 0, 0, 0);

    Morph m2 = new Morph(15, new Dimension2D(0, 0), new Dimension2D(0, 10), 0, 0, 0,
            19, new Dimension2D(0, 0), new Dimension2D(0, 0), 0, 0, 0);


    List<Morph> mrp = new ArrayList<>();
    mrp.add(m1);
    mrp.add(m2);

    List<Morph> preCopy = new ArrayList<>();

    for (int i =0; i < mrp.size(); i++) {
      preCopy.add(mrp.get(i));
    }

    IShape ell = new Ellipse("E", new Dimension2D(0, 0), new Color(0), mrp, new Dimension2D(0, 0));

    assertEquals(1, mrp.size() - preCopy.size());
  }

}

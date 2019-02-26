import org.junit.Test;
import shapes.*;
import shapes.Rectangle;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Class for testing the descriptive output for the animation produced by the model.
 */
public class ModelDescriptionTest {

  @Test
  public void testOutputText() {

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


    Morph mC1 = new Morph(6, new Dimension2D(440, 70), new Dimension2D(120, 60), 0, 0, 255,
            20, new Dimension2D(440, 70), new Dimension2D(120, 60), 0, 0, 255);

    Morph mC2 = new Morph(20, new Dimension2D(440, 70), new Dimension2D(120, 60), 0, 0, 255,
            50, new Dimension2D(440, 250), new Dimension2D(120, 60), 0, 0, 255);

    Morph mC3 = new Morph(50, new Dimension2D(440, 250), new Dimension2D(120, 60), 0, 0, 255,
            70, new Dimension2D(440, 370), new Dimension2D(120, 60), 0, 170, 85);

    Morph mC4 = new Morph(70, new Dimension2D(440, 370), new Dimension2D(120, 60), 0, 170, 85,
            80, new Dimension2D(440, 370), new Dimension2D(120, 60), 0, 255, 0);

    Morph mC5 = new Morph(80, new Dimension2D(440, 370), new Dimension2D(120, 60), 0, 255, 0,
            100, new Dimension2D(440, 370), new Dimension2D(120, 60), 0, 255, 0);

    List<Morph> rectInstructions = Arrays.asList(mR1, mR2, mR3, mR4, mR5);

    List<Morph> ellInstructions = Arrays.asList(mC1, mC2, mC3, mC4, mC5);

    IShape R = new Rectangle("R", new Dimension2D(200, 200), new Color(255, 0, 0), rectInstructions,
            new Dimension2D(50, 100));

    IShape C = new Ellipse("C", new Dimension2D(440, 70), new Color(0, 0, 255), ellInstructions,
            new Dimension2D(120, 60));

    List<IShape> shapes = Arrays.asList(R, C);

    Animatable anim = new AnimationModel(shapes);


    String exp = "shape R rectangle\n" +
            "motion R   1 200 200  50 100 255   0   0    10 200 200  50 100 255   0   0\n" +
            "motion R  10 200 200  50 100 255   0   0    50 300 300  50 100 255   0   0\n" +
            "motion R  50 300 300  50 100 255   0   0    51 300 300  50 100 255   0   0\n" +
            "motion R  51 300 300  50 100 255   0   0    70 300 300  25 100 255   0   0\n" +
            "motion R  70 300 300  25 100 255   0   0   100 200 200  25 100 255   0   0\n" +
            "\n" +
            "shape C ellipse\n" +
            "motion C   6 440  70 120  60   0   0 255    20 440  70 120  60   0   0 255\n" +
            "motion C  20 440  70 120  60   0   0 255    50 440 250 120  60   0   0 255\n" +
            "motion C  50 440 250 120  60   0   0 255    70 440 370 120  60   0 170  85\n" +
            "motion C  70 440 370 120  60   0 170  85    80 440 370 120  60   0 255   0\n" +
            "motion C  80 440 370 120  60   0 255   0   100 440 370 120  60   0 255   0";

    assertEquals(exp, anim.outputText());
  }
}

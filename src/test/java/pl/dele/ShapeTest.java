package pl.dele;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class ShapeTest {

    /**
     * Test do sprawdzenia poprawności tworzonych krawędzi
     */
    @Test
    void shapeTest(){
        // given
        List<Point> points = new ArrayList<>();
        points.add(new Point(1,1));
        points.add(new Point(1,4));
        points.add(new Point(4,4));
        points.add(new Point(4,1));

        // when
        Shape shape = new Shape(points);

        // then
        shape.draw();
    }
}

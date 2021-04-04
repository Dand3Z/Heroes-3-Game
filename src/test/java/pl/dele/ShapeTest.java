package pl.dele;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class ShapeTest {

    @Test
    void shapeTest(){
        List<Point> points = new ArrayList<>();
        points.add(new Point(1,1));
        points.add(new Point(1,4));
        points.add(new Point(4,4));
        points.add(new Point(4,1));

        Shape shape = new Shape(points);
        shape.draw();

    }
}

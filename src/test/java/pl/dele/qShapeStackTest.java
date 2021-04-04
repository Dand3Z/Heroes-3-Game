package pl.dele;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class qShapeStackTest {

    @Test
    void shapeStack() {
        Stack<Point> points = new Stack<>();
        points.add(new Point(1,1));
        points.add(new Point(1,4));
        points.add(new Point(4,4));
        points.add(new Point(4,1));

        qShapeStack shape = new qShapeStack(points);
        shape.draw();
    }
}

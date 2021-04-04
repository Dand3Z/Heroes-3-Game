package pl.dele;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.Set;

public class qShapeSetTest {

    @Test
    public void qShapeSetTest(){
        Set<Point> points = new LinkedHashSet<>();
        points.add(new Point(1,1));
        points.add(new Point(1,4));
        points.add(new Point(4,4));
        points.add(new Point(4,1));

        qShapeSet shape = new qShapeSet(points);
        shape.draw();
    }
}

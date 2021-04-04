package pl.dele;

import org.junit.jupiter.api.Test;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class qShapeQueueTest {

    @Test
    void shapeQueue() {
        Queue<Point> points = new ConcurrentLinkedQueue<>();
        points.add(new Point(1,1));
        points.add(new Point(1,4));
        points.add(new Point(4,4));
        points.add(new Point(4,1));

        qShapeQueue shape = new qShapeQueue(points);
        shape.draw();
    }
}

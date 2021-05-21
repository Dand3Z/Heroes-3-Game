package pl.dele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void shouldReturnProperPointDistance() {
        Point point1 = new Point(0,0);
        Point point2 = new Point(4,3);
        Point point3 = new Point(-4,-3);

        assertEquals(5, point1.distanceTo(point2));
        assertEquals(5, point2.distanceTo(point1));
        assertEquals(5, point1.distanceTo(point3));
        assertEquals(5, point3.distanceTo(point1));
        assertEquals(10, point2.distanceTo(point3));
    }
}
package pl.dele;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SegmentTest {

    /**
     * Segment Test
     */
    @Test
    void shouldDurationBe()
    {
        // given
        Point point1 = new Point(1,1);
        Point point2 = new Point(3,1);
        Point point3 = new Point(1,3);

        // when
        Point point1copy = new Point(point1);
        Segment s1 = new Segment(point1, point2);
        Segment s2 = new Segment(point1copy, point3);

        // then
        assertEquals(s1, s2);
        s1.getStartPoint().setX(5);
        assertEquals(s1,s2);
    }

    /**
     * SelfishSegment Test
     */
    @Test
    void shouldDurationBeSelfish(){
        // given
        Point point1 = new Point(1,1);
        Point point2 = new Point(3,1);
        Point point3 = new Point(1,3);

        // when
        Segment s1 = new SelfishSegment(point1, point2);
        Segment s2 = new SelfishSegment(point1, point3);

        // then
        assertEquals(s1, s2);
        s1.getStartPoint().setX(5);
        assertEquals(s1,s2);
    }
}

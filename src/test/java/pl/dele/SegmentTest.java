package pl.dele;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SegmentTest {
    @Test
    void shouldDurationBe()
            //throws CloneNotSupportedException
    {
        //given
        Point point1 = new Point(1,1);
        Point point2 = new Point(3,1);
        Point point3 = new Point(1,3);

//        Point point1copy = (Point) point1.clone();

//        Point point1copy = new Point(point1);
//        Segment s1 = new Segment(point1, point2);
//        Segment s2 = new Segment(point1copy, point3);
        // w powyższym musimy zawsze pamiętać o kopii
        // w tym niżej już kopia jest wykonywana zawsze

        Segment s1 = new SelfishSegment(point1, point2);
        Segment s2 = new SelfishSegment(point1, point3);

        assertEquals(s1, s2);

        s1.getStartPoint().setX(5);

        assertEquals(s1,s2);


    }
}

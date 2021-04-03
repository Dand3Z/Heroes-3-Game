package pl.dele;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SegmentTest {
    @Test
    void shouldDurationBe(){
        //given
        Point point = new Point(1,1);
        Point point2 = new Point(2,2);
        Point negativePoint = new Point(-1,-1);
        Segment segment = new Segment(point,point2);
        Segment plusMinusSegment = new Segment(point, negativePoint);

        Segment s1 = new Segment(new Point(5,1), new Point(3,1));
        Segment s2 = new Segment(new Point(1,1), new Point(1,3));
        //when
        double result = segment.getLength();
        double result2 = plusMinusSegment.getLength();
        //then
        assertEquals(Math.sqrt(2), result);
        assertEquals(2 * Math.sqrt(2), result2);
        assertEquals(s1,s2);


    }
}

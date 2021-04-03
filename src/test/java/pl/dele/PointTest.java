package pl.dele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PointTest {

    @Test
    void example() {
        // given - dane wejściowe
        Point point = new Point(1,5);
        // when - operacje na danych wejściowych
        int x = point.getX();
        // then - wynik
        assertEquals(1,x);
    }

    @Test
    //void shouldSomething...
    void distanceShouldBeSever(){
        // given
        Point point = new Point(0,7);
        Point point2 = new Point(0,5);
        // when
        double result = point.getDistanceToCenter();
        double result2 = point2.getDistanceToCenter();
        // then
        assertEquals(7, result);
        assertEquals(5, result2);
    }

    @Test
    void equalOperator() {
        int int1 = 1;
        int int2 = 1;
        Integer intObject1 = new Integer(1);
        Integer intObject2 = new Integer(1);

        //assertTrue(int1==int2);
        //assertTrue(intObject1==intObject2);

        //assertEquals(1,1);
        assertEquals(intObject1, intObject2);
        assertTrue(intObject1.equals(intObject2));
    }

    @Test
    void copyObject() {
        Integer intObject1 = new Integer(1);
        Integer copyObject = intObject1;

        assertEquals(intObject1, copyObject);
        assertTrue(intObject1.equals(copyObject));
    }

    @Test
    void twoPointsInTheSamePosition() {
        // given
        Point point1 = new Point(1,1);
        Point point2 = new Point(0,0);
        //Point point3 = new Point(3,2);
        // when
        point2.setX(1);
        point2.setY(1);
        //point3.setX(1);
        // then
        assertEquals(point1, point2);
        //assertEquals(point1, point3);

    }



}

package pl.dele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void shouldSqrtBe5(){
        // given 25
        // when
        double x = Math.sqrt(25);
        //then
        assertEquals(5, x);
    }



}

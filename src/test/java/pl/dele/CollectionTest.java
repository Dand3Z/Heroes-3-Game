package pl.dele;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CollectionTest {

    @Test
    void test(){
        Point p1 = new Point(1,1);
        Point p2 = new Point(1,1);

        Set set = new HashSet<>();
        List list = new ArrayList<>();

        set.add(p1);
        set.add(p1);
        set.add(p2);
        assertEquals(1,set.size());

        list.add(p1);
        list.add(p1);
        list.add(p2);
        assertEquals(3, list.size());

        assertTrue(set.contains(p1));
        assertTrue(set.contains(p2));
        /*
        powyżej mamy prawdę ponieważ gdy wyliczymy hash z
        obiektu p1 i p2 to są one identyczne, po czy jest wywoływane
        equals, które już finalnie potwierdza, że obiekty są tożsame
         */

        p1.setX(2);
        // hashcode ulegnie zmianie
        set.add(p1);
        System.out.println("size: " + set.size());
        System.out.println("Contains P1: " + set.contains(p1));
        System.out.println("Contains P2: " + set.contains(p2));

    }
}

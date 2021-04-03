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

        p1.setX(2);
        // hashcode ulegnie zmianie
        set.add(p1);

    }
}

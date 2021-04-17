package pl.dele;

import java.util.HashMap;
import java.util.Map;

public class Board {

    /**
     * Board can add and move the Creatures
     */
    private final Map<Point, Creature> map;

    Board() {
        this.map = new HashMap<>();
    }

    void add(Point aPoint, Creature aCreature) {
        map.put(aPoint, aCreature);
    }

    Creature get(int aX, int aY) {
        return map.get(new Point(aX, aY));
    }
}

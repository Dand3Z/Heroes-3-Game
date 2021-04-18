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
        throwExceptionWhenFieldIsTaken(aPoint);
        map.put(aPoint, aCreature);
    }

    private void throwExceptionWhenFieldIsTaken(Point aPoint) {
        if (map.containsKey(aPoint)) throw new IllegalArgumentException();
    }

    Creature get(int aX, int aY) {
        return map.get(new Point(aX, aY));
    }

    void move(Point dstPoint, Point srcPoint) {
        Creature creature = map.get(srcPoint);
        if (creature == null) throw new NullPointerException();

        Creature creatureFromDstPoint = map.get(dstPoint);
        throwExceptionWhenFieldIsTaken(dstPoint);

        // delete from map
        map.remove(srcPoint);
        // add to map
        map.put(dstPoint, creature);
    }
}

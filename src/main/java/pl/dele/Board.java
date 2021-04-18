package pl.dele;

import java.util.HashMap;
import java.util.Map;

public class Board {

    /**
     * Board can add and move the Creatures
     */
    private final Map<Point, Creature> map;
    public final static int WIDTH = 20;
    public final static int HEIGHT = 15;

    Board() {
        this.map = new HashMap<>();
    }

    void add(Point aPoint, Creature aCreature) {
        throwExceptionWhenFieldIsTakenOrIsOutsideMap(aPoint);
        map.put(aPoint, aCreature);
    }

    private void throwExceptionWhenFieldIsTakenOrIsOutsideMap(Point aPoint) {
        if (aPoint.getX() < 0 || aPoint.getX() > WIDTH || aPoint.getY() < 0
                || aPoint.getY() > HEIGHT ||  map.containsKey(aPoint))
            throw new IllegalArgumentException();
    }

    Creature get(int aX, int aY) {
        return map.get(new Point(aX, aY));
    }

    // to test
    Point get(Creature creature){
        //if (!map.containsValue(creature)) throw new InvalidParameterException();
        return map.keySet().stream().filter(p -> map.get(p).equals(creature)).findAny().get();
    }

    void move(Point dstPoint, Creature creature){
        move(dstPoint, get(creature));
    }

    void move(Point dstPoint, Point srcPoint) {
        Creature creature = map.get(srcPoint);
        if (creature == null) throw new NullPointerException();

        Creature creatureFromDstPoint = map.get(dstPoint);
        throwExceptionWhenFieldIsTakenOrIsOutsideMap(dstPoint);

        // delete from map
        map.remove(srcPoint);
        // add to map
        map.put(dstPoint, creature);
    }
}

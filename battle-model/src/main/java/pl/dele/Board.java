package pl.dele;

import java.util.HashMap;
import java.util.Map;

class Board {

    /**
     * Board can add and move the Creatures
     */
    private final Map<Point, Creature> map;
    public final static int WIDTH = 20;
    public final static int HEIGHT = 15;

    Board() {
        this.map = new HashMap<>();
    }

    void add(Point point, Creature creature) {
        throwExceptionWhenIsOutsideMap(point);
        throwExceptionIfFieldIsTaken(point);
        map.put(point, creature);
    }

    private void throwExceptionIfFieldIsTaken(Point point) {
        if (isFieldTaken(point)) throw new IllegalStateException("Field isn't empty");
    }

    private boolean isFieldTaken(Point point) {
        return map.containsKey(point);
    }

    private void throwExceptionWhenIsOutsideMap(Point aPoint) {
        if (aPoint.getX() < 0 || aPoint.getX() > WIDTH || aPoint.getY() < 0 || aPoint.getY() > HEIGHT)
            throw new IllegalArgumentException("You are trying to works outside the map");
    }

    Creature get(int aX, int aY) {
        return map.get(new Point(aX, aY));
    }

    Point get(Creature creature){
        return map.keySet().stream().filter(p -> map.get(p).equals(creature)).findAny().get();
    }

    void move(Point dstPoint, Creature creature){
        move(dstPoint, get(creature));
    }

    void move(Point dstPoint, Point srcPoint) {
        throwExceptionWhenIsOutsideMap(dstPoint);
        if (map.containsKey(dstPoint)){
            throw new IllegalArgumentException("Field is taken");
        }
        Creature creatureFromSrcPoint = map.get(srcPoint);
        if (creatureFromSrcPoint == null) throw new NullPointerException();
        map.remove(srcPoint);
        map.put(dstPoint, creatureFromSrcPoint);
    }

    boolean canMove(Creature creature, int x, int y) {
        throwExceptionWhenIsOutsideMap(new Point(x,y));
        if (!map.containsValue(creature)) throw new IllegalStateException("Creature isn't in board");

        Point currentPosition = get(creature);
        double distance = currentPosition.distanceTo(new Point(x,y));
        return distance <= creature.getMoveRange() && !isFieldTaken(new Point(x,y));
    }
}

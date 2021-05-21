package pl.dele;

import java.util.Objects;

public class Point {

    final private int x;
    final private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    double distanceTo(Point point) {
        return Math.sqrt(Math.pow(x - point.getX(),2) + Math.pow(y - point.getY(), 2));
    }
}

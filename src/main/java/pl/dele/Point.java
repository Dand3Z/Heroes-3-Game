package pl.dele;

import java.util.Objects;

public class Point {

    // == Pola ==

    private int x;
    private int y;
    private double distanceToCenter;

    // == Konstruktory ==

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        distanceToCenter = Math.sqrt(x*x + y*y);
    }

    // konstruktor samokopiujący
    public Point(Point aPoint) {
        this(aPoint.x, aPoint.y);
    }

    // == getery i setery

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    // == metody ==

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public double getDistanceToCenter() {
        return distanceToCenter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

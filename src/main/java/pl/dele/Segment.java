package pl.dele;

import java.util.Objects;

public class Segment {

    // === pola ==

    // punkt początkowy i końcowy krawędzi
    private Point startPoint;
    private Point endPoint;

    // == konstruktory ==

    public Segment(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    // == getery i setery ==

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    // == metody ==

    void draw(){
        System.out.println(toString());
    }

    public double getLength() {
         return Math.sqrt(
                    Math.pow(startPoint.getX() - endPoint.getX(),2) +
                    Math.pow(startPoint.getY() - endPoint.getY(),2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Segment segment = (Segment) o;
        return getLength() == segment.getLength();
    }

    @Override
    public int hashCode() {
        return Objects.hash(startPoint, endPoint);
    }

    @Override
    public String toString() {
        return "Segment{" +
                "startPoint=" + startPoint +
                ", endPoint=" + endPoint +
                '}';
    }
}

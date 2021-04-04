package pl.dele;

import java.util.Queue;

public class qShapeQueue {

    private Queue<Point> points;

    public qShapeQueue(Queue<Point> points) {
        this.points = points;
    }

    public void draw() {
        Point firstPoint = points.poll(); //get first element
        Point startPoint = null, endPoint = firstPoint;
        while (points.peek() != null){
            startPoint = endPoint;
            endPoint = points.poll();
            Segment s = new Segment(startPoint, endPoint);
            s.draw();
        }
        Segment s = new Segment(endPoint, firstPoint);
        s.draw();
    }
}

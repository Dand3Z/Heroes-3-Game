package pl.dele;

import java.util.Stack;

public class qShapeStack {

    private Stack<Point> points;

    public qShapeStack(Stack<Point> points) {
        this.points = points;
    }

    public void draw() {
        Point lastPoint = points.pop(); //get last element
        Point startPoint = null, endPoint = lastPoint;
        while (!points.empty()){
            startPoint = endPoint;
            endPoint = points.pop();
            Segment s = new Segment(startPoint, endPoint);
            s.draw();
        }
        Segment s = new Segment(endPoint, lastPoint);
        s.draw();
    }
}

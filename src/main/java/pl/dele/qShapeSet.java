package pl.dele;

import java.util.Iterator;
import java.util.Set;

public class qShapeSet {

    private final Set<Point> points;

    public qShapeSet(Set<Point> points) {
            this.points = points;
    }

    public void draw(){
        Iterator<Point> iterator = points.iterator();
        Point firstPoint = iterator.next();
        Point startPoint = null, endPoint = firstPoint;

        while (iterator.hasNext()){
            startPoint = endPoint;
            endPoint = iterator.next();
            Segment s = new Segment(startPoint, endPoint);
            s.draw();
        }

        Segment s = new Segment(endPoint, firstPoint);
        s.draw();
    }

}

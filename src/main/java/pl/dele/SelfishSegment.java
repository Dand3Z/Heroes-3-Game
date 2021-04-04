package pl.dele;

public class SelfishSegment extends Segment {

    public SelfishSegment(Point startPoint, Point endPoint) {
        super(new Point(startPoint), new Point(endPoint));
    }
    // tworzy nowe punkty o takich samych właściwościach jak stare
    // i dopiero je przekazuje do konstruktora Segmentu
}

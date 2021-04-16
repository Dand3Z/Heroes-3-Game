package pl.dele;

public class SelfishSegment extends Segment {

    /**
     * tworzy nowe punkty o takich samych właściwościach jak stare
     * i dopiero je przekazuje do konstruktora Segmentu
     * punkty otrzymane w konstruktorze służą za przepis
     * do utworzenia nowych punktów
      */
    public SelfishSegment(Point startPoint, Point endPoint) {
        super(new Point(startPoint), new Point(endPoint));
    }
}

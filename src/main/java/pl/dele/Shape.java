package pl.dele;

import java.util.List;

public class Shape {

    // == pola ==
    private final List<Point> points;

    // == konstruktory ==
    public Shape(List<Point> aPoints) {
        points = aPoints;
    }

    // == metody ==

    /**
     * Metoda iteruje po liście punktów i tworzy krawędzie między
     * nimi np. dla listy 4-elementowej: 0->1->2->3->0
     */
    void draw(){
        for (int i = 0; i < points.size() - 1; ++i){
            // utwórz nowy segment i go narysuj
            Segment s = new Segment(points.get(i), points.get(i+1));
            s.draw();
        }
        // rysujemy połączenie od ostatniego do pierwszego
        Segment s = new Segment(points.get(points.size() - 1), points.get(0));
        s.draw();
    }

    // implementacja w JavaFX
    // ...
}

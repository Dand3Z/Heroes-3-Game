package pl.dele.gui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class MapTile extends Rectangle{

    public MapTile() {
        super(42,42, Color.WHITE);
        setStroke(Color.BLACK);
    }
}

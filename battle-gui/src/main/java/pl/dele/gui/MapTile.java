package pl.dele.gui;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class MapTile extends StackPane {

    public MapTile() {
        Rectangle rectangle = new Rectangle(42,42, Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        getChildren().add(rectangle);
    }

    void addCreature(String name){
        getChildren().add(new Label(name));
    }
}

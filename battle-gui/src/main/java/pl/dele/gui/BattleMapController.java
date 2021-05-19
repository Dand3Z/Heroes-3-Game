package pl.dele.gui;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BattleMapController {

    @FXML
    private GridPane gripMap;

    @FXML
    void initialize(){
        for(int x = 0; x < 20; ++x)
            for(int y = 0; y < 15; ++y){
                Rectangle rectangle = new Rectangle(42,42, Color.WHITE);
                rectangle.setStroke(Color.BLACK);
                gripMap.add(rectangle,x,y);
            }
    }
}

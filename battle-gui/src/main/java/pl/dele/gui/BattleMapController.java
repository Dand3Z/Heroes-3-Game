package pl.dele.gui;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import pl.dele.Creature;
import pl.dele.GameEngine;

import java.util.ArrayList;
import java.util.List;

public class BattleMapController {

    @FXML
    private GridPane gripMap;

    private final GameEngine gameEngine;

    public BattleMapController() {
        List<Creature> creatures1 = new ArrayList<>();
        creatures1.add(new Creature());
        creatures1.add(new Creature());
        creatures1.add(new Creature());
        List<Creature> creatures2 = new ArrayList<>();
        creatures2.add(new Creature());
        creatures2.add(new Creature());
        creatures2.add(new Creature());
        gameEngine = new GameEngine(creatures1, creatures2);
    }

    @FXML
    void initialize(){
        for(int x = 0; x < 20; ++x)
            for(int y = 0; y < 15; ++y){
                MapTile rectangle = new MapTile();
                gripMap.add(rectangle,x,y);

                Creature c = gameEngine.get(x,y);
                if (c != null){
                    rectangle.addCreature(c.getName());
                }
            }

    }

}

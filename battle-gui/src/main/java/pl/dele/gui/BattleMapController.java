package pl.dele.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import pl.dele.Creature;
import pl.dele.GameEngine;
import pl.dele.Point;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class BattleMapController implements PropertyChangeListener {

    @FXML
    private GridPane gripMap;

    @FXML
    private Button passButton;

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
        gameEngine.addObserver(GameEngine.CURRENT_CREATURE_CHANGED,this);
        gameEngine.addObserver(GameEngine.CREATURE_MOVED,this);

        passButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            gameEngine.pass();
        });

        refreshGui();

    }

    private void refreshGui() {
        for(int x = 0; x < 20; ++x)
            for(int y = 0; y < 15; ++y){
                MapTile mapTile = new MapTile();
                gripMap.add(mapTile,x,y);

                Creature c = gameEngine.get(x,y);
                if (c != null){
                    mapTile.addCreature(c.getName());

                    if (c == gameEngine.getActiveCreature()){
                        mapTile.setBackground(Color.GREEN);
                    }
                }
                else if (gameEngine.canMove(x,y)){
                    final int x1 = x;
                    final int y1 = y;
                    mapTile.setBackground(Color.GREY);
                    mapTile.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
                        gameEngine.move(new Point(x1, y1));
                    });
                }
            }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        refreshGui();
    }
}

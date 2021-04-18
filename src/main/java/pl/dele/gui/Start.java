package pl.dele.gui;

import pl.dele.GameEngine;
import pl.dele.Point;

import java.util.ArrayList;

public class Start {

    public Start() {
        GameEngine game = new GameEngine(new ArrayList<>(), new ArrayList<>());
        game.move(new Point(5,5));
    }
}

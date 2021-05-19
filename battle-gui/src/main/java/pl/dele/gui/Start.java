package pl.dele.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Start extends Application {

    public Start() {
//        GameEngine game = new GameEngine(new ArrayList<>(), new ArrayList<>());
//        game.move(new Point(5,5));
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(FXMLLoader.load(getClass().getClassLoader().getResource("fxml/battleMap.fxml")));

        stage.setScene(scene);
        stage.show();
    }

}

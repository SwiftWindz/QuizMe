package view;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Deck;

public class NoteGame {

    //TODO implement note game
    public Scene noteScene(Stage stage, Deck deck) {

        VBox view = new VBox();

        return  new Scene(view, 750, 500);
    }

}

package view;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Allows the user to start a game
 * @author Phil Ganem
 * @date 10/3/2022
 */
public class StartGame {
    
    public Scene StartGameScene(Stage stage) {
        VBox view = new VBox();
        VBox buttonBox = new VBox();  

        view.getChildren().addAll(buttonBox);
        return new Scene(view, 750, 500);
    }
}

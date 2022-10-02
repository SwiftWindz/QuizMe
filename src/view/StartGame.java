package view;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StartGame {
    
    public Scene StartGameScene(Stage stage) {
        VBox view = new VBox();
        VBox buttonBox = new VBox();  

        return new Scene(view, 750, 500);
    }
}

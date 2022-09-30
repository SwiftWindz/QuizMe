package view;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class StartMenu {

    public Scene StartMenuScene() {
        VBox view = new VBox();

        return new Scene(view, 500, 500);
    }
}

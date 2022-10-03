package view;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Allows the user to delete a deck
 * @author Phil Ganem
 * @date 10/3/2022
 */
public class DeleteDeck {
    
    public Scene DeleteDeckScene(Stage stage) {
        VBox view = new VBox();
        VBox buttonBox = new VBox();  

        //lists all decks in data directory
        
        //button to delete deck

        //button to return to main menu

        return new Scene(view, 750, 500);
    }

}
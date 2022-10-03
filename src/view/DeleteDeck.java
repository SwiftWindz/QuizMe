package view;

import java.io.File;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import controller.DeleteDeckAction;

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
        File folder = new File("data");
        File[] listOfFiles = folder.listFiles();
        
        for(File file : listOfFiles) {
            if(file.isFile()) {
                HBox deckBox = new HBox();
                String fileName = file.getName();
                fileName = fileName.substring(0, fileName.length() - 4);
                Button deleteDeck = new Button("Delete");
                deleteDeck.setOnAction((e) -> {
                    //gets file name without .csv
                    DeleteDeckAction deleteDeckAction = new DeleteDeckAction(file.getName());
                    deleteDeckAction.execute();
                    stage.setScene(DeleteDeckScene(stage));
                });
                deckBox.getChildren().addAll(new Label(fileName), deleteDeck);
                buttonBox.getChildren().add(deckBox);
            }
        }
        

        //button to return to main menu
        Button back = new Button("Back");
        back.setOnAction((e) -> {
            MainMenu mainMenu = new MainMenu();
            stage.setScene(mainMenu.MainMenuScene(stage));
        });

        buttonBox.getChildren().add(back);
        view.getChildren().addAll(buttonBox);
        return new Scene(view, 750, 500);
    }

}
package view;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Allows the user to navigate to the other scenes
 * @author Phil Ganem
 * @date 10/3/2022
 */
public class MainMenu {

    public Scene MainMenuScene(Stage stage) {
        VBox view = new VBox();
        VBox buttonBox = new VBox();  

        view.setStyle("-fx-background-color: #fcc332;");
        buttonBox.setStyle("-fx-alignment: center;" +
        "-fx-spacing: 25px;" +
        "-fx-padding: 50px;" +
        "-fx-color: #000000;" +
        "-fx-font-size: 40px;");

        Button startAGame = new Button("Play a Game");
        startAGame.setOnAction((e) -> {
            StartGame startGame = new StartGame();
            stage.setScene(startGame.StartGameScene(stage));
        });
        Button createADeck = new Button("Create a Deck");
        createADeck.setOnAction((e) -> {
            CreateDeck createDeck = new CreateDeck();
            stage.setScene(createDeck.CreateDeckScene(stage));
        });
        Button deleteADeck = new Button("Delete a Deck");
        deleteADeck.setOnAction((e) -> {
            DeleteDeck deleteDeck = new DeleteDeck();
            stage.setScene(deleteDeck.DeleteDeckScene(stage));
        });
        Button exit = new Button("Exit");
        exit.setOnAction((e) -> {
            Platform.exit();
        });

        buttonBox.getChildren().addAll(startAGame, createADeck, deleteADeck, exit);
        view.getChildren().addAll(buttonBox);
    
        return new Scene(view, 750, 500);
    }
    
}

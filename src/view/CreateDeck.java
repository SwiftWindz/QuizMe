package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CreateDeck {
    
    public Scene CreateDeckScene(Stage stage) {
        VBox view = new VBox();
        VBox buttonBox = new VBox();
        view.setStyle("-fx-background-color: #fcc332;");
        buttonBox.setStyle("-fx-alignment: center;" +
        "-fx-spacing: 25px;" +
        "-fx-padding: 50px;" +
        "-fx-color: #000000;" +
        "-fx-font-size: 40px;");
        
        HBox deckNameBox = new HBox();
        deckNameBox.setStyle("-fx-alignment: center;" +
        "-fx-spacing: 25px;" +
        "-fx-padding: 50px;" +
        "-fx-color: #000000;");
        TextField deckName = new TextField();
        deckName.setStyle("-fx-font-size: 40px;"+
        "-fx-pref-width: 300px;"+
        "-fx-pref-height: 40px;");

        Label deckNameLabel = new Label("Deck Name");

        deckName.setPromptText("Enter deck name...");
        //button to add submitted deck name 
        Button addDeckName = new Button("Add");
        addDeckName.setOnAction((e) -> {
            if(deckName.getText().equals("")) {
                deckName.setPromptText("Please enter deck name...");
                return;
            }
            CreateDeckCards cardcreate  = new CreateDeckCards();
            stage.setScene(cardcreate.CreateDeckCardsScene(stage, deckName.getText()));

        });

        Button back = new Button("Back");
        back.setOnAction((e) -> {
            MainMenu mainMenu = new MainMenu();
            stage.setScene(mainMenu.MainMenuScene(stage));
        });

        deckNameBox.getChildren().addAll(deckName, addDeckName);
        buttonBox.getChildren().addAll(deckNameLabel, deckNameBox, back);
        view.getChildren().addAll(buttonBox);
        return new Scene(view, 750, 500);
    }
}

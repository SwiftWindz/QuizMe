package view;

import java.util.ArrayList;

import controller.SaveDeck;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Card;
import model.Deck;

public class CreateDeckCards {
    
    public Scene CreateDeckCardsScene(Stage stage, String deckName) {

        Deck deck =  new Deck(new ArrayList<Card>());
        
        VBox view = new VBox();
        VBox buttonBox = new VBox();

        TextField cardAnswer = new TextField();
        TextField cardQuestion = new TextField();
        cardAnswer.setPromptText("Enter card answer...");
        cardQuestion.setPromptText("Enter card question...");
        
        Button addCard = new Button("Add Card");
        addCard.setOnAction((e) -> {
            if(cardAnswer.getText().equals("") || cardQuestion.getText().equals("")) {
                cardAnswer.setPromptText("Please enter card answer...");
                cardQuestion.setPromptText("Please enter card question...");
                return;
            }
            //TODO: add card to deck
        });
        Button save = new Button("Save");
        save.setOnAction((e) -> {
            SaveDeck saveDeck = new SaveDeck(deck, deckName);
            Boolean result = saveDeck.execute();
            if(result) {
                MainMenu mainMenu = new MainMenu();
                stage.setScene(mainMenu.MainMenuScene(stage));
            }
        });
        Button back = new Button("Back");

        Label deckNameLabel = new Label(deckName);    
        view.getChildren().addAll(deckNameLabel, cardAnswer, cardQuestion, addCard, save, back);
        return new Scene(view, 750, 500);
    }
}

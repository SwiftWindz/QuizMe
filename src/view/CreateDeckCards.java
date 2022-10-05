package view;

import java.util.ArrayList;
import controller.SaveDeckAction;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Card;

/**
 * Allows the user to create a deck of cards
 * @author Phil Ganem
 * @date 10/3/2022
 */
public class CreateDeckCards {
    
    /**
     * Creates scene that allows the user to create a deck of cards in a csv file
     * @param deckName
     * @param cards
     * @return
     */
    public Scene CreateDeckCardsScene(Stage stage, String deckName, ArrayList<Card> cardsArg) {

        ArrayList<Card> cards = cardsArg;
        
        VBox view = new VBox();
        VBox buttonBox = new VBox();

        //Title
        Label deckNameLabel = new Label(deckName);    

        //Card answer and question input
        VBox cardBox = new VBox();
        TextField cardAnswer = new TextField();
        TextField cardQuestion = new TextField();
        cardAnswer.setPromptText("Enter card answer...");
        cardQuestion.setPromptText("Enter card question...");
        
        //Submit card to deck
        Button addCard = new Button("Add Card");
        addCard.setOnAction((e) -> {
            if(cardAnswer.getText().equals("") || cardQuestion.getText().equals("")) {
                cardAnswer.setPromptText("Please enter card answer...");
                cardQuestion.setPromptText("Please enter card question...");
                return;
            }
            Card card = new Card(cardAnswer.getText(), cardQuestion.getText(), cards.size() + 1);
            cards.add(card);
            cardAnswer.clear();
            cardQuestion.clear();
        });

        //Save deck and return to main menu
        Button save = new Button("Save");
        save.setOnAction((e) -> {
            SaveDeckAction saveDeck = new SaveDeckAction(cards, deckName);
            Boolean result = saveDeck.execute();
            if(result) {
                MainMenu mainMenu = new MainMenu();
                stage.setScene(mainMenu.MainMenuScene(stage));
            }
        });

        //views the current deck
        Button viewDeck = new Button("View Deck");
        viewDeck.setOnAction((e) -> {
            ViewDeck viewDeckScene = new ViewDeck();
            stage.setScene(viewDeckScene.ViewDeckScene(stage, cards, deckName));
        });

        //Return to main menu without saving
        Button back = new Button("Back");
        back.setOnAction((e) -> {
            MainMenu mainMenu = new MainMenu();
            stage.setScene(mainMenu.MainMenuScene(stage));
        });

        //Add all elements to view
        cardBox.getChildren().addAll(cardAnswer, cardQuestion);
        buttonBox.getChildren().addAll(addCard, save, viewDeck, back);
        view.getChildren().addAll(deckNameLabel, cardBox, buttonBox);
        return new Scene(view, 750, 500);
    }
}

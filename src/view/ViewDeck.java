package view;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Card;

/**
 * Allows the user to view and edit the deck during deck creation
 * @author Phil Ganem
 * @date 10/3/2022
 */
public class ViewDeck {

    /**
     * Allows the user to edit added cards
     * @param cardIndex
     * @return
     */
    public Button editCard(Card cardIndex){
        Button editCard = new Button("Edit");
        editCard.setOnAction((e) -> {
            //TODO display edit card scene
        });
        return editCard;
        
    }

    /**
     * Allows the user to view added cards
     * @param cardIndex
     * @return
     */
    public Scene ViewDeckScene(Stage stage, ArrayList<Card> cardsArg, String deckName) {

        ArrayList<Card> cards = cardsArg;
        
        VBox view = new VBox();
        VBox buttonBox = new VBox();

        //Title
        Label deckNameLabel = new Label(deckName);    

        //show all cards in deck
        //TODO add Delete button
        for(Card card : cards) {
            Label cardLabel = new Label(card.getQuestion());
            Button editCard = editCard(card);
            buttonBox.getChildren().addAll(cardLabel, editCard);
        }
        
        //return to create deck scene
        Button back = new Button("Back");
        back.setOnAction((e) -> {
            CreateDeckCards createDeckCards = new CreateDeckCards();
            stage.setScene(createDeckCards.CreateDeckCardsScene(stage, deckName, cards));
        });

        view.getChildren().addAll(deckNameLabel, buttonBox, back);
        return new Scene(view, 750, 500);
    }

}

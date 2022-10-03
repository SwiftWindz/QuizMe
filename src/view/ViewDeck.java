package view;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Card;

public class ViewDeck {

    public Button editCard(Card cardIndex){
        Button editCard = new Button("Edit");
        editCard.setOnAction((e) -> {
            //TODO display edit card scene
        });
        return editCard;
        
    }

    public Scene ViewDeckScene(Stage stage, ArrayList<Card> cardsArg, String deckName) {

        ArrayList<Card> cards = cardsArg;
        
        VBox view = new VBox();
        VBox buttonBox = new VBox();

        //Title
        Label deckNameLabel = new Label(deckName);    

        //show all cards in deck
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

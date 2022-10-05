package view;

import controller.AnswerCard;
import controller.GetCurrentCard;
import controller.RemoveCardFromDeck;
import controller.ShuffleDeck;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Deck;

/**
 * Allows the user to play a score game
 * @author Phil Ganem
 * @date 10/3/2022
 */
public class ScoreGame {

    public Scene scoreScene(Stage stage, Deck deck, int score) {
        //TODO Style this page
        //Actions on 
        ShuffleDeck shuffleDeck = new ShuffleDeck(deck);
        shuffleDeck.execute();
        GetCurrentCard getCurrentCard = new GetCurrentCard(deck);
        getCurrentCard.execute();
        //Score
        VBox view = new VBox();
        //Exit button
        Button exit = new Button("Exit");
        exit.setOnAction((e) -> {
            stage.setScene(new MainMenu().MainMenuScene(stage));
        });
        //Display score
        Label scoreLabel = new Label("Score: " + score);
        //Display current card
        HBox card = new HBox();
        card.getChildren().addAll(new Label(getCurrentCard.getCurrentCard().getQuestion()), new Label("..."));
        //Textfield for answering
        HBox answer = new HBox();
        TextArea answerField = new TextArea();
        answerField.setText("Enter answer here");
        //Button to submit answer
        Button submit = new Button("Submit");
        //TODO: Show correct answer if wrong
        submit.setOnAction((e) -> {
            AnswerCard answerCard = new AnswerCard(deck, answerField.getText());
            //If answer is correct
            if(answerCard.execute()) {
                RemoveCardFromDeck removeCardFromDeck = new RemoveCardFromDeck(deck, getCurrentCard.getCurrentCard());
                removeCardFromDeck.execute();
                if(deck.getCards().size() != 0) {
                    System.out.println("Correct!");
                    stage.setScene(new ScoreGame().scoreScene(stage, deck, score + 1));
                    return;
                }
            }
            shuffleDeck.execute();
            stage.setScene(new ScoreGame().scoreScene(stage, deck, score));
            return;
        });

        answer.getChildren().addAll(answerField, submit);
        view.getChildren().addAll(scoreLabel, card, answer, exit);
        return  new Scene(view, 750, 500);    
    }

}

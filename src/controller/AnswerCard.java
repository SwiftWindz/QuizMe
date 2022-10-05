package controller;

import model.Deck;
import model.ScoreCard;

public class AnswerCard implements Action {

    // The deck
    private Deck deck;
    // The answer to the current card
    private String answer;

    /**
     * Constructor for LoadDeck
     * @param deck Deck: the deck to be loaded
     */
    public AnswerCard(Deck deck, String answer) {
        this.deck = deck;
        this.answer = answer;
    }

    @Override
    public boolean execute() {
        ScoreCard currentCard = (ScoreCard)deck.getCurrentCard();
        return currentCard.isCorrect(answer);
    }    
}

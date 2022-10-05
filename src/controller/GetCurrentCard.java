package controller;

import model.Card;
import model.Deck;

public class GetCurrentCard implements Action {

    // The deck to be loaded
    private Deck deck;
    // Current card
    private Card currentCard;

    /**
     * Constructor for LoadDeck
     * @param deck Deck: the deck to be loaded
     */
    public GetCurrentCard(Deck deck) {
        this.deck = deck;
    }

    @Override
    public boolean execute() {
        currentCard = deck.getCurrentCard();
        return true;
    }

    /**
     * @return the currentCard
     */
    public Card getCurrentCard() {
        return currentCard;
    }
}

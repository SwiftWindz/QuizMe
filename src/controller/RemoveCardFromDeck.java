package controller;

import model.Card;
import model.Deck;

public class RemoveCardFromDeck implements Action {

    // The deck to be loaded
    private Deck deck;
    // The card to be removed
    private Card card;

    /**
     * Constructor for LoadDeck
     * @param deck Deck: the deck to be loaded
     */
    public RemoveCardFromDeck(Deck deck, Card card) {
        this.deck = deck;
        this.card = card;
    }

    @Override
    public boolean execute() {
        deck.removeCard(card);
        return true;
    }    
}


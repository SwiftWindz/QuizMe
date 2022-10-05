package controller;

import model.Deck;

public class NextCard implements Action {

    // The deck to be loaded
    private Deck deck;

    /**
     * Constructor for LoadDeck
     * @param deck Deck: the deck to be loaded
     */
    public NextCard(Deck deck) {
        this.deck = deck;
    }

    @Override
    public boolean execute() {
        deck.SetNextCard();
        return true;
    }    
}

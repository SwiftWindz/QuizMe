package controller;

import model.Deck;

public class ShuffleDeck implements Action {

    // The deck to be loaded
    private Deck deck;

    /**
     * Constructor for LoadDeck
     * @param deck Deck: the deck to be loaded
     */
    public ShuffleDeck(Deck deck) {
        this.deck = deck;
    }

    @Override
    public boolean execute() {
        deck.shuffle();
        return true;
    }    
}

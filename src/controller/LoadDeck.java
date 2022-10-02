package controller;
import model.Deck;
import model.QuizType;

/**
 * An action that loads a deck from a file
 * @author Phil Ganem
 * @date 9/23/2022
 */
public class LoadDeck implements Action {

    // The deck to be loaded
    private Deck deck;
    // The name of the file to be loaded
    private String fileName;
    // The type of quiz to be loaded
    private QuizType quizType;

    /**
     * Constructor for LoadDeck
     * @param deck Deck: the deck to be loaded
     * @param fileName String: the name of the file to be loaded
     */
    public LoadDeck(Deck deck, QuizType type, String fileName) {
        this.deck = deck;
        this.fileName = fileName;
        this.quizType = type;
    }

    @Override
    public boolean execute() {
        return deck.loadDeck(fileName, quizType);
    }
    
}

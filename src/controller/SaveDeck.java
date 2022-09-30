package controller;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import model.Card;
import model.Deck;

/**
 * Class that takes an array of cards that contain the string contents of cards
 * and saves them to a csv file
 * @author Phil Ganem
 * @date 9/23/2022
 */
public class SaveDeck implements Action {


    // The list of cards to be saved
    private ArrayList<Card> cards;
    private String fileName;

    public SaveDeck(Deck deck, String fileName) {
        this.cards = deck.getCards();
        this.fileName = fileName;
    }

    @Override
    /**
     * Takes an array of cards, creates a csv files, then saves them to the csv file
     */
    public boolean execute() {
        File file = new File("data/" + fileName + ".csv");
        try {
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write("question,answer,id");
            for(Card card : cards){
                writer.write(System.lineSeparator());
                writer.write(card.getQuestion() + "," + card.getAnswer() + "," + card.getID());
            }
            writer.close();
            return true;
        } catch (Exception e) {
            System.err.println("Error saving deck");
            e.printStackTrace();
            return false;
        }        
    }
}

package controller;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import model.Card;

/**
 * Class that takes an array of cards that contain the string contents of cards
 * and saves them to a csv file
 * @author Phil Ganem
 * @date 9/23/2022
 */
public class SaveDeck implements Action {


    private ArrayList<Card> deck;
    private String fileName;

    public SaveDeck(ArrayList<Card> deck, String fileName) {
        this.deck = deck;
        this.fileName = fileName;
    }

    @Override
    /**
     * Takes an array of cards, creates a csv files, then saves them to the csv file
     */
    public void execute() {
        File file = new File("data/" + fileName + ".csv");
        try {
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write("question,answer,id");
            for(Card card : deck){
                writer.write(card.getQuestion() + "," + card.getAnswer() + "," + card.getID());
            }
            writer.close();
        } catch (Exception e) {
        
        }        
    }
}

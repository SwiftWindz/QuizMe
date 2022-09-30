package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Phil Ganem
 * @date 9/23/2022
 */
public class Deck {

    //The card objects that are in the deck
    private ArrayList<Card> cards;
    private QuizType type;

    public Deck(QuizType type){
        this.cards = new ArrayList<Card>();
        this.type = type;
    }

    public Deck(QuizType type, ArrayList<Card> cards){
        this.cards = cards;
        this.type = type;
    }

    /**
     * Takes a csv file and loads the deck with the cards of the correct type
     * @param filename String: the name of the file to load
     */
    public boolean loadDeck(String fileName){
        try (Scanner scanner = new Scanner(new File("data/" + fileName + ".csv"))) {
            scanner.nextLine();
            while(scanner.hasNextLine()){
                String[] line = scanner.nextLine().split(",");
                switch (this.type) {
                    case NOTE:
                        Card newNoteCard = new NoteCard(line[0], line[1], Integer.parseInt(line[2]));
                        this.cards.add(newNoteCard);
                        break;
                    case SCORE:
                        Card newScoreCard = new ScoreCard(line[0], line[1], Integer.parseInt(line[2]));
                        this.cards.add(newScoreCard);
                        break;
                    default:
                        Card newCard = new Card(line[0], line[1], Integer.parseInt(line[2]));
                        this.cards.add(newCard);;
                        break;
                }
            }
            return true;
        } 
        catch (FileNotFoundException e) {
            return false;}
    }

//---------------------------------Getters---------------------------------//

    /**
     * @return the cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * @return the type
     */
    public QuizType getType() {
        return type;
    }

    /**
     * @return the size of the deck
     */
    public int getSize() {
        return this.cards.size();
    }

}
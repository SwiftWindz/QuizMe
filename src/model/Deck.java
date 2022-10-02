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

    public Deck(ArrayList<Card> cards){
        this.cards = cards;
    }

    /**
     * Takes a csv file and loads the deck with the cards of the correct type
     * @param filename String: the name of the file to load
     */
    public boolean loadDeck(String fileName, QuizType type){
        try (Scanner scanner = new Scanner(new File("data/" + fileName + ".csv"))) {
            scanner.nextLine();
            while(scanner.hasNextLine()){
                String[] line = scanner.nextLine().split(",");
                switch (type) {
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

    /**
     * Takes deck and shuffles the cards
     */
    public void shuffle(){
        for(int i = 0; i < this.cards.size(); i++){
            int randomIndex = (int)(Math.random() * this.cards.size());
            Card temp = this.cards.get(i);
            this.cards.set(i, this.cards.get(randomIndex));
            this.cards.set(randomIndex, temp);
        }
    }

    /**
     * Gets a card at an index
     * @return Card: the card at the index
     */
    public Card getCard(int index){
        return this.cards.get(index);
    }

    /**
     * Checks if the deck is empty
     * @return boolean: true if the deck is empty, false otherwise
     */
    public boolean isEmpty(){
        return this.cards.isEmpty();
    }

    /**
     * Removes a card from the deck
     * @param card Card: the card to be removed
     */
    public void removeCard(Card card){
        this.cards.remove(card);
    }

//---------------------------------Getters---------------------------------//

    /**
     * @return the cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * @return the size of the deck
     */
    public int getSize() {
        return this.cards.size();
    }

}
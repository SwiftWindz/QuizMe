package model;

/**
 * @author Phil Ganem
 * @date 9/23/2022
 *
 */
public class NoteCard extends Card {

    //Whether or not the user has flipped the card
    private boolean flipped;

    /**
     * Constructor for NoteCard
     * @param question 
     * @param answer
     * @param id
     */
    public NoteCard(String question, String answer, int id) {
        super(question, answer, id);
        this.flipped = false;
    }
    
    /**
     * Flips the card
     */
    public void flip(){this.flipped = !this.flipped;}
}

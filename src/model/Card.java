package model;

/**
* @author Phil Ganem
* @date 9/23/2022
*/
public class Card {

    //The question the system will ask when the user gets to this card
    private String question;
    //The answer to the question
    private String answer;
    //The ID of this card relative to the deck
    private int id;

    /**
     * Constructor for Card
     * @param question String: the question
     * @param answer String: the answer
     * @param id int: the ID of the card
     */
    public Card(String question, String answer, int id) {
        this.question = question;
        this.answer = answer;
        this.id = id;
    }

    /**
     * Receives the answer to the question
     * @return String: the answer to the question
     */
    public String getAnswer(){return answer;}
    /**
     * Receives the question
     * @return String: the question
     */
    public String getQuestion(){return question;}
    /**
     * Receives the ID of the card
     * @return int: the ID of the card
     */
    public int getID(){return id;}

    @Override
    public String toString() {
        return "Card [answer=" + answer + ", id=" + id + ", question=" + question + "]";
    }

}

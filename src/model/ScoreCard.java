package model;

/**
 * @author Phil Ganem
 * @date 9/23/2022
 */
public class ScoreCard extends Card {

    //Whether or not the user has answered this card
    private boolean answered;

    public ScoreCard(String question, String answer, int id) {
        super(question, answer, id);
        this.answered = false;
    }

    /**
     * Checks to see if the user provided answer is equal to that of the 'answer'
     * on field on the card.
     * @param answer String: the user's answer
     * @return boolean: true if the answer is correct, false otherwise
     */
    public boolean isCorrect(String answer){ 
        if(answer.equals(this.getAnswer())){
            this.answered = true;
            return true;
        }
        return false;
    }

// ------------------ GETTERS AND SETTERS ------------------ //    

    public boolean getAnswered(){return answered;}
    
}

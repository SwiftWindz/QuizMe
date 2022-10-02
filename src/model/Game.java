package model;

/**
 * @author Phil Ganem
 * @date 9/23/2022
 *
 */
public class Game {
    
    //Current card
    int currentCard;
    //quiz type
    QuizType quizType;
    
    public Game(QuizType quizType) {
        this.quizType = quizType;
        this.currentCard = 0;
    }
}
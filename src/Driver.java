
import view.GUI;

/**
* Driver for program
* @Author: Phil Ganem
* @Date: 9/23/2022
*/
public class Driver {

    // public void ScoreGameTest(){
    //     Scanner scanner = new Scanner(System.in);
    //     int round = 0;
        
    //     //score game
    //     Deck deck = new Deck(new ArrayList<Card>());
    //     deck.loadDeck("test", QuizType.SCORE);
    //     ArrayList<Card> remove = new ArrayList<Card>();
    //     while (!deck.isEmpty()){
    //         if (remove.size() > 0){
    //             for (Card card : remove){deck.removeCard(card);}
    //             remove.clear();
    //         }
    //         System.out.println("Round: " + round);
    //         System.out.println("Cards left: " + deck.getSize());
    //         deck.shuffle();
    //         for (Card card : deck.getCards()) {
    //             ScoreCard bingus = (ScoreCard) card;
    //             System.out.println(card.getQuestion());
    //             System.out.println("Answer: ");
    //             String userAnswer = scanner.nextLine();
    //             Boolean correct = bingus.isCorrect(userAnswer);
    //             if(!correct){
    //                 System.out.println("Incorrect");
    //                 System.out.println("Correct answer: " + card.getAnswer());
    //                 continue;
    //             }
    //             System.out.println("Correct");
    //             remove.add(card);
    //         }   
    //     }
    //     scanner.close();
    // }

    /**
     * Runs the program
     */
    public static void main(String[] args){
        
        //score game
        // Driver driver = new Driver();
        // driver.ScoreGameTest();

        //GUI
        GUI.launch(GUI.class);
    }
}
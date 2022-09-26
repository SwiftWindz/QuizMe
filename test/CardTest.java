package test;
import model.Card;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.*;

public class CardTest {

    @Test
    /**
     * Tests the constructor of Card
     */
    public void testCardInit(){
        //Init 
        Card card = new Card("Who is the best?", "Phil", 1);
        //Analyze
        String actualQuestion = card.getQuestion();
        String actualAnswer = card.getAnswer();
        int actualID = card.getID();
        String expectedQuestion = "Who is the best?";
        String expectedAnswer = "Phil";
        int expectedID = 1;
        //Assert
        assertEquals(actualQuestion, expectedQuestion);
        assertEquals(actualAnswer, expectedAnswer);
        assertEquals(actualID, expectedID);

    }
    
}

package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.*;

import model.Deck;

public class DeckTest {

    @Test
    /**
     * Tests the constructor of Deck
     */
    public void testDeckInit(){
        //Init 
        Deck deck = new Deck(null);
        //Analyze
        int actual = deck.getSize();
        //Assert
        assertEquals(0, actual);
    }
}

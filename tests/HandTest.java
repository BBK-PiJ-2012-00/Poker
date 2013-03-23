/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import code.Hand;
import code.FiveCardHand;
import code.Card;
import code.CardImpl;
import code.Deck;
import code.DeckImpl;

/**
 * @author Anna Taylor
 *
 */
public class HandTest {
	

	@Test
	public void testGetContents() {
		Hand testHand = new FiveCardHand();
		Card[] contents = testHand.getContents();
		assertNotNull(contents);
		
	}
	
	@Test
	public void testGetContents2() {
		Hand testHand = new FiveCardHand();
		Card[] contents = testHand.getContents();
		int expectedSize = 5;
		int actualSize = contents.length;
		assertEquals("Problem with handContents initialisation", expectedSize, actualSize);
	}
	
	@Test
	public void testGetContents3()	{
		Hand testHand = new FiveCardHand();
		Card[] contents = testHand.getContents();
		assertNull(contents[0]); //handContents should be an empty array upon creation.
	}
	
	//Test addCard()
	//Test displayHand()
	
	@Test
	public void testSort() {
		Hand testHand = new FiveCardHand();
		Deck testDeck = new DeckImpl();
		testDeck.shuffleCards();
		for (int i = 0; i < 5; i++) {
			testHand.addCard(testDeck.popCard());
		}
		testHand.sort();
		System.out.println(testHand.displayHand());
	}

}

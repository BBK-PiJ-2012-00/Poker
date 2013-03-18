/**
 * 
 */
package tests;

import static org.junit.Assert.*;


import org.junit.Test;

import code.Card;
import code.CardImpl;

/**
 * @author Anna Taylor
 *
 */
public class CardTest {
	
	@Test
	public void test() {
		String expectedSuit = "D";
		Card card = new CardImpl(1, expectedSuit);
		String outputSuit = card.getSuit();
		
		assertEquals("Problem with getSuit()", expectedSuit, outputSuit);		
	}
	
	@Test
	public void test2() {
		int expectedRank = 1;
		Card card = new CardImpl(expectedRank, "D");
		int outputRank = card.getRank();
		
		assertEquals("Problem with getRank()", expectedRank, outputRank);		
	}

}

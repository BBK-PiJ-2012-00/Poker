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
		int expectedRank = 1;
		Card card = new CardImpl(1, "D");
		String outputSuit = "F";
		
		assertEquals("Problem with getSuit()", expectedSuit, outputSuit);		
	}
	
	@Test
	public void test2() {
		
	}

}

/**
 * 
 */
package tests;

import static org.junit.Assert.*;


import org.junit.Test;

import code.Card;
import code.CardImpl;
import code.Suit;
import code.Rank;

/**
 * @author Anna Taylor
 *
 */
public class CardTest {
	
	@Test
	public void testGetSuit() {
		Suit expectedSuit = Suit.HEARTS;
		Card card = new CardImpl(Rank.ACE, expectedSuit);
		Suit outputSuit = card.getSuit();
		
		assertEquals("Problem with getSuit()", expectedSuit, outputSuit);		
	}
	
	@Test
	public void testGetRank() {
		Rank expectedRank = Rank.ACE;
		Card card = new CardImpl(expectedRank, Suit.SPADES);
		Rank outputRank = card.getRank();
		
		assertEquals("Problem with getRank()", expectedRank, outputRank);		
	}
	
	@Test
	public void testToString() {
		Card card = new CardImpl(Rank.TWO, Suit.HEARTS);
		String output = card.toString();
		String expected = "[Two Hearts]";
		
		assertEquals("Problem with toString()", expected, output);
	}
	
	@Test
	public void testToString2() {
		Card card = new CardImpl(Rank.JACK, Suit.CLUBS);
		String output = card.toString();
		String expected = "[Jack Clubs]";
		
		assertEquals("Problem with toString()", expected, output);
	}
	
	
	//Don't forget to test comparing cards to one another once class implements Comparable; overriding
	//equals() and compareTo().

}

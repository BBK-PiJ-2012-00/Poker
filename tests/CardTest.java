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
	public void test() {
		Suit expectedSuit = Suit.HEARTS;
		Card card = new CardImpl(Rank.ACE, expectedSuit);
		Suit outputSuit = card.getSuit();
		
		assertEquals("Problem with getSuit()", expectedSuit, outputSuit);		
	}
	
	@Test
	public void test2() {
		int expectedRank = Rank.ACE.getValue();
		Card card = new CardImpl(expectedRank, "D");
		int outputRank = card.getRank();
		
		assertEquals("Problem with getRank()", expectedRank, outputRank);		
	}
	
	@Test
	public void test3() {
		Card card = new CardImpl(1,"D");
		String output = card.toString();
		String expected = "[AD]";
		
		assertEquals("Problem with toString()", expected, output);
	}
	
	@Test
	public void test4() {
		Card card = new CardImpl(11,"S");
		String output = card.toString();
		String expected = "[JS]";
		
		assertEquals("Problem with toString()", expected, output);
	}
	
	@Test
	public void test5() {
		Card card = new CardImpl(12,"H");
		String output = card.toString();
		String expected = "[QH]";
		
		assertEquals("Problem with toString()", expected, output);
	}
	
	@Test 
	public void test6() {
		Card card = new CardImpl(13,"C");
		String output = card.toString();
		String expected = "[KC]";
		
		assertEquals("Problem with toString()", expected, output);
	}
	
	//Don't forget to test comparing cards to one another once class implements Comparable; overriding
	//equals() and compareTo().

}

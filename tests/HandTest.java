/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Hand;
import code.FiveCardHand;
import code.Card;
import code.CardImpl;
import code.Deck;
import code.DeckImpl;
import code.Rank;
import code.Suit;

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
	
	@Test
	public void testAddCard() {
		Hand testHand = new FiveCardHand();
		for (int i = 0; i < 5; i++) {
			Card c = new CardImpl(Rank.values()[i], Suit.values()[0]);
			testHand.addCard(c);
			assertEquals(c, testHand.getContents()[i]);//Tests that each card was in fact added to the hand.
		}		
	}
	
	@Test
	public void testDisplayHand() {
		Hand testHand = new FiveCardHand();
		for (int i = 0; i < 5; i++) {
			Card c = new CardImpl(Rank.values()[i], Suit.values()[0]);
			testHand.addCard(c);
		}
		String expected = "[Ace Clubs] [Two Clubs] [Three Clubs] [Four Clubs] [Five Clubs] ";
		String output = testHand.displayHand();
		assertEquals(expected, output);
	}
	
	@Test
	public void testSort() {
		Hand testHand = new FiveCardHand();
		Deck testDeck = new DeckImpl();
		testDeck.shuffleCards();
		for (int i = 0; i < 5; i++) {
			testHand.addCard(testDeck.popCard());
		}
		testHand.sort();
		boolean sorted = true;
		for (int i = 0; i < 4; i++) {
			if (testHand.getContents()[i].getRankValue() > testHand.getContents()[i+1].getRankValue()) {
				sorted = false; //If next card is less than current card (i.e. they're not sorted)
			}
		}
		assertTrue(sorted);
		
	}
	
	@Test
	public void testEvaluateFourOfAKind() {//Tests for first four cards being four of a kind
		Hand testHand = new FiveCardHand();
		for (int i = 0; i < 4; i++) {
			Card c = new CardImpl(Rank.TWO, Suit.values()[i]);
			testHand.addCard(c);
		}
		Card c = new CardImpl(Rank.SEVEN, Suit.HEARTS);
		testHand.addCard(c);
		testHand.evaluateHand();
		String expectedValue = "Four of a Kind";
		String outputValue = testHand.getHandValue();
		assertEquals(expectedValue, outputValue);
	}
	
	@Test
	public void testEvaluateFourOfAKind2() {//Tests for last four cards being four of a kind
		Hand testHand = new FiveCardHand();
		Card firstCard = new CardImpl(Rank.SEVEN, Suit.HEARTS);
		testHand.addCard(firstCard);
		for (int i = 0; i < 4; i++) {
			Card c = new CardImpl(Rank.TWO, Suit.values()[i]);
			testHand.addCard(c);
		}
		testHand.evaluateHand();
		String expectedValue = "Four of a Kind";
		String outputValue = testHand.getHandValue();
		assertEquals(expectedValue, outputValue);
	}
	
	@Test
	public void testEvaluateFourOfAKindFalse() {//Tests that four of a kind value is not wrongly assigned to borderline case
		Hand testHand = new FiveCardHand();
		Card firstCard = new CardImpl(Rank.SEVEN, Suit.HEARTS);
		testHand.addCard(firstCard);
		Card secondCard = new CardImpl(Rank.SIX, Suit.SPADES);
		testHand.addCard(secondCard);
		for (int i = 0; i < 3; i++) {
			Card c = new CardImpl(Rank.TWO, Suit.values()[i]);
			testHand.addCard(c);
		}
		testHand.evaluateHand();
		String outputValue = testHand.getHandValue();
		assertNull(outputValue);//As no other hands have been implemented yet, handValue should be null if not four of a kind
	}
	
	@Test
	public void testEvaluateFlush() { //Tests that a flush is picked up by evaluateHand();
		Hand testHand = new FiveCardHand();
		for (int i = 0; i < 5; i++) {
			Card c = new CardImpl(Rank.values()[i], Suit.HEARTS);
			testHand.addCard(c);
		}
		testHand.evaluateHand();
		String outputValue = testHand.getHandValue();
		String expectedValue = "Flush";
		assertEquals(expectedValue, outputValue);
		
	}
	
	@Test
	public void testEvaluateFlushFalse() { //Tests a borderline case where four cards have the same suit
		Hand testHand = new FiveCardHand();
		for (int i = 0; i < 4; i++) {
			Card c = new CardImpl(Rank.values()[i], Suit.HEARTS);
			testHand.addCard(c);
		}
		Card c = new CardImpl(Rank.values()[2], Suit.DIAMONDS);
		testHand.addCard(c);
		testHand.evaluateHand();
		String outputValue = testHand.getHandValue();
		assertNull(outputValue); //If flush or four of a kind are not found at this stage, handValue is null.
		
	}

}

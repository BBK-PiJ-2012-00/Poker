/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import code.Deck;
import code.DeckImpl;
import code.Card;
import code.CardImpl;
import code.Rank;
import code.Suit;

/**
 * @author Anna Taylor
 *
 */
public class DeckTest {

	@Test
	public void testCreateCards() { //Checks that 52 cards are created
		Deck testDeck = new DeckImpl();
		int expectedDeckSize = 52;
		int outputDeckSize = testDeck.getContents().size();
		
		assertEquals("Problem with createCards()", expectedDeckSize, outputDeckSize);
	}
	
	@Test
	public void testGetContents() {
		Deck testDeck = new DeckImpl();
		List<Card> output = testDeck.getContents();
		
		assertNotNull(output);
	}
	
	@Test
	public void testCardsCreatedClubs()	{ //Tests that all club cards are contained in the deck
		Deck testDeck = new DeckImpl();
		String[] clubs = new String[13];
		for (int i = 0; i < 13; i++) { //Creates array of clubs, for comparison with clubs created by the deck
			Card c = new CardImpl(Rank.values()[i], Suit.CLUBS);
			clubs[i] = c.toString();
		}
		int k = 0;//Corresponds to clubs array index value
		for (int j = 0; j < 13; j++) {
			assertEquals("Problem with createCards()", clubs[k], testDeck.getContents().get(j).toString());
			k++;
		}
	}
	
	@Test
	public void testCardsCreatedSpades() { //Tests that all spade cards are contained in the deck
		Deck testDeck = new DeckImpl();
		String[] spades = new String[13];
		for (int i = 0; i < 13; i++) {
			Card c = new CardImpl(Rank.values()[i], Suit.SPADES);
			spades[i] = c.toString();
		}
		int k = 0;//Corresponds to spades array index value
		for (int j = 13; j < 26; j++) {
			assertEquals("Problem with createCards()", spades[k], testDeck.getContents().get(j).toString());
			k++;
		}
	}
	
	@Test
	public void testCardsCreatedHearts() { //Tests that all heart cards are contained in the deck
		Deck testDeck = new DeckImpl();
		String[] hearts = new String[13];
		for (int i = 0; i < 13; i++) {
			Card c = new CardImpl(Rank.values()[i], Suit.HEARTS);
			hearts[i] = c.toString();
		}
		int k = 0;//Corresponds to hearts array index value
		for (int j = 26; j < 39; j++) {
			assertEquals("Problem with createCards()", hearts[k], testDeck.getContents().get(j).toString());
			k++;
		}
	}
	
	@Test
	public void testCardsCreatedDiamonds() { //Tests that all diamond cards are contained in the deck
		Deck testDeck = new DeckImpl();
		String[] diamonds = new String[13];
		for (int i = 0; i < 13; i++) {
			Card c = new CardImpl(Rank.values()[i], Suit.DIAMONDS);
			diamonds[i] = c.toString();
		}
		int k = 0;//Corresponds to diamonds array index value
		for (int j = 39; j < 52; j++) {
			assertEquals("Problem with createCards()", diamonds[k], testDeck.getContents().get(j).toString());
			k++;
		}
	}
	

}

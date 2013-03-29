/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import code.Card;
import code.CardImpl;
import code.DealerPlayer;
import code.HandComparator;
import code.HandComparatorImpl;
import code.HumanPlayer;
import code.Player;
import code.Rank;
import code.Suit;

/**
 * @author Anna Taylor
 *
 */
public class HandComparatorTest {
	private HandComparator testComparator;
	private Player humanPlayer;
	private Player dealerPlayer;
	
	//Extra cards
	private Card twoD;
	private Card eightS;
	private Card kingC;
	
	@Before
	public void setUp() {
		testComparator = new HandComparatorImpl();
		humanPlayer = new HumanPlayer("Dummy");
		dealerPlayer = new DealerPlayer();
		
		twoD = new CardImpl(Rank.TWO, Suit.DIAMONDS);
		eightS = new CardImpl(Rank.EIGHT, Suit.SPADES);
		kingC = new CardImpl(Rank.KING, Suit.CLUBS);
	}

	/**
	 * Not necessary to test all combinations of hands because we know from HandTest that different
	 * hands are compared correctly. What matters is that a better hand for each player selects the
	 * correct winner/
	 */
	@Test
	public void testCompareHandsHumanPlayerWins() { //Tests a better hand wins for the HumanPlayer
		for (int i = 0; i < 4; i++) {
			Card c = new CardImpl(Rank.ACE, Suit.values()[i]); //Creates quads
			humanPlayer.receiveCard(c);
		}
		humanPlayer.receiveCard(twoD);
		
		for (int i = 0; i < 3; i++) { //Creates trips
			Card c = new CardImpl(Rank.TEN, Suit.values()[i]);
			dealerPlayer.receiveCard(c);
		}
		dealerPlayer.receiveCard(eightS);
		dealerPlayer.receiveCard(kingC);
		
		humanPlayer.getHand().evaluateHand();
		dealerPlayer.getHand().evaluateHand();		
		testComparator.compareHands(humanPlayer, dealerPlayer);
		
		String output = testComparator.getResult();
		String expected = "Congratulations! You have won the hand!"; //This is the result String if HumanPlayer wins
		assertEquals(expected, output);		
	}
	
	@Test
	public void testCompareHandsDealerWins() { //Tests a better hands wins for DealerPlayer
		for (int i = 0; i < 5; i++) {
			Card c = new CardImpl(Rank.values()[i], Suit.HEARTS); //Creates a flush
			dealerPlayer.receiveCard(c);
		}
		
		for (int i = 0; i < 2; i++) { //Creates a pair
			Card c = new CardImpl(Rank.TEN, Suit.values()[i]);
			humanPlayer.receiveCard(c);
		}
		for (int i = 0; i < 2; i++) {
			Card c = new CardImpl(Rank.JACK, Suit.values()[i]); //Creats another pair for Two Pair
			humanPlayer.receiveCard(c);
		}
		humanPlayer.receiveCard(twoD); //Kicker
		
		humanPlayer.getHand().evaluateHand();
		dealerPlayer.getHand().evaluateHand();
		testComparator.compareHands(humanPlayer, dealerPlayer);
		
		String output = testComparator.getResult();
		String expected = "The computer has won the hand! Better luck next time!"; //Result String if DealerPlayer wins
		assertEquals(expected, output);
	}
	
	//Now to test for equal hands

}

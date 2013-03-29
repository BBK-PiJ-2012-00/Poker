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

	@Test
	public void compareHandsBetterHandWins() { //Tests a better hand wins
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
		
		//humanPlayer should win
	}

}

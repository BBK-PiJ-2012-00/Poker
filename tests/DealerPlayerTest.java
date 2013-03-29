/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Card;
import code.CardImpl;
import code.DealerPlayer;
import code.Hand;
import code.Player;
import code.Rank;
import code.Suit;


/**
 * @author Anna Taylor
 *
 */
public class DealerPlayerTest {

	@Test
	public void testGetName() {
		Player player = new DealerPlayer();
		String outputName = player.getName();
		assertNotNull(outputName);
	}
	
	@Test
	public void testDealerPickerRandom() { //Test that the random number generated is between 0 and 9 (inclusive)
		for (int i = 0; i < 1000; i++) { //Test plenty of times to be sure
			int dealerRef = (int) (Math.random() * 10); //This is the exact code used in the method (not externally accessible)
			assertTrue(dealerRef >= 0 && dealerRef < 10);
			System.out.println(dealerRef);
		}		
	}
	
	@Test
	public void testDealerPicker() { //Tests that dealerPicker assigns a name upon construction
		Player testPlayer = new DealerPlayer();
		String output = testPlayer.getName();
		assertNotNull(output);
	}
	
	/**
     * Test of receiveCard method, of class DealerPlayer.
     */
    @Test
    public void testReceiveCard() {
    	Player testPlayer = new DealerPlayer();
        Card c = new CardImpl(Rank.TWO, Suit.CLUBS);
        testPlayer.receiveCard(c);
        Card receivedCard = testPlayer.getHand().getContents()[0];
        assertEquals(receivedCard, c); //Checks that the card was assigned to the hand via receiveCard()     
    }

    /**
     * Test of getHand method, of class DealerPlayer.
     */
    @Test
    public void testGetHand() {
        System.out.println("getHand");
        DealerPlayer instance = null;
        Hand expResult = null;
        Hand result = instance.getHand();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of chooseDiscard method, of class DealerPlayer.
     */
    @Test
    public void testChooseDiscard() {  // this tests that correct number of cards are discarded depending on the hand
        System.out.println("Testing chooseDiscard"); // and that the positions the cards should have been removed from
        Player instance = new DealerPlayer(); //no longer contain those cards
        Card aceH = new CardImpl(Rank.ACE, Suit.HEARTS);
        Card aceS = new CardImpl(Rank.ACE, Suit.SPADES);
        Card jackS = new CardImpl(Rank.JACK, Suit.SPADES);
        Card nineC = new CardImpl(Rank.NINE, Suit.CLUBS);
        Card twoD = new CardImpl(Rank.TWO, Suit.DIAMONDS);
        instance.receiveCard(aceS);
        instance.receiveCard(aceH);
        instance.receiveCard(jackS);
        instance.receiveCard(nineC);
        instance.receiveCard(twoD);
        instance.getHand().evaluateHand();
        int actualPairDiscard = instance.chooseDiscard();
        int expectedPairDiscard = 3;
        assertEquals(actualPairDiscard, expectedPairDiscard);
        assertFalse(instance.getHand().getContents()[0].equals(twoD));
        assertFalse(instance.getHand().getContents()[1].equals(nineC));
        assertFalse(instance.getHand().getContents()[2].equals(jackS)); //this first section is for a one pair hand
        
        instance.getHand().clearHand();
        Card jackD = new CardImpl(Rank.JACK, Suit.DIAMONDS);
        instance.receiveCard(jackD);
        instance.receiveCard(aceH);
        instance.receiveCard(aceS);
        instance.receiveCard(jackS);
        instance.receiveCard(twoD);
        instance.getHand().evaluateHand();
        int actualTwoPairDiscard = instance.chooseDiscard();
        int expectedTwoPairDiscard = 1;
        assertEquals(actualTwoPairDiscard, expectedTwoPairDiscard);
        assertFalse(instance.getHand().getContents()[0].equals(twoD)); //this sections is for a two pair hand
        
        
        instance.getHand().clearHand();
        Card aceD = new CardImpl(Rank.ACE, Suit.DIAMONDS);
        instance.receiveCard(aceD);
        instance.receiveCard(aceH);
        instance.receiveCard(aceS);
        instance.receiveCard(jackS);
        instance.receiveCard(twoD);
        instance.getHand().evaluateHand();
        int actualTripsDiscard = instance.chooseDiscard();
        int expectedTripsDiscard = 2;
        assertEquals(actualTripsDiscard, expectedTripsDiscard);
        assertFalse(instance.getHand().getContents()[0].equals(twoD));
        assertFalse(instance.getHand().getContents()[1].equals(jackS)); //this section is for a trips hand
        
        
        
        
        
    }
}

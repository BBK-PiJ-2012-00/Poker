/**
 * 
 */
package code;

import java.util.Arrays;


/**
 * @author Anna Taylor
 *
 */
public class FiveCardHand implements Hand {
	private String handValue; 
	private int handValueScore; //The numerical score associated with a hand
	int processingValue = 0; //For use evaluating which cards to keep when discarding from dealer's hand
	
	private static final int SIZE = 5;
	private Card[] handContents = new CardImpl[SIZE];
	
	
	@Override
	public Card[] getContents() {
		return handContents;
	}

	
	@Override
	public void addCard(Card c) {
		try {
			for(int i = 0; i < 5; i++) {
                if(handContents[i] == null){
                    handContents[i] = c;
                    break;
                }
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("(!) Attempting to add more cards to a hand than is allowed.");
		}		
	}


	@Override
	public void discardCard(int index) {
		handContents[index - 1] = null;
		return;
	}

	
	
	public void sort() {
		Arrays.sort(handContents);		
	}


	
	@Override
	public void evaluateHand() { //Should perhaps return a String so that this can be called directly
		//First sort the hand; this makes it easier to evaluate
		this.sort();
		
		//Check for four of a kind
		boolean fourOfAKind = true;
		for (int i = 0; i < 3; i++) { //Test the first four cards
			if (handContents[i].getRankValue() != handContents[i+1].getRankValue()) {
				fourOfAKind = false;
				break;
			}
		}
		if (fourOfAKind) {
			handValue = "Four of a Kind";
			processingValue = 5;
			return; //Don't test any further once a handValue is found
		}
		
		fourOfAKind = true; //Reset the value here for the benefit of the next test
		for (int i = 1; i < 4; i++) { //Test the last four cards
			if (handContents[i].getRankValue() != handContents[i+1].getRankValue()) {
				fourOfAKind = false;
				break;
			}
		}
		
		if (fourOfAKind) {
			handValue = "Four of a Kind";
			processingValue = 5;
			return; //Don't test for any other handValues if Four of a Kind is found
		}
		
		//Test for flush (only reachable if fourOfAKind is false)
		boolean flush = true;
		for (int i = 0; i < 4; i++) {
			if (handContents[i].getSuit() != handContents[i+1].getSuit()) {
				flush = false;
				break; //Stop testing for flush as soon as 
			}
		}
		if (flush) {
			handValue = "Flush";
			processingValue = 5;
			return; //Don't test for any other handValues if a Flush is found
		}
		
		//Test for Straight (only reachable if fourOfAKind and flush are false)
		boolean straight = true;
		//Test first for the case where Ace can be low 
		if ((handContents[4].getRankValue() == 14) && (handContents[3].getRankValue() == 5)) { 
			//If the highest card in the hand is Ace and a 5 is preceding, test for straight where Ace would be low
			for (int i = 2; i > -1; i--) {
				if (handContents[i].getRankValue() != (handContents[i+1].getRankValue() - 1)) {
					straight = false;
				}
			}
			if (straight) {
				handValue = "Straight";
				processingValue = 5;
				return;
			}			
		
		}
		
		//All other possible straight hands tested next (unreachable if another hand has already been found)
		for (int i = 0; i < 4; i++) {
			if (handContents[i].getRankValue() != (handContents[i+1].getRankValue() - 1)) {
				straight = false;
			}
		}
		if (straight) {
			handValue = "Straight";
			processingValue = 5;
			return;
		}
		
		//Test for three of a kind
		boolean threeOfAKind = true;
		for (int i = 0; i < 2; i++) { //Test first three cards
			if (handContents[i].getRankValue() != handContents[i+1].getRankValue()) {
				threeOfAKind = false;
				break;
			}
		}
		if (threeOfAKind) {
			handValue = "Three of a Kind";
			processingValue = 1;
			return;
		}
		
		threeOfAKind = true; //Must be reset here for the next test
		for (int i = 1; i < 3; i++) { //Test middle three cards
			if (handContents[i].getRankValue() != handContents[i+1].getRankValue()) {
				threeOfAKind = false;
				break;
			}
		}
		if (threeOfAKind) {
			handValue = "Three of a Kind";
			processingValue = 2;
			return;
		}
		
		threeOfAKind = true; //Must be reset here for the last test
		for (int i = 2; i < 4; i++) { //Test last three cards
			if (handContents[i].getRankValue() != handContents[i+1].getRankValue()) {
				threeOfAKind = false;
				break;
			}
		}
		if (threeOfAKind) {
			handValue = "Three of a Kind";
			processingValue = 3;
			return;
		}
		
		//Test for Pairs
		boolean onePair = false;
		boolean twoPair = false;
		//The following tests for a pair in the first position (PPXXX), potentially followed by another pair
		if (handContents[0].getRankValue() == handContents[1].getRankValue()) {
			onePair = true;
			processingValue = 1;
			handValue = "One Pair";
			
			if (handContents[2].getRankValue() == handContents[3].getRankValue()) { // This would mean two consecutive pairs at the front end of hand
				twoPair = true;														// PPPPX
				handValue = "Two Pair";
				processingValue = 1;
				return; //Don't test any further
			}
			
			else if (handContents[3].getRankValue() == handContents[4].getRankValue()) { //This means PPXPP formation
				twoPair = true;
				handValue = "Two Pair";
				processingValue = 2;
				return; //Don't test any further
			}
			else if (onePair) {
				return; // Hand is PPXXX
			}				
		}
		
		//The following tests for a pair in the second position (XPPXX), potentially followed by another pair (XPPPP)
		if (handContents[1].getRankValue() == handContents[2].getRankValue()) {
			onePair = true;
			handValue = "One Pair";
			processingValue = 2;
			
			if (handContents[3].getRankValue() == handContents[4].getRankValue()) { //Checks for XPPPP
				twoPair = true;
				handValue = "Two Pair";
				processingValue = 3;
				return; // Don't test any further
			}
			else if (onePair) {
				return; //Hand is XPPXX
			}
		}
		
		//The following tests for a pair in the third position (XXPPX)
		if (handContents[2].getRankValue() == handContents[3].getRankValue()) {
			onePair = true;
			handValue = "One Pair";
			processingValue = 3;
			return; //Don't test any further
		}
		
		//The following tests for a pair in the last position (XXXPP)
		if (handContents[3].getRankValue() == handContents[4].getRankValue()) {
			onePair = true;
			handValue = "One Pair";
			processingValue = 4;
			return; //Don't test any further
		}		
		
		//If no better hand is found, the player has:
		handValue = handContents[4].toString() + " High";
		
	}


	@Override
	public String getHandValue() {
		System.out.println(handValue); //For testing purposes (PENDING REMOVAL)
		return handValue;
	}
	
	@Override
	public int getProcessingValue() {
		return processingValue;
	}


	@Override
	public String displayHand() { //Add card positions to this
		this.sort(); //Hand is easier to deal with if sorted before display
		String handDisplay = "";
		for (int i = 0; i < SIZE; i++) {
			handDisplay += (i+1) + ": " + handContents[i].toString() + "\n";
		}
		return handDisplay;
	}


	@Override
	public int getHandValueScore() {
		return handValueScore;
	}

}

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
	private String handValue; //Should hand values be enums? 
	int processingValue = 0; //For use evaluating which cards to keep when discarding from dealer's hand
	
	private static final int SIZE = 5;
	private Card[] handContents = new CardImpl[SIZE];
	private int availableIndex = 0;
	
	private IllegalArgumentException illegalArgEx = new IllegalArgumentException();
	private ArrayIndexOutOfBoundsException boundsEx = new ArrayIndexOutOfBoundsException();
	
	
	@Override
	public Card[] getContents() {
		return handContents;
	}

	
	@Override
	public void addCard(Card c) {
		try {
			if (availableIndex < 5) {
				handContents[availableIndex] = c;
				availableIndex++;
			}
			else {
				throw boundsEx;
			}						
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("(!) Attempting to add more cards to a hand than is allowed.");
		}		
	}


	@Override
	public void discardCard(Card c) {
		try {
			if (availableIndex > 0) {
				for (int i = 0; i < handContents.length; i++) {
					if (handContents[i] == c) {
						handContents[i] = null;
						this.sort();//Re-sort the hand after card removal, leaving last index(es) free
						availableIndex--;
						return; //If found, remove and exit the method;
					}
				}
				throw illegalArgEx;//If this line is reached, no matching card was found (so it's not in the array)
			}
			else {
				throw illegalArgEx;//If the array is empty, a card cannot be removed from it
			}
		}
		catch (IllegalArgumentException e) {
			e.printStackTrace();//Needs replacing with something more explicit!
		}
		
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
		if (!fourOfAKind) { //Test last four cards only if first four test false for four of a kind
			for (int i = 1; i < 4; i++) { //Test the last four cards
				if (handContents[i].getRankValue() != handContents[i+1].getRankValue()) {
					fourOfAKind = false;
					break;
				}
			}
		}
		if (fourOfAKind) {
			System.out.println("Setting hand value...");
			handValue = "Four of a Kind";
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
			handDisplay += handContents[i].toString() + " ";
		}
		return handDisplay;
	}

}

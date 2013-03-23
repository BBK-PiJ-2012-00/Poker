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
			
		}
		
	}

	
	
	public void sort() {
		// TODO Auto-generated method stub
		
	}


	
	@Override
	public void evaluateHand() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String getHandValue() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String displayHand() {
		// TODO Auto-generated method stub
		return null;
	}

}

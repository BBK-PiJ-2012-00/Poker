/**
 * 
 */
package code;

/**
 * @author Anna Taylor
 *
 */
public class FiveCardHand implements Hand {
	private static final int SIZE = 5;
	private Card[] handContents = new CardImpl[SIZE];
	private int nextIndex = 0;
	
	
	@Override
	public Card[] getContents() {
		return handContents;
	}

	
	@Override
	public void addCard(Card c) {
		// TODO Auto-generated method stub
		
	}

}

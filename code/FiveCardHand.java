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
	
	
	@Override
	public Card[] getContents() {
		return handContents;
	}

}

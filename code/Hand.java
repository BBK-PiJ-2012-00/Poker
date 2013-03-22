/**
 * 
 */
package code;

/**
 * @author Anna Taylor
 *
 */
public interface Hand {
	
	/**
	 * Accessor method to access the cards that make up a hand.
	 * 
	 * @return an array of cards that constitutes the hand.
	 */
	public Card[] getContents();
	
	/**
	 * Allows for the addition of cards to the handContents array.
	 * 
	 * @param Card the card to be added to the hand.
	 */
	public void addCard(Card c);

}

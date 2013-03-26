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
	
	/**
	 * Allows for the removal of a card should the player wish to draw
	 * another from the deck.
	 * 
	 * @param Card the card to be removed from the hand.
	 */
	public void discardCard(Card c);
	
	/**
	 * Sorts the cards in the hand by rank. This is useful before evaluating 
	 * a hand.
	 */
	public void sort();
	
	/**
	 * Evaluates the value of a hand; whether it is a Flush, Straight etc, 
	 * or nothing.  Sets the handValue field of Hand to hold this value.
	 */
	public void evaluateHand();
	
	/**
	 * Returns the value of the hand e.g. Flush, Straight etc
	 * 
	 * @return the evaluation of the hand as a String.
	 */
	public String getHandValue();
	
	/**
	 * Returns an integer for use if the program-controlled dealer has a handValue
	 * of Three of a Kind; this allows for decisions about which cards to throw away.  A 
	 * value of 1 means that the first three cards are Three of a Kind; a value of 2 means
	 * the middle three cards are Three of a Kind; a value of 3 means the last three cards in 
	 * the hand are Three of a Kind.
	 * @return int the value of processingValue field
	 */
	public int getProcessingValue();
	
	/**
	 * Prints hand on screen for the player to view.
	 */
	public String displayHand();
	


}

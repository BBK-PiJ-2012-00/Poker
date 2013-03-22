/**
 * 
 */
package code;

/**
 * @author Anna Taylor
 *
 */
public interface Player {
	
	public void setName(String name);
	
	public String getName();
	
	/**
	 * Method that assigns dealt cards to the Hand field.
	 * 
	 * @param Card dealt by dealer off the top of the deck.
	 */
	public void receiveCard(Card c);

}

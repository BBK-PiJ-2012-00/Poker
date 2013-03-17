/**
 * 
 */
package code;

/**
 * @author Anna Taylor
 *
 */
public interface TableTop {
	
	/**
	 * Creates a human player and initialises the Player field.  
	 */
	public void createPlayer();
	
	
	/**
	 * Creates a program-controlled dealer and initialises the Dealer
	 * field.
	 */
	public void createDealer();
	
	
	/**
	 * Creates a Deck object and initialises the Deck field.
	 */
	public void createDeck();

}

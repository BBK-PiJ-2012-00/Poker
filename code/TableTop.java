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
	 * This method creates a human player and a dealer, setting up
	 * the Poker table.
	 */
	public void prepareTable();
	
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

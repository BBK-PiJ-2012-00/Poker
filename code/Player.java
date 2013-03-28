/**
 * 
 */
package code;

/**
 * @author Anna Taylor
 *
 */
public interface Player {
	
	
	public String getName();
	
	/**
	 * Method that assigns dealt cards to the Hand field.
	 * 
	 * @param Card dealt by dealer off the top of the deck.
	 */
	public void receiveCard(Card c);
	
	
	 /**
     * Method to retrieve the hand that the player is holding
     * 
     * @return Hand of player
     */
    public Hand getHand();
    
    
    /**
     * Method for the dealer player to select which cards to discard
     * 
     * @return int representing how many cards it has discarded
     * so that TableTopImpl knows how many cards to replace.
     */
    public int chooseDiscard();


}

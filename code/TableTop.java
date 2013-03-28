/**
 * 
 */
package code;

/**
 * @author Anna Taylor
 * @author Greg Marshall
 */
public interface TableTop {
	
	/**
	 * This method creates a human player and a dealer player, and sets
	 * off gameplay.
	 */
	public void prepareTable(); 
	
	/**
	 * Implements a short pause for easier, more broken up gameplay.
	 */
	public void pause();
	
	/**
	 * Introduces the dealer and sets off mainGameCycle().
	 */
	public void commenceGame();
	
	/**
	 * This is the main cycle of the game that runs on a while loop until the user
	 * opts to quit by entering "N" when asked if they wish to play again. This method calls
	 * sub methods to deal with certain sections of the game, such as the dealer's turn
	 * and comparing player hands.
	 */
	public void mainGameCycle();
	
	/**
	 * Handles the dealing of cards to player's hands. Cards are dealt to players
	 * alternately, using methods of Deck and Player.
	 */
	public void dealCards();
	
	/**
	 * This method handles the swapping out of up to three cards, and the replacing of
	 * these cards from the top of the deck (for HumanPlayer).  
	 * The player is asked how many cards they would like to swap (0-3), and is then asked 
	 * to provide the positions of the cards they wish to change. Once the swaps have been made
	 * (if any), new cards are dealt from the deck and the hand is re-evaluate in the mainGameCycle().
	 */
	public void discardAndReplace();
	
	/**
	 * This handles the program-controlled DealerPlayer's turn. The  dealer's
	 * chooseDiscard() method is invoked, and any replacements are made as a result of
	 * the the dealer choosing which cards to swap in chooseDiscard(). The dealer's hand
	 * is then re-evaluated.
	 */
	public void dealerTurn();
	
	/**
	 * Calls clearHand() method of Hand for each player, clearing the players' hands before the start
	 * of the next game round (should the player choose to continue playing).
	 */
	public void clearHands();
	
	/**
	 * One of two methods which deal with comparing player hands. Firstly, hands are compared using
	 * the compareTo() method of Hand.  If the hands are different (i.e. the result of compareTo() is
	 * not 0), a winner is decided there and then.  If the result is 0, the hands both have the same
	 * value (i.e. both players have a pair, or both have a flush etc) and further comparison begins.
	 * 
	 * If the players both have quads, the pairValue from the Hand class is compared to see which quads are 
	 * of a higher rank and a winner is decided. The same process is used for trips.
	 * 
	 * 
	 */
	public void compareHands();
}

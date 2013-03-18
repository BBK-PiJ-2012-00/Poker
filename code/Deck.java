/**
 * 
 */
package code;

import java.util.List;

/**
 * @author Anna Taylor
 *
 */
public interface Deck {
	
	/**
	 * Returns contents of the deck.
	 * @return List<Card>
	 */
	public List<Card> getContents();

	/**
	 * Shuffles the deck.
	 */
	public void shuffleCards();
	
	/**
	 * Creates the 52 cards that form the deck and stores
	 * them in a list field.
	 */
	public void createCards();
	
	/**
	 * Prints the contents of the deck.
	 */
	public void printDeck();
	
}

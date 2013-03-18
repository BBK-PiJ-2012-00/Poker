/**
 * 
 */
package code;

import java.util.List;
import java.util.LinkedList;

/**
 * @author Anna Taylor
 *
 */
public class DeckImpl implements Deck {
	private List<Card> deck = new LinkedList<>();
	
	public DeckImpl() {
		this.createCards();
	}
	

	
	@Override
	public void shuffleCards() {
		// TODO Auto-generated method stub

	}

	
	@Override
	public void createCards() {		
		for (int i = 0; i < 4; i++) { //Creates four lots of 13 cards, one set of each suit
			for (int j = 0; j < 13; j++) {
				Card c = new CardImpl(Rank.values()[j], Suit.values()[i]);//Enum values() is an array of the enum values.
				deck.add(c);
			}
		}		
	}
	
	public void printDeck() {
		for (int i = 0; i < deck.size(); i++) {
			System.out.println(deck.get(i).toString());
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Deck testDeck = new DeckImpl();
		
		testDeck.printDeck();
		
		

	}

}

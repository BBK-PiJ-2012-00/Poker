/**
 * 
 */
package code;

import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

/**
 * @author Anna Taylor
 *
 */
public class DeckImpl implements Deck {
	private List<Card> deckContents = new LinkedList<>();
	
	public DeckImpl() {
		this.createCards();
	}
	
	
	public List<Card> getContents() {
		return deckContents;
	}
	
	@Override
	public void shuffleCards() {
		Collections.shuffle(deckContents);
	}

	
	@Override
	public void createCards() {		
		for (int i = 0; i < 4; i++) { //Creates four lots of 13 cards, one set of each suit
			for (int j = 0; j < 13; j++) {
				Card c = new CardImpl(Rank.values()[j], Suit.values()[i]);//Enum values() is an array of the enum values.
				deckContents.add(c);
			}
		}		
	}
	
	public void printDeck() {
		for (int i = 0; i < deckContents.size(); i++) {
			System.out.println(deckContents.get(i).toString());
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Deck testDeck = new DeckImpl();
		
		//testDeck.printDeck();
		
		testDeck.shuffleCards();
		
		testDeck.printDeck();
		
		

	}

}

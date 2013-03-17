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
		for (int i = 0; i < 13; i++) {
			Card c = new CardImpl(i + 1, "C");
			deck.add(c);
		}
		for (int j = 0; j < 13; j++) {
			Card c = new CardImpl(j + 1, "S");
			deck.add(c);
		}
		for (int k = 0; k < 13; k++) {
			Card c = new CardImpl(k + 1, "H");
			deck.add(c);
		}
		for (int l = 0; l < 13; l++) {
			Card c = new CardImpl(l + 1, "D");
			deck.add(c);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

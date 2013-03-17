/**
 * 
 */
package code;

/**
 * @author Anna Taylor
 *
 */
public class CardImpl implements Card {
	private String suit;
	private int rank;
	
	
	public CardImpl(int rank, String suit) {
		this.suit = suit;
		this.rank = rank;
	}

	
	@Override
	public String getSuit() {
		return suit;
	}

	
	@Override
	public int getRank() {
		return rank;
	}
	
	@Override
	public String toString() {
		String cardDisplay = "[";
		if (rank == 1) {
			cardDisplay += "A" + suit + "]";
		}
		else if (rank == 11) {
			cardDisplay += "J" + suit + "]";
		}
		else if (rank == 12) {
			cardDisplay += "Q" + suit + "]";
		}
		else if (rank == 13) {
			cardDisplay += "K" + suit + "]";
		}
		else {
			cardDisplay += rank + suit + "]";
		}
		return cardDisplay;
	}
	


}

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


}

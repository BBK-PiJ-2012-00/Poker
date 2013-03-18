/**
 * 
 */
package code;

/**
 * @author Anna Taylor
 *
 */
public class CardImpl implements Card {
	private final Suit SUIT;
	private final Rank RANK;
	
	
	public CardImpl(Rank rank, Suit suit) {
		this.SUIT = suit;
		this.RANK = rank;
	}

	
	@Override
	public Suit getSuit() {
		return SUIT;
	}

	
	@Override
	public Rank getRank() {
		return RANK;
	}
	
	@Override
	public String toString() {
		return "[" + RANK.toString() + " " + SUIT.toString() + "]";
		
	}
	


}

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
	
	public CardImpl(String suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}

	
	@Override
	public String getSuit() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see code.Card#getRank()
	 */
	@Override
	public int getRank() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

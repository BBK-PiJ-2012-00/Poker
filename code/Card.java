/**
 * 
 */
package code;

/**
 * @author Anna Taylor
 *
 */
public interface Card extends Comparable<Card> {
	
	public Suit getSuit();
	
	public Rank getRank();
	
	@Override
	public int compareTo(Card c);
	
	
}

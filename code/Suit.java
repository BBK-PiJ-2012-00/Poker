/**
 * 
 */
package code;

/**
 * @author Anna Taylor
 *
 */
public enum Suit {
	
	CLUBS, SPADES, HEARTS, DIAMONDS;
	
	
	@Override
	public String toString() {
		String s = super.toString();
		return s.substring(0,1) + s.substring(1).toLowerCase();
	}
		
}


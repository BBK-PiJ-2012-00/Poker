/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Suit;

/**
 * @author Anna Taylor
 * @author Greg Marshall
 */
public class SuitTest {

	@Test
	public void testToString() {
		String expected = "Diamonds";
		String output = Suit.DIAMONDS.toString();
		assertEquals("Problem with toString() override", expected, output);
	}
	
	@Test 
	public void equalityAmongSuits() { //Tests that the same suit shows up as being equal
		Suit diamond1 = Suit.DIAMONDS;
		Suit diamond2 = Suit.DIAMONDS;
		boolean testEquality = false;
		if (diamond1 != diamond2) {
			testEquality = true;
		}
		assertFalse(testEquality);
	}

}

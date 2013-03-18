/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Suit;

/**
 * @author Anna Taylor
 *
 */
public class SuitTest {

	@Test
	public void testToString() {
		String expected = "Diamonds";
		String output = Suit.DIAMONDS.toString();
		assertEquals("Problem with toString() override", expected, output);
	}

}

/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import code.Rank;

/**
 * @author Anna Taylor
 *
 */
public class RankTest {

	@Test
	public void testGetValue() { 
		int expected = 1;
		int output = Rank.ACE.getValue();
		assertEquals("Problem with getValue()", expected, output);
	}
	
	@Test
	public void testGetValue2() {
		int expected = 13;
		int output = Rank.KING.getValue();
		assertEquals("Problem with getValue()", expected, output);
	}
	
	@Test
	public void testToString() {
		String expected = "Five";
		String output = Rank.FIVE.toString();
		assertEquals("Problem with toString() override", expected, output);
	}

}

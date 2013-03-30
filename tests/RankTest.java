/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import code.Rank;

/**
 * @author Anna Taylor
 * @author Greg Marshall
 */
public class RankTest {

	@Test
	public void testGetValue() { 
		int expected = 2;
		int output = Rank.TWO.getValue();
		assertEquals("Problem with getValue()", expected, output);
	}
	
	@Test
	public void testGetValue2() {
		int expected = 13;
		int output = Rank.KING.getValue();
		assertEquals("Problem with getValue()", expected, output);
	}
	
	@Test
	public void TestGetValueAce() {
		int expected = 14;
		int output = Rank.ACE.getValue();
		assertEquals("Problem with getValue() - Ace,", expected, output);
	}
	
	@Test
	public void testToString() {
		String expected = "Five";
		String output = Rank.FIVE.toString();
		assertEquals("Problem with toString() override", expected, output);
	}
	
	

}

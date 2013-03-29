/**
 * 
 */
package tests;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import code.TableTop;
import code.TableTopImpl;

/**
 * @author Anna Taylor
 * @author Greg Marshall
 * 
 * Most of the methods in this class simply call previously tested methods from other classes, so there
 * is not much to test here.
 */
public class TableTopTest { 
	private TableTop testTable;
	
	@Before
	public void setUp() {
		testTable = new TableTopImpl();
	}
	
	@After
	public void cleanUp() {
		testTable = null;
	}	
	
	@Test(timeout = 1000) //Expected to fail; shows that pause() doesn't finish prematurely
	public void testPauseLengthFail() {
		testTable.pause();
		System.out.println("Pause complete.");
	}
	
	@Test(timeout = 1850)
	public void testPauseLength() {
		testTable.pause();
		System.out.println("Pause complete.");
	}    


}

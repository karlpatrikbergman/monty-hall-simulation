package se.patrikbergman.lab.misc.montyhall.box;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BoxTest {
	Box box = new Box(0);
	
	@Test
	public void testClose() {
		box.close();
		assertFalse(box.isOpen());
	}
	
	@Test
	public void testOpen() {
		box.open();
		assertTrue(box.isOpen());
	}

	@Test
	public void testPutMoneyIn() {
		box.putMoneyIn();
		assertTrue(box.containsMoney());
	}
	
	@Test
	public void testEmpty() {
		box.empty();
		assertFalse(box.containsMoney());
	}
	
	@Test
	public void testSetAsPicked() {
		box.setAsPicked();
		assertTrue(box.isPicked());
	}
	
	@Test
	public void testSetAsNotPicked() {
		box.setAsNotPicked();
		assertFalse(box.isPicked());
	}
}

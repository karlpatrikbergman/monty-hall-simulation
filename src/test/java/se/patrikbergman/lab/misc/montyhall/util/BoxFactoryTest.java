package se.patrikbergman.lab.misc.montyhall.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import se.patrikbergman.lab.misc.montyhall.box.Box;

public class BoxFactoryTest {

	@Test
	public void testCreateBoxes() {
		List<Box> boxes = BoxFactory.createBoxes(3);
		assertNotNull(boxes);
		assertTrue(boxes.size() == 3);
	}
}
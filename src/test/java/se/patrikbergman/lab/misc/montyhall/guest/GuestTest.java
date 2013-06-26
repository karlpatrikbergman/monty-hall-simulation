package se.patrikbergman.lab.misc.montyhall.guest;

import static org.junit.Assert.*;
import static se.patrikbergman.lab.misc.montyhall.util.BoxFactory.createBoxes;
import static se.patrikbergman.lab.misc.montyhall.test.util.BoxTestUtil.*;

import java.util.List;

import org.junit.Test;

import se.patrikbergman.lab.misc.montyhall.box.Box;

public class GuestTest {
	
	@Test
	public void testPickOneBoxAtRandom() {
		List<Box> boxes = createBoxes(3);
		Guest guest = new Guest(boxes);
		guest.pickOneBoxAtRandom();
		assertEquals(1, getNrOfPickedBoxes(boxes));
	}
	
	@Test
	public void testDecideOnFinalPickChangedMind1() {
		List<Box> boxes = createBoxes(3);
		boxes.get(0).setAsPicked();
		boxes.get(1).open();
		Guest guest = new Guest(boxes);
		guest.pickClosedNotPickedBox();
		assertTrue(boxes.get(2).isPicked());
		commonAsserts(boxes);
	}
	
	@Test
	public void testDecideOnFinalPickChangedMind2() {
		List<Box> boxes = createBoxes(3);
		boxes.get(1).setAsPicked();
		boxes.get(0).open();
		Guest guest = new Guest(boxes);
		guest.pickClosedNotPickedBox();
		assertTrue(boxes.get(2).isPicked());
		commonAsserts(boxes);
	}
	
	@Test
	public void testDecideOnFinalPickStickToFirstChoice1() {
		List<Box> boxes = createBoxes(3);
		boxes.get(1).setAsPicked();
		boxes.get(0).open();
		Guest guest = new Guest(boxes);
		guest.stayWithFirstChoice();
		assertTrue(boxes.get(1).isPicked());
		commonAsserts(boxes);
	}
	
	private void commonAsserts(List<Box> boxes) {
		assertEquals(1, getNrOfOpenBoxes(boxes));
		assertEquals(1, getNrOfPickedBoxes(boxes));
	}
}

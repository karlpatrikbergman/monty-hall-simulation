package se.patrikbergman.lab.misc.montyhall.staff;

import static org.junit.Assert.assertEquals;
import static se.patrikbergman.lab.misc.montyhall.test.util.BoxTestUtil.*;
import static se.patrikbergman.lab.misc.montyhall.util.BoxFactory.createBoxes;

import java.util.List;

import org.junit.Test;

import se.patrikbergman.lab.misc.montyhall.box.Box;

public class StaffTest {

	@Test
	public void testPrepareBoxesBeforeTvShow() {
		List<Box> boxes = createBoxes(3);
		Staff staff = new Staff(boxes);
		staff.prepareBoxesBeforeTvShow();
		assertEquals(1, getNrOfBoxesWithMoney(boxes));
		assertEquals(0, getNrOfOpenBoxes(boxes));
		assertEquals(0, getNrOfPickedBoxes(boxes));
	}
}

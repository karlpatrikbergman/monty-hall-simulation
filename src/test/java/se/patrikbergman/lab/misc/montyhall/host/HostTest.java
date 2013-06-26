package se.patrikbergman.lab.misc.montyhall.host;

import static org.junit.Assert.*;
import static se.patrikbergman.lab.misc.montyhall.test.util.BoxTestUtil.*;
import static se.patrikbergman.lab.misc.montyhall.util.BoxFactory.createBoxes;

import java.util.List;

import org.junit.Test;

import se.patrikbergman.lab.misc.montyhall.box.Box;

public class HostTest {

	@Test
	public void testOpenEmtpyNotPickedBox() {
		List<Box> boxes = createBoxes(3);
		boxes.get(0).putMoneyIn();
		boxes.get(1).setAsPicked();
		Host host = new Host(boxes);
		host.openEmtpyNotPickedBox();
		assertTrue(boxes.get(2).isOpen());
		assertEquals(1, getNrOfOpenBoxes(boxes));
	}
}

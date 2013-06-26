package se.patrikbergman.lab.misc.montyhall.show;

import static org.junit.Assert.*;
import static se.patrikbergman.lab.misc.montyhall.test.util.BoxTestUtil.*;

import java.util.List;

import org.junit.Test;

import se.patrikbergman.lab.misc.montyhall.box.Box;

public class TvShowTest {

	@Test
	public void testRun() {
		boolean guestStaysWithFirstChoice = false;
		TvShow tvShow = new TvShow(guestStaysWithFirstChoice);
		tvShow.run();
		
		assertTrue(tvShow.hasEnded());
		
		List<Box> boxes = tvShow.getBoxes();
		assertEquals(1, getNrOfBoxesWithMoney(boxes));
		assertEquals(1, getNrOfOpenBoxes(boxes));
		assertEquals(1, getNrOfPickedBoxes(boxes));
		
		try {
			assertTrue(validateBoxesAfterTvShow(boxes));
		} catch(RuntimeException e) {
			fail(e.getMessage());
		}	
		
		System.out.printf("tvShow.guestWonTheMoney() %b", tvShow.guestWonTheMoney());
	}

}

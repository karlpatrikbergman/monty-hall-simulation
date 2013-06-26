package se.patrikbergman.lab.misc.montyhall.util;

import java.util.ArrayList;
import java.util.List;

import se.patrikbergman.lab.misc.montyhall.box.Box;

public final class BoxFactory {
	
	public static List<Box> createBoxes(int nrOfBoxes) {
		List<Box> boxes = new ArrayList<Box>();
		for (int i = 0; i < nrOfBoxes; i++) {
			boxes.add(new Box(i));
		}
		return boxes;
	}
}

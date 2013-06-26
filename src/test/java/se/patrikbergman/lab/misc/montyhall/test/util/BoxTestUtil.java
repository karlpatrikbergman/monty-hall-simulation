package se.patrikbergman.lab.misc.montyhall.test.util;

import java.util.List;

import se.patrikbergman.lab.misc.montyhall.box.Box;

public class BoxTestUtil {

	public static int getNrOfBoxesWithMoney(List<Box> boxes) {
		int nrOfBoxesWithMoney = 0;
		for (Box box : boxes) {
			if (box.containsMoney()) {
				nrOfBoxesWithMoney++;
			}
		}
		return nrOfBoxesWithMoney;
	}

	public static int getNrOfOpenBoxes(List<Box> boxes) {
		int nrOfOpenBoxes = 0;
		for (Box box : boxes) {
			if (box.isOpen()) {
				nrOfOpenBoxes++;
			}
		}
		return nrOfOpenBoxes;
	}

	public static int getNrOfPickedBoxes(List<Box> boxes) {
		int nrOfPickedBoxes = 0;
		for (Box box : boxes) {
			if (box.isPicked()) {
				nrOfPickedBoxes++;
			}
		}
		return nrOfPickedBoxes;
	}	
	
	public static int getPickedBoxId(List<Box> boxes) {
		for (Box box : boxes) {
			if (box.isPicked()) {
				return box.getId();
			}
		}
		throw new RuntimeException("No box is set as picked at the moment!");
	}
	
	public static boolean validateBoxesAfterTvShow(List<Box> boxes) {
		for(Box box: boxes) {
			if(box.isOpen() && box.isPicked()) {
				throw new RuntimeException("Box can't be open and picked by guest at the same time");
			}
			if(box.isOpen() && box.containsMoney()) {
				throw new RuntimeException("Box can't be open and contain money at the same time");
			}
		}
		return true;
	}
}

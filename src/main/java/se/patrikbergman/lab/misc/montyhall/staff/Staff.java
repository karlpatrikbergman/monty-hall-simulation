package se.patrikbergman.lab.misc.montyhall.staff;

import java.util.List;

import se.patrikbergman.lab.misc.montyhall.util.RandomImpl;


public class Staff {
	private final List<? extends StaffViewOfBox> boxes;
	
	public Staff(List<? extends StaffViewOfBox> boxes) {
		this.boxes = boxes;
	}
	
	public void prepareBoxesBeforeTvShow() {
		emptyAllBoxes();
		placeMoneyInOneOfTheBoxesAtRandom();
		closeAllBoxes();
	}
	
	private void placeMoneyInOneOfTheBoxesAtRandom() {
		int randomIndex = RandomImpl.nextInt(boxes.size());
		boxes.get(randomIndex).putMoneyIn();
		
		System.out.println("Staff randomly put money in box: " + randomIndex);
	}
	
	private void emptyAllBoxes() {
		for(StaffViewOfBox box: boxes) {
			box.empty();
		}
	}
	
	private void closeAllBoxes() {
		for(StaffViewOfBox box: boxes) {
			box.close();
		}
	}
}

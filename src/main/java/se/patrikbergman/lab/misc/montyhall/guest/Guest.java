package se.patrikbergman.lab.misc.montyhall.guest;

import java.util.List;

import se.patrikbergman.lab.misc.montyhall.util.RandomImpl;

public class Guest {
	private final List<? extends GuestViewOfBox> boxes;

	public Guest(List<? extends GuestViewOfBox> boxes) {
		this.boxes = boxes;
	}

	public void pickOneBoxAtRandom() {
		setAllBoxesAsNotPicked();
		int randomIndex = RandomImpl.nextInt(boxes.size());
		boxes.get(randomIndex).setAsPicked();

		System.out.println("Guest randomly picked box nr: " + randomIndex);
	}

	public void stayWithFirstChoice() {
		System.out.println("Guest stayed with first choice, box : " + getPickedBox().getId());
	}

	public void pickClosedNotPickedBox() throws RuntimeException {
		GuestViewOfBox firstPickedBox = getPickedBox();

		for (GuestViewOfBox box : boxes) {

			if (box.isOpen()) {
				continue;
			}
			if (!box.isOpen() && box != firstPickedBox) {
				box.setAsPicked();
				System.out.println("Final pick of guest is box : " + box.getId());
				continue;
			}
			if (!box.isOpen() && box == firstPickedBox) {
				box.setAsNotPicked();
			}
		}
	}

	private GuestViewOfBox getPickedBox() {
		for (GuestViewOfBox box : boxes) {
			if (box.isPicked())
				return box;
		}
		throw new RuntimeException("No box is set as picked at the moment.");
	}

	/*
	 * protected GuestViewOfBox getFirstPickedBox() { return firstPickedBox; }
	 * 
	 * protected void setFirstPickedBox(GuestViewOfBox firstPickedBox) {
	 * if(this.firstPickedBox == null) this.firstPickedBox = firstPickedBox; }
	 */

	private void setAllBoxesAsNotPicked() {
		for (GuestViewOfBox box : boxes) {
			box.setAsNotPicked();
		}
	}
}

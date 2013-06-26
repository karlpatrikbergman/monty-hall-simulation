package se.patrikbergman.lab.misc.montyhall.show;

import java.util.List;

import se.patrikbergman.lab.misc.montyhall.box.Box;
import se.patrikbergman.lab.misc.montyhall.guest.Guest;
import se.patrikbergman.lab.misc.montyhall.host.Host;
import se.patrikbergman.lab.misc.montyhall.staff.Staff;
import se.patrikbergman.lab.misc.montyhall.util.BoxFactory;

/**
 * @author patrikbergman
 *
 * To run a Monty Hall Tv-show simulation where guest always stays with first choice
 * set boolean guestStaysWithFirstChoice = true.
 * 
 * To run a Monty Hall Tv-show simulation where guest never stays with first choice
 * set boolean guestStaysWithFirstChoice = false 
 *
 *
 */
public class TvShow {
	private final Staff staff;
	private final Host host;
	private final Guest guest;
	private final List<Box> boxes;
	private final boolean guestStaysWithFirstChoice;
	private boolean showHasEnded = false;

	public TvShow(boolean guestStaysWithFirstChoice) {
		this.boxes = BoxFactory.createBoxes(3);
		this.staff = new Staff(boxes);
		this.guest = new Guest(boxes);
		this.host = new Host(boxes);
		this.guestStaysWithFirstChoice = guestStaysWithFirstChoice;
	}

	public void run() {
		staff.prepareBoxesBeforeTvShow();
		guest.pickOneBoxAtRandom();
		host.openEmtpyNotPickedBox();
		if (!guestStaysWithFirstChoice) {
			guest.pickClosedNotPickedBox();
		}
		this.showHasEnded = true;
	}

	protected boolean hasEnded() {
		return this.showHasEnded;
	}

	protected List<Box> getBoxes() {
		return boxes;
	}
	
	protected boolean guestWonTheMoney() {
		for(Box box: boxes) {
			if(box.isPicked() && box.containsMoney()) {
				return true;
			}
		}
		return false;
	}

	public static void main(String args[]) {
		int nrOfGuestWins = 0;
		boolean guestStaysWithFirstChoice = false;
		int i;
		
		for(i=0; i<1000; i++) {
			TvShow tvShow = new TvShow(guestStaysWithFirstChoice);
			tvShow.run();
			nrOfGuestWins += (tvShow.guestWonTheMoney()) ? 1 : 0;
		}
		
		float procentWins = (float) 100.0 * ((float) nrOfGuestWins / (float) i); 
		System.out.printf("Guest won in %d shows out of %d shows (%f%%)", nrOfGuestWins, i, procentWins);
	}

}

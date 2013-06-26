package se.patrikbergman.lab.misc.montyhall.show;

import java.util.List;

import se.patrikbergman.lab.misc.montyhall.box.Box;
import se.patrikbergman.lab.misc.montyhall.guest.Guest;
import se.patrikbergman.lab.misc.montyhall.host.Host;
import se.patrikbergman.lab.misc.montyhall.staff.Staff;
import se.patrikbergman.lab.misc.montyhall.statistics.Statistics;
import se.patrikbergman.lab.misc.montyhall.util.BoxFactory;

/**
 * @author patrikbergman
 * 
 *         To run a Monty Hall Tv-show simulation where guest always stays with
 *         first choice set boolean guestStaysWithFirstChoice = true.
 * 
 *         To run a Monty Hall Tv-show simulation where guest never stays with
 *         first choice set boolean guestStaysWithFirstChoice = false
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

	public boolean guestWonTheMoney() {
		for (Box box : boxes) {
			if (box.isPicked() && box.containsMoney()) {
				return true;
			}
		}
		return false;
	}

	private static Statistics runManyShowsInARow(int nrOfTvShows, boolean guestStaysWithFirstPick) {

		System.out.printf("Running %d TV-shows where guestStaysWithFirstChoice=%b...%n", nrOfTvShows,
				guestStaysWithFirstPick);

		Statistics statistics = new Statistics();
		for (int i = 0; i < nrOfTvShows; i++) {
			TvShow tvShow = new TvShow(guestStaysWithFirstPick);
			tvShow.run();
			statistics.addTvShow(tvShow);
		}
		return statistics;
	}

	public static void main(String args[]) {
		Statistics statsGuestStaysWithFirstPick = runManyShowsInARow(100000, true);

		System.out.printf("Guest won in %d shows out of %d shows (%f%%)%n", statsGuestStaysWithFirstPick.getNrOfWins(),
				statsGuestStaysWithFirstPick.getNrOfShows(), statsGuestStaysWithFirstPick.getProcentWins());
		
		System.out.println();
		
		Statistics statsGuestChangesPick = runManyShowsInARow(100000, false);

		System.out.printf("Guest won in %d shows out of %d shows (%f%%)%n", statsGuestChangesPick.getNrOfWins(),
				statsGuestChangesPick.getNrOfShows(), statsGuestChangesPick.getProcentWins());
		
		System.out.println();
		
		if(statsGuestStaysWithFirstPick.getNrOfWins() > statsGuestChangesPick.getNrOfWins()) {
			System.out.println("The guest has the best chance to win the money if hen always stays with first pick!");
		} else {
			System.out.println("The guest has the best chance to win the money if hen always changes pick!");
		}
	}

}

package se.patrikbergman.lab.misc.montyhall.statistics;

import se.patrikbergman.lab.misc.montyhall.show.TvShow;

public class Statistics {
	private int nrOfWins = 0;
	private int nrOfShows;

	public void addTvShow(TvShow tvShow) {
		this.nrOfShows++;
		this.nrOfWins += (tvShow.guestWonTheMoney()) ? 1 : 0;
	}
	
	public String getStatistics() {
		return Float.toString(getProcentWins());
	}
	
	public float getProcentWins() {
		return (float) 100.0 * ((float) nrOfWins / (float) nrOfShows);
	}
	
	public int getNrOfWins() {
		return nrOfWins;
	}
	
	public int getNrOfShows() {
		return nrOfShows;
	}
}

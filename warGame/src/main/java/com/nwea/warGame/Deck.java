package com.nwea.warGame;

public interface Deck {
	/* Create the deck of cards */
	public void create(int numberOfSuits, int numberOfRanks);

	/* Shuffle the deck */
	public void shuffle();

	/* Abstracts & implements logic for game & 
	 * adds all cards to winners card deck. 
	 * So we can have multiple types of cards rule, based on region.
	 * */
	public void deal(Player[] players);

}

package com.nwea.warGame;

import java.util.ArrayList;
import java.util.List;

/**
 * Actual cards on table.
 */
public class Cards implements Deck {

	List<Integer> cardDeck;

	public void create(int numberOfSuits, int numberOfRanks) {
		cardDeck = new ArrayList<Integer>();

		int totalCards = (numberOfSuits * numberOfRanks);
		System.out.println(totalCards);
		// Create card deck by repeating 2 till number of ranks
		for (int i = 0; i < totalCards;) {
			for (int j = 2; j <= (numberOfRanks + 1); j++) {
				cardDeck.add(j);
				System.out.println(j);
				i++;
			}
		}
	}

	public void shuffle() {
		// TODO Auto-generated method stub

	}

	public void deal() {
		// TODO Auto-generated method stub

	}

}

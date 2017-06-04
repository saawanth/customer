package com.nwea.warGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Actual cards on table, creation and actual deal implementation logic.
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

	/** This is additional method, 
	  * I would like to delete at later stage - including now 
	  * as part of requirements.
	  */
	public void shuffle() {
		Collections.shuffle(cardDeck);
	}

	public void deal(Player[] players) {

	}

}

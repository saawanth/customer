package com.nwea.warGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Actual cards on table, creation and actual deal implementation logic.
 */
public class Cards implements Deck {

	List<Integer> cardDeck;

	public void create(int numberOfSuits, int numberOfRanks) {
		cardDeck = new ArrayList<Integer>();

		int totalCards = (numberOfSuits * numberOfRanks);
		// Create card deck by repeating 2 till number of ranks
		for (int i = 0; i < totalCards;) {
			for (int j = 2; j <= (numberOfRanks + 1); j++) {
				cardDeck.add(j);
				i++;
			}
		}
		shuffle();
	}

	/**
	 * This is additional method, I would like to delete at later stage -
	 * including now as part of requirements.
	 */
	public void shuffle() {
		Collections.shuffle(cardDeck);
	}

	public void deal(Player[] players) {

		Map<Integer, Integer> onTable = pullCardOnTable(players);

		// Compare & find out highest card.
		int maxCardIndex = findOutMaxValue(onTable);
		if (maxCardIndex == 101) { // call again
			/////////////////////// Need to have recursive call to
			/////////////////////// findOutMaxValue()
		} else { // Push all cards on table to winning player's card deck.
			for (Integer key : onTable.keySet()) {
				players[maxCardIndex].myCards.add(onTable.get(key));
			}
			System.out.println("........................ "+players[maxCardIndex].playerName + " won this deal.");
			System.out.println("**********************************");
		} // end of else

	}

	private Map<Integer, Integer> pullCardOnTable(Player[] players) {

		Map<Integer, Integer> pulledCards = new HashMap<>();

		// Turn on and put, one card from each player, on table.
		for (int i = 0; i < players.length; i++) {
			String currentCard = "";
			if (!players[i].lost) {
				System.out.print(players[i].displayCards());
				switch (players[i].myCards.get(0)) {
				case 11:
					currentCard = "J";
					break;
				case 12:
					currentCard = "Q";
					break;
				case 13:
					currentCard = "K";
					break;
				case 14:
					currentCard = "A";
					break;
				default:
					currentCard = players[i].myCards.get(0).toString();
					break;
				}
				System.out.println("[" + currentCard + "]");
				pulledCards.put(i, players[i].myCards.remove(0));
			} // end of if
		} // end of for

		return pulledCards;
	}

	private int findOutMaxValue(Map<Integer, Integer> onTable) {

		int resultKey = 101; // 101 means, it is equal, so calling method has to
							// pull next set and call this method again, till
							// this returns non-zero

		int heavyCard = Collections.max(onTable.values());
		int duplicateCounter = 0; // Counter to find out if two or more players
									// having duplicate card numbers.
		for (Integer key : onTable.keySet()) {
			if (heavyCard == onTable.get(key)) {
				resultKey = key;
				duplicateCounter++;
			}
		}

		if (duplicateCounter > 1) {
			resultKey = 101;
		}

		return resultKey;
	}

}

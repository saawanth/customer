package com.nwea.warGame;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents actual War game & starting point of application. Since there is
 * going to be only one War game at a time, so creating instance objects, this
 * is not yet designed to be multi-threaded.
 */
public class War {

	private Deck deck;
	private Player[] players;

	public War() {
	}

	public void play(int numberOfSuits, int numberOfRanks, int numberOfPlayers) {

		deck = createDeck(numberOfSuits, numberOfRanks);
		// Create Players
		players = createPlayers(numberOfPlayers);

		deck.shuffle();
		// Distribute cards to all players
		distributeCards();

		// Play rounds
		playRounds();

		// Display winner
		congratsWinner();

	}

	private Deck createDeck(int numberOfSuits, int numberOfRanks) {
		Deck deck = new SimpleDeck();
		deck.create(numberOfSuits, numberOfRanks);
		return deck;
	}

	public Player[] createPlayers(int numberOfPlayers) {
		Player[] players = new Player[numberOfPlayers];
		for (int i = 0; i < players.length; i++) {
			players[i] = new Player("Player-" + (i + 1));
		}

		return players;
	}

	public void distributeCards() {
		Card card = deck.deal();

		int playerIdxToUse = 0;
		while (card != null) {
			Player player = players[playerIdxToUse];
			player.assignCard(card);
			if (playerIdxToUse >= players.length - 1) {
				playerIdxToUse = 0;
			}
			card = deck.deal();
		}
	}

	// Method handling main logic of comparing and adjusting cards between
	// players.
	private void playRounds() {

		boolean roundsFlag = true;
		while (roundsFlag) {

			// check available cards in each player's card deck & set flag
			int totalPlayersLost = 0;
			for (int i = 0; i < players.length; i++) {
				if (!(players[i].myCards.size() > 0)) {
					players[i].lost = true;
					totalPlayersLost++;
				}
			}

			cardOnTable.deal(players);

			if (totalPlayersLost == (players.length - 1)) {
				roundsFlag = false;
			}

		}

	}

	private void congratsWinner() {

		for (int i = 0; i < players.length; i++) {
			if (players[i].lost == false) {
				System.out.println("Winner of this game is " + players[i].playerName);
			}
		}

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
			System.out.println("........................ " + players[maxCardIndex].playerName + " won this deal.");
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
		// pull next set and call this method again,
		// till
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

	public static void main(String[] args) {

		// Not final version, yet.
		new War().play(2, 13, 2);
	}
}

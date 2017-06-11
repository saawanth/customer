package com.nwea.warGame;

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
		// congratsWinner();

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
		// boolean roundsFlag = true;
		// while (roundsFlag) {
		// // check available cards in each player's card deck & set flag
		// int totalPlayersLost = 0;
		// for (int i = 0; i < players.length; i++) {
		// if (!(players[i].myCards.size() > 0)) {
		// players[i].lost = true;
		// totalPlayersLost++;
		// }
		// }
		// cardOnTable.deal(players);
		// if (totalPlayersLost == (players.length - 1)) {
		// roundsFlag = false;
		// }
		// }
	}

	public static void main(String[] args) {

		// Not final version, yet.
		new War().play(2, 13, 2);
	}
}

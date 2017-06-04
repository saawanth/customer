package com.nwea.warGame;

import java.util.LinkedList;

/**
 * Represents actual War game & starting point of application. Since there is
 * going to be only one War game at a time, so creating instance objects, this
 * is not yet designed to be multi-threaded.
 */
public class War {

	public Cards cardOnTable;
	public Player[] players;

	public War() {
		cardOnTable = new Cards();
	}

	public void play(int numberOfSuits, int numberOfRanks, int numberOfPlayers) {

		// Create cards on table
		cardOnTable.create(numberOfSuits, numberOfRanks);

		// Shuffle cards on table
		cardOnTable.shuffle();

		// Create Players
		createPlayers(numberOfPlayers);

		// Distribute cards to all players
		distributeCards();

		// Play rounds
		playRounds();

		// Display winner
		congratsWinner();

	}

	public void createPlayers(int numberOfPlayers) {
		players = new Player[numberOfPlayers];
		for (int i = 0; i < players.length; i++) {
			players[i] = new Player();
			players[i].playerName = "Player" + (i+1); // This can be taken from user
			players[i].myCards = new LinkedList<>();
		}

	}

	public void distributeCards() {
		for(int i =0; i < (cardOnTable.cardDeck.size()-1);) {
			for(int p =0; p < players.length; p++) {
				players[p].myCards.add(cardOnTable.cardDeck.get(i));
				i++;
			}
		}
	}

	// Method handling main logic of comparing and adjusting cards between
	// players.
	private void playRounds() {

		boolean roundsFlag = true;
		while (roundsFlag) {
		
			// check available cards in each player's card deck & set flag
			int totalPlayersLost = 0;
			for(int i=0; i < players.length; i++) {
				if(!(players[i].myCards.size() > 0)) {
					players[i].lost = true;
					totalPlayersLost++;
				}
			}
			
			cardOnTable.deal(players);
			
			if(totalPlayersLost == (players.length-1)) {
				roundsFlag = false;
			}
			
		}
		
	}
	
	private void congratsWinner() {
		
		for(int i=0; i < players.length; i++) {
			if(players[i].lost == false) {
				System.out.println("Winner of this game is " + players[i].playerName);
			}
		}
		
	}

	public static void main(String[] args) {

		// Not final version, yet.
		new War().play(2, 13, 2);
	}
}

package com.nwea.warGame;

import java.util.LinkedList;

/**
 * Represents actual War game & starting point of application.
 * Since there is going to be only one War game at a time, 
 * so creating instance objects, this is not yet designed to be multi-threaded.
 */
public class War {

	private Cards cardOnTable;
	Player[] players;
	
	public War() {
		cardOnTable = new Cards();
	}
	
	
	public void play(int numberOfSuits, int numberOfRanks, int numberOfPlayers) {

		// Create cards on table
		cardOnTable.create(numberOfSuits, numberOfRanks);
		
		//Shuffle cards on table
		cardOnTable.shuffle();
	
		//Create Players
		createPlayers(numberOfPlayers);
		
		// Distribute cards to all players
		distributeCards(numberOfSuits, numberOfRanks);
	
		// Play rounds 
		playRounds();
		
		// Display winner
		
		
	}

	private void createPlayers(int numberOfPlayers) {
		players = new Player[numberOfPlayers];
		for(int i=0; i < players.length; i++) {
			players[i].playerName = "Player" + i;
			players[i].myCards = new LinkedList<>();
		}
		
	}
	
	private void distributeCards(int numberOfSuits, int numberOfRanks) {
		cardOnTable.create(numberOfSuits, numberOfRanks);
	}
	
	
	// Method handling main logic of comparing and adjusting cards between players.
	private void playRounds() {
		cardOnTable.deal(players);

		// check available cards in each player's card deck
		for(int i=0; i < players.length; i++) {
			
		}

		
	}
	
	public static void main(String[] args) {
		
		// Not final version, yet.
		new War().play(4, 13, 2);
	}
}

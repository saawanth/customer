package com.nwea.warGame;

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
		
	}
	
	private void distributeCards(int numberOfSuits, int numberOfRanks) {
		cardOnTable.create(numberOfSuits, numberOfRanks);
	}
	
	
	// Method handling main logic of comparing and adjusting cards between players.
	private void playRounds() {
		cardOnTable.deal();
		
		// Loop thru players to initiate and shuffle cards
		
		
		// start throwing
		
		// start comparing & decision of winner
		
		// display player card. player.displayCards();
		
	}
	
	public static void main(String[] args) {
		
		// Not final version, yet.
		new War().play(4, 13, 2);
	}
}

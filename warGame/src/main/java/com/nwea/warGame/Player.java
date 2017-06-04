package com.nwea.warGame;

import java.util.Arrays;
import java.util.List;

/**
 * Represents a player in game.
 * Keeping this class simple, so going forward we can region specific 
 * functionalities in player.
 */
public class Player {

	String playerName;
	List<Integer> myCards; 
	
	// This can be enhanced, based on various options to display.
	public void displayCards() {
		System.out.println(this.playerName + "'s cards " + Arrays.toString(myCards.toArray()));
	}
}

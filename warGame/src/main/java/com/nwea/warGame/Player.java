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
	boolean lost;
	
	// This can be enhanced, based on various options to display.
	public String displayCards() {
		// return this.playerName + "'s cards " + Arrays.toString(myCards.toArray());
		
		String displayString = this.playerName + "'s cards [";
		for(Integer card: myCards) {
				switch (card) {
				case 11:
					displayString += " J";
					break;
				case 12:
					displayString += " Q";
					break;
				case 13:
					displayString += " K";
					break;
				case 14:
					displayString += " A";
					break;
				default:
					displayString += " " + card.toString();
					break;
				}
		} // end for loop
		displayString += "]";
		return displayString;
	}
}

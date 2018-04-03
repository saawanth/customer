package com.shuffler.model;

import java.util.ArrayList;
import java.util.List;

public class Cards {

	final String types[] = { "Heart", "Spade", "Club", "Diamond" };
	final String cards[] = { "Ace", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
	
	public List<String> formDeck() {
		List<String> cardValue = new ArrayList<String>();
		for (int i = 0; i < types.length; i++) {
			for (int j = 0; j < cards.length; j++) {
				cardValue.add(types[i] + " " + cards[j]);
			}
		}		
		return cardValue;
	}
}

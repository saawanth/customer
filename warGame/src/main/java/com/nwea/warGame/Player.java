package com.nwea.warGame;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a player in game. Keeping this class simple, so going forward we
 * can region specific functionalities in player.
 */
public class Player {

	private final String playerName;
	private final List<Card> myCards;

	public Player(String playerName, List<Card> myCards) {
		super();
		this.playerName = playerName;
		this.myCards = myCards;
	}

	public Player(String playerName) {
		super();
		this.playerName = playerName;
		this.myCards = new ArrayList<>();
	}

	public String getPlayerName() {
		return playerName;
	}

	public List<Card> getMyCards() {
		return myCards;
	}

	public void assignCard(Card card) {
		myCards.add(card);
	}
}

package com.nwea.warGame;

import java.util.LinkedList;

/**
 * Represents a player in game. Keeping this class simple, so going forward we
 * can region specific functionalities in player.
 */
public class Player {

	private final String playerName;
	private final LinkedList<PlayerCard> playerCards;

	public Player(String playerName) {
		super();
		this.playerName = playerName;
		this.playerCards = new LinkedList<>();
	}

	public String getPlayerName() {
		return playerName;
	}

	public PlayerCard getNextCard() {
		return playerCards.poll();
	}

	public void assignCard(Card card) {
		playerCards.add(new PlayerCard(this, card));
	}

	public boolean hasCards() {
		return playerCards.size() > 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((playerCards == null) ? 0 : playerCards.hashCode());
		result = prime * result + ((playerName == null) ? 0 : playerName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (playerCards == null) {
			if (other.playerCards != null)
				return false;
		} else if (!playerCards.equals(other.playerCards))
			return false;
		if (playerName == null) {
			if (other.playerName != null)
				return false;
		} else if (!playerName.equals(other.playerName))
			return false;
		return true;
	}

	public int getCardsSize() {
		return playerCards.size();
	}

}

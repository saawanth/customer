package com.nwea.warGame;

public class PlayerCard {

	private final Player player;
	private final Card card;

	@Override
	public String toString() {
		return "[" + player.getPlayerName() + ", " + card + "]";
	}

	public PlayerCard(Player player, Card card) {
		super();
		this.player = player;
		this.card = card;
	}

	public Player getPlayer() {
		return player;
	}

	public Card getCard() {
		return card;
	}

	public Rank getRank() {
		return card.getRank();
	}

}

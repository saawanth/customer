package com.nwea.warGame;

import java.util.ArrayList;
import java.util.List;

public class SimpleDeck implements Deck {

	private int dealIndex = 0;
	private String name;
	private List<Card> deckOfCards = new ArrayList<Card>();
	private Shuffler shuffler;

	public List<Card> getDeckOfCards() {
		return deckOfCards;
	}

	public void setDeckOfCards(List<Card> deckOfCards) {
		this.deckOfCards = deckOfCards;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void create(int numberOfSuits, int numberOfRanks) {
		int totalCards = (numberOfSuits * numberOfRanks);

		Suit[] allSuits = Suit.values();
		Rank[] allRanks = Rank.values();

		for (int i = 0; i < numberOfSuits; i++) {
			int suitIndex = i % allSuits.length;
			Suit suit = allSuits[suitIndex];
			for (int j = 0; j < numberOfRanks; j++) {
				Rank rank = allRanks[j];
				Card card = new Card(rank, suit);
				deckOfCards.add(card);
			}
		}

		assert totalCards == deckOfCards.size();

		shuffle();
	}

	/**
	 * This is additional method, I would like to delete at later stage -
	 * including now as part of requirements.
	 */
	public void shuffle() {
		shuffler.shuffle(deckOfCards);
	}

	/* deal a card from the deck */
	public Card deal() {
		if (dealIndex >= deckOfCards.size()) {
			return null;
		} else {
			Card cardToDeal = deckOfCards.get(dealIndex);
			dealIndex++;
			return cardToDeal;
		}
	}
}

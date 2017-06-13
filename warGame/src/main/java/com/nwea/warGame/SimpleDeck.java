package com.nwea.warGame;

import java.util.ArrayList;
import java.util.List;

public class SimpleDeck implements Deck {

	private final String name;
	private final Shuffler shuffler;
	private final List<Card> deckOfCards = new ArrayList<Card>();

	public SimpleDeck(String name, Shuffler shuffler) {
		super();
		this.name = name;
		this.shuffler = shuffler;
	}

	public Shuffler getShuffler() {
		return shuffler;
	}

	public List<Card> getDeckOfCards() {
		return deckOfCards;
	}

	public String getName() {
		return name;
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

	private int cardIndex = 0;

	/* deal a card from the deck */
	public Card deal() {
		if (cardIndex >= deckOfCards.size()) {
			return null;
		} else {
			Card cardToDeal = deckOfCards.get(cardIndex);
			cardIndex++;
			return cardToDeal;
		}
	}
}

package com.nwea.warGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HandShuffler implements Shuffler {

	@Override
	public void shuffle(List<Card> cardsToShuffle) {
		List<Card> shuffledCards = shuffleInternal(cardsToShuffle);
		shuffleInternal(shuffledCards);
	}

	private List<Card> shuffleInternal(List<Card> cards) {
		// Split the deck
		// Interleave the deck from the two halves
		// 0 - 25
		// 26 - 51

		Random random = new Random();

		List<Card> shuffledCards = new ArrayList<Card>();
		int firstHalfStartIndex = 0;
		int firstHalfEndIndex = 25 + random.nextInt(5);
		int secHalfStartIndex = firstHalfEndIndex + 1;
		int secHalfEndIndex = 51;

		while (firstHalfStartIndex < firstHalfEndIndex + 1 || secHalfStartIndex < secHalfEndIndex + 1) {

			if (firstHalfStartIndex < firstHalfEndIndex + 1) {
				int firstHalfBatch = firstHalfStartIndex + Math.max(1, random.nextInt(3));
				for (int i = firstHalfStartIndex; i < firstHalfBatch; i++) {
					shuffledCards.add(cards.get(i));
					firstHalfStartIndex = i + 1;
					if (firstHalfStartIndex > firstHalfEndIndex) {
						break;
					}
				}
			}

			if (secHalfStartIndex < secHalfEndIndex + 1) {
				int secHalfBatch = secHalfStartIndex + Math.max(1, random.nextInt(3));
				for (int i = secHalfStartIndex; i < secHalfBatch; i++) {
					shuffledCards.add(cards.get(i));
					secHalfStartIndex = i + 1;

					if (secHalfStartIndex > secHalfEndIndex) {
						break;
					}
				}
			}
		}
		return shuffledCards;
	}
}

package cardModel;

import java.util.ArrayList;

public class CardsDeck {
	private ArrayList<Card> cards;

	private String deckName;

	public CardsDeck(String deckName) {
		this.deckName = deckName;
		cards = new ArrayList<Card>();
		reset();
	}

	public String getDeckName() {
		return deckName;
	}

	public void setDeckName(String deckName) {
		this.deckName = deckName;
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void reset() {
		cards.clear();
		for (Suits s : Suits.values()) {
			for (Rank r : Rank.values()) {
				Card c = new Card(s, r);
				cards.add(c);
			}
		}
	}

}

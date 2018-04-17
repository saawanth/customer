package cardShufflerService;

import java.util.List;

import cardModel.Card;

public interface CardShufflerService {
	public List<Card> createDeck(String name);

	public List<Card> Shuffle(String name);

	public List<String> getAvailableDecks();

	public List<Card> viewDeck(String name);

	public void deleteDeck(String name);

}

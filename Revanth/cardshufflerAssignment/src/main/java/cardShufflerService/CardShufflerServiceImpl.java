package cardShufflerService;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import cardModel.Card;
import cardModel.CardsDeck;
import shufflingAlgorithm.ShuffleAlgorithm;

@Service
@Profile("tough")
public class CardShufflerServiceImpl implements CardShufflerService {
	private HashMap<String, List<Card>> deckMap = new HashMap<String, List<Card>>();
	// @Autowired
	// @Qualifier("shufflerAlgorithmSimpleImplementation")
	private ShuffleAlgorithm shuffleAlgorithm;

	public CardShufflerServiceImpl() {
	}

	public ShuffleAlgorithm getShuffleAlgorithm() {
		return shuffleAlgorithm;
	}

	public void setShuffleAlgorithm(ShuffleAlgorithm shuffleAlgorithm) {
		this.shuffleAlgorithm = shuffleAlgorithm;
	}

	public List<Card> createDeck(String name) {
		CardsDeck cardDeck = new CardsDeck(name);
		ArrayList<Card> deck = cardDeck.getCards();
		deckMap.put(name, deck);
		return deck;
	}

	public List<Card> Shuffle(String name) {
		List<Card> list = deckMap.get(name);
		List<Card> shuffledList = shuffleAlgorithm.shuffle(list);
		return shuffledList;
	}

	public List<String> getAvailableDecks() {
		Set<String> availabeDecks = deckMap.keySet();
		List<String> list = new ArrayList<String>(availabeDecks);
		return list;
	}

	public List<Card> viewDeck(String name) {
		List<Card> list = deckMap.get(name);
		return list;
	}

	public void deleteDeck(String name) {
		deckMap.remove(name, deckMap.get(name));
	}
}

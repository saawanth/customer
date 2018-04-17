package CardShufflerController;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import cardModel.Card;
import cardShufflerService.CardShufflerService;

@Controller
public class HomeController {
	@Autowired
	private CardShufflerService cardShufflerService;
	// @Autowired
	// private CardsDeck cardsDeck;

	@RequestMapping("/init")
	public String initCardsDeck() {
		return "init";
	}

	@RequestMapping("/create")
	public String createDeck(@RequestParam("deckName") String deckName, Model model) {
		List<Card> list = cardShufflerService.createDeck(deckName);
		model.addAttribute("deckList", list);
		return "create";
	}

	@RequestMapping("/viewDecks")
	public String viewDeck(Model model) {
		List<String> list = cardShufflerService.getAvailableDecks();
		System.out.println(list);
		model.addAttribute("availableDecks", list);
		return "viewDecks";
	}

	@RequestMapping("/viewCardsInDeckSearch")
	public String searchDeck() {
		return "viewCardsSearch";
	}

	@RequestMapping("/viewCardsInDeck")
	public String viewCardsInDeck(@RequestParam("dckName") String name, Model model) {
		List<Card> list = cardShufflerService.viewDeck(name);
		model.addAttribute("cardsInDeck", list);
		return "viewCardsInDeck";
	}

	@RequestMapping("/deleteDeckSearch")
	public String delDeckSearch() {
		return "delDeckSearch";
	}

	@RequestMapping("/deleteDeck")
	public void deleteDeck(@RequestParam("delDeckName") String name, HttpServletResponse response) {
		cardShufflerService.deleteDeck(name);
		//
		String url = "viewDecks";
		try {
			response.sendRedirect(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/shuffleSearch")
	public String shuffleSearch() {
		return "shuffleSearch";
	}

	@RequestMapping("/shuffle")
	public String shuffle(@RequestParam("shuffleSearch") String name, Model model) {
		List<Card> shuffledList = cardShufflerService.Shuffle(name);
		model.addAttribute("shuffledDeck", shuffledList);
		return "shuffle";
	}

}

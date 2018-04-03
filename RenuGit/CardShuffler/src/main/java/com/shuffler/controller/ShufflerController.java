package com.shuffler.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shuffler.service.CardActions;


@Controller
@RequestMapping("/cardShuffler")
public class ShufflerController {
	
	@Autowired
	private CardActions cardActions;
//create Deck with name
	@RequestMapping("/createDeck")
	public String createDeck() {		
		return "createDeck";
	}
// Obtain the deck name and update hashmap	
	@RequestMapping("/deckCreated")
	public String deckCreated(@RequestParam("deckName") String theName, Model model){
		List<String> cd = cardActions.createDeck(theName);
		model.addAttribute("deckName", cd);
		return "deckCreated";		
	}
//	obtain the name of the deck to be shuffled
	@RequestMapping("/shuffle")
	public String shuffle() {
		return "shuffle";
	}
//	Actually shuffling the deck
	@RequestMapping("/shuffledList")
	public String shuffledList(@RequestParam("deckName") String theName, Model model){
		List<String> cd = cardActions.shuffle(cardActions.deckCurrentOrder(theName));
		model.addAttribute("shuffledList", cd);
		return "shuffledList";		
	}
//Retrieving the decks
	@RequestMapping("/decks")
	public String retreiveDecks(Model model) {
		List<String> cd = cardActions.retreiveDecks();
		model.addAttribute("deckList", cd);
		return "decks";
	}
// Obtain the name of the deck to be retrieved
	@RequestMapping("/deckItems")
	public String deckCurrentOrder() {
		return "deckItems";
	}
//	Retrieving the actual order of the cards in the deck
	@RequestMapping("/retreiveList")
	public String retreiveList(@RequestParam("deckName") String theName, Model model) {
		List<String> cd = cardActions.deckCurrentOrder(theName);
		model.addAttribute("cardList", cd);
		return "deckList";
	}
//Obtaining the request to delete a particular deck
	@RequestMapping("/delete")
	public String delete() {
		return "delete";
	}
//	Actually deleting the deck
	@RequestMapping("/deleteList")
	public String deleteList(@RequestParam("deckName") String theName, Model model) {
		List<String> cd = cardActions.deckCurrentOrder(theName);
		model.addAttribute("delete", cd);
		return "deleteList";
	}
}
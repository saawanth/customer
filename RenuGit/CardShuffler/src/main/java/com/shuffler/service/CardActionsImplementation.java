package com.shuffler.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.shuffler.model.Cards;

@Service
public class CardActionsImplementation implements CardActions {

	HashMap<String, List<String>> variousDecks = new HashMap<String, List<String>>();
	@Autowired
	@Qualifier("shufflerImplementation1")
	private Shuffler shuffler;

	@Override
	public List<String> createDeck(String deckName) {
		Cards cd = new Cards();
		List<String> myDeck = cd.formDeck();
		variousDecks.put(deckName, myDeck);
		System.out.println("Deck created");
		return myDeck;
	}

	@Override
	public List<String> shuffle(List<String> list) {
		return shuffler.shuffle(list);
	}

	@Override
	public List<String> retreiveDecks() {
		Set<String> set = new HashSet<>();
		set = variousDecks.keySet();
		List<String> list = new ArrayList<>(set);
		System.out.println("retreive decks" +list);
		return list;
	}

	@Override
	public List<String> deckCurrentOrder(String name) {
		return variousDecks.get(name);
	}

	@Override
	public List<String> delete(String name) {
		return variousDecks.remove(name);
	}

}

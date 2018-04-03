package com.shuffler.service;

import java.util.List;

public interface CardActions {
	
public List<String> createDeck(String name);
public List<String> shuffle(List<String> list);
public List<String> retreiveDecks();
public List<String> deckCurrentOrder(String name);
public List<String> delete(String name);

}

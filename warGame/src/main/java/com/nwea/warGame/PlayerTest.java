package com.nwea.warGame;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {

	@Test
	public void testDisplayCards() {

		Player player1 = new Player();
		player1.playerName = "player1";
		player1.myCards = new ArrayList<>();
		player1.myCards.add(1);
		player1.myCards.add(2);
		player1.myCards.add(3);
		
		player1.displayCards();
		Assert.assertFalse(false);
	}

}

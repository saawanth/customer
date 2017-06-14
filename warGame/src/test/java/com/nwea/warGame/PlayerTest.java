package com.nwea.warGame;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {

	@Test
	public void testDisplayCards() {

		Player player1 = new Player("Player1");
				
		Assert.assertEquals("Player1", player1.getPlayerName());
		
		Assert.assertFalse(player1.hasCards());
		Assert.assertEquals(0, player1.getCardsSize());
		
		player1.assignCard(new Card(Rank.ACE, Suit.DIAMONDS));
		Assert.assertTrue(player1.hasCards());
		Assert.assertNotNull(player1.getCardsSize());
	}

}

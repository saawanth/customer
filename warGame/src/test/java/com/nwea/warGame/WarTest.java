package com.nwea.warGame;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class WarTest {

	@Test
	public void testCreatePlayers() {

		War game1 = new War();
		
		game1.cardOnTable.create(4, 13);
		Assert.assertEquals(52, game1.cardOnTable.cardDeck.size());
		
		game1.createPlayers(3);
		Assert.assertEquals(3, game1.players.length);

		game1.distributeCards();
		Assert.assertEquals(17, game1.players[0].myCards.size());
		
	}

	@Test
	public void testDistributeCards() {
		War game1 = new War();
		
		game1.cardOnTable.create(4, 13);
		Assert.assertEquals(52, game1.cardOnTable.cardDeck.size());
		
		game1.createPlayers(2);

		game1.distributeCards();
		Assert.assertEquals(26, game1.players[0].myCards.size());
		Assert.assertEquals(26, game1.players[1].myCards.size());
		// Assert.assertEquals(9, game1.players[2].myCards.size());

		game1.createPlayers(5);

		game1.distributeCards();
		Assert.assertEquals(11, game1.players[0].myCards.size());
		Assert.assertEquals(11, game1.players[1].myCards.size());
		Assert.assertNotEquals(9, game1.players[2].myCards.size());
	}
}

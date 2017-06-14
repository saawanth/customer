package com.nwea.warGame;

import org.junit.Assert;
import org.junit.Test;

public class WarTest {

	@Test
	public void testCreatePlayers() {

		War game1 = new War();
		Player[] players = game1.createPlayers(2);
	
		Assert.assertNotNull(players[0]);
		Assert.assertEquals(2, players.length);
		Assert.assertNull(players[0].getNextCard());
		Assert.assertNull(players[1].getNextCard());
	}

	@Test
	public void testInitAndStartGame() {
		War game1 = new War();
		Player[] players = game1.createPlayers(2);
		Assert.assertNull(players[0].getNextCard());
		Assert.assertNull(players[1].getNextCard());
		
		game1.initAndStartGame(2, 13, 2);
		//game1.distributeCards();
		
		Assert.assertNull(players[0].getNextCard());
		Assert.assertNull(players[1].getNextCard());		

	}
	
	
}

package com.nwea.warGame;

import org.junit.Assert;
import org.junit.Test;

public class CardsTest {

	@Test
	public void testCreate() {
		
		Cards deck1 = new Cards();
		deck1.create(2, 13);
		
		Assert.assertNotNull(deck1.cardDeck);
		Assert.assertEquals(26, deck1.cardDeck.size());
		
		deck1.create(1, 10);
		Assert.assertEquals(10, deck1.cardDeck.size());		
	}
	
}

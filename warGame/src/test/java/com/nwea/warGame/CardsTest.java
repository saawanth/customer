package com.nwea.warGame;

import org.junit.Assert;
import org.junit.Test;

public class CardsTest {

	@Test
	public void testCreate() {
		
		Card deck1 = new Card(Rank.ACE, Suit.CLUBS);
		
		Assert.assertNotNull(deck1.getRank());
		Assert.assertNotEquals("", deck1.toString());
		Assert.assertEquals("ACE of CLUBS", deck1.toString());
		
	}
	
}

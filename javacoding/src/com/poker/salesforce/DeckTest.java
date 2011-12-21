package com.poker.salesforce;


import java.util.HashSet;
import java.util.Set;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

public class DeckTest {

	static Set<GamblingCard> testcards;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testcards= new HashSet<GamblingCard>();
		
		for(Suite suite :Suite.values())
		{
			for(Value value:Value.values())
			{
				testcards.add(new GamblingCard(suite, value));				
			}
		}
	}


	@Test
	public void testDeckCount() {
		Deck deck= new Deck();
		Assert.assertEquals(deck.count, 52);
	}
	@Test
	public void testDeckCards() {
		Deck deck= new Deck();
		
		for(Card testcard:testcards)
		{
			Assert.assertTrue(deck.cards.contains(testcard));
		}
	}

	@Test
	public void testShuffle() {
		Deck deck= new Deck();
		Deck deck2= new Deck();
		deck2.cards= deck2.shuffle(deck2.cards);
		Assert.assertTrue(deck.cards.get(1)!=deck2.cards.get(1) ||
				deck.cards.get(2)!=deck2.cards.get(2) ||
				deck.cards.get(3)!=deck2.cards.get(3));
	}

}

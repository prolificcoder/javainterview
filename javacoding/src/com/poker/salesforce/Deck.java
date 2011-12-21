package com.poker.salesforce;

import java.util.ArrayList;
import java.util.List;

public class Deck {
	List<GamblingCard> cards;
	int count;
	List<Joker> jokers;
	//num is number of decks to initialize
	Deck(){
		count=0;
		jokers=null;
		cards= new ArrayList<GamblingCard>();
		for(Suite suite :Suite.values())
		{
			for(Value value:Value.values())
			{
				cards.add(new GamblingCard(suite, value));
				count++;
			}
		}
	}
	public List<GamblingCard> shuffle(List<GamblingCard> cards2)
	{
		int min=0;
		while(min<count)
		{
			int max=count-1;
			int rand= min + (int)(Math.random() * ((max - min) + 1));
			GamblingCard temp=cards2.get(rand);
			cards2.set(rand, cards2.get(min));
			cards2.set(min, temp);
			min++;
		}
		return cards2;
	}

}

package main;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }
    
    public void printHand() {
		for(Card card : cards) {
			System.out.println(card.toString());
		}
	}
    
    public int getHandValue() {
		int sum = 0;
	    int aceCount = 0;

	    for (Card card : cards) {
	    	if(card.getFace().equals("Ace")) {
	    		aceCount++;
	    	}
	    	sum += card.getValue();
	    }

	    while (sum > 21 && aceCount > 0) {
	        sum -= 10;
	        aceCount--;
	    }

	    return sum;

	}



}

package main;

public class Dealer {
    private Hand hand;

	public Dealer() {
		this.hand = new Hand();
	}
	
	public void addCard(Card card) {
		hand.addCard(card);
	}
	
	public int getHandValue() {
		return hand.getHandValue();
	}
	
	public void printHand() {
		hand.printHand();
	}
	
	public boolean estorou() {
		return this.getHandValue() > 21;
	}
	
	public int getTotalCards() {
		return hand.size();
	}

}

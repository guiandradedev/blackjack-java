package main;

public class Player extends Dealer{

	private String name;
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

}

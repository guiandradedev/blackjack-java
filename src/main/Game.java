package main;

import java.util.*;

public class Game {
	private int num_players;
	private DeckOfCards deck;
	private Dealer dealer;
	private List<Player> players;
	
	private Scanner sc;

	public Game(Scanner sc, DeckOfCards deck, int num_players, List<String> names) {
		this.deck = deck;
		this.num_players = num_players;
		this.dealer = new Dealer();
		this.players = new ArrayList<>();
		this.dealCard(dealer, 2);
		this.dealPlayerCards(names);
		
		this.sc = sc;
	}
	
	private void dealCard(Dealer player, int num_cards) {
		for(int i=0; i<num_cards; i++) {
			if(!deck.hasNextCard()) {
				throw new IllegalArgumentException("Cartas esgotadas");
			}
			player.addCard(deck.dealCard());
		}
	}
	
	private void dealPlayerCards(List<String> names) {
		for(int i=0; i<num_players; i++) {
			Player player = new Player(names.get(i));
			players.add(player);
			this.dealCard(player, 2);
		}
	}
	
	private int turn(Dealer player) {
		boolean hasNextCard = true;
		int query = 0, points = 0;
		Card aux;
		do {
			hasNextCard = deck.hasNextCard();
			if(!hasNextCard) {
				System.out.println("O deck esta vazio!");
			}
			
			points = player.getHandValue();
			if(points > 21) {
				System.out.println("Voce estourou!");
			} else if(points == 21) {
				System.out.println("Voce fechou!");
			} else {				
				System.out.println("Deseja continuar [1] ou parar [0]?");
				query = sc.nextInt();
				
				if(query == 1) {
					aux = deck.dealCard();
					player.addCard(aux);
					points = player.getHandValue();
					System.out.println("Carta adicionada: ");
					System.out.println(aux.toString());
					System.out.println("Nova mão:");
					player.printHand();
					System.out.println("Nova pontuação: " + points);
					if(points > 21) {
						System.out.println("Voce estourou!");
					} else if(points == 21) {
						System.out.println("Voce fechou!");
					}
				}
			}
			
		} while(query == 1 && hasNextCard && player.getHandValue() <= 21);
		return player.getHandValue();
	}
	
	public void play() {
		
		for(Player player : players) {
			System.out.println("Jogador: "+player.getName());
			System.out.println("Mão do jogador:");
			player.printHand();
			System.out.println("Pontuação: " + player.getHandValue());
			turn(player);
			System.out.println("Pontuação final: " + player.getHandValue());
			System.out.println("-------------");
		}
		
		System.out.println("Mão do dealer");
		dealer.printHand();
		Card aux;
		while(dealer.getHandValue() < 17) {
			aux = deck.dealCard();
			dealer.addCard(aux);
			System.out.println("Carta adicionada: ");
			System.out.println(aux.toString());
		}
		
		int dealerPoints = dealer.getHandValue();
		
		System.out.println("Pontuação final do dealer: " + dealerPoints);
		if(dealer.estorou()) {
			System.out.println("Dealer estourou!");
		} else {
			System.out.println("Dealer continua!");
		}
		
		Player melhor = players.get(0);
		for(Player player : players) {
			if(player.getHandValue() > melhor.getHandValue()) {
				melhor = player;
			}
		}
				
		if(dealerPoints > melhor.getHandValue() && !dealer.estorou()) {
			System.out.println("Dealer ganhou no geral");
			return;
		}
		
		System.out.println("\nSituação final");
		int player_total, dealer_total = dealer.getTotalCards();
		for(Player player : players) {
			System.out.print(player.getName()+" ");
			if((player.getHandValue() > dealerPoints && !player.estorou()) || (dealer.estorou() && !player.estorou())) {
				System.out.print("Ganhou!");
			} else if(player.getHandValue() == dealerPoints) {
				player_total = player.getTotalCards();
				if(player_total == dealer_total) {					
					System.out.print("Empatou (total de cartas iguais)");
				} else if(player_total > dealer_total) {
					System.out.print("Perdeu (total de cartas maior)");
				} else {
					System.out.print("Ganhou (total de cartas menor)");
				}
			} else {
				System.out.print("Perdeu");
			}
			System.out.print(" - "+player.getHandValue());
			System.out.println();
		}
	}

}

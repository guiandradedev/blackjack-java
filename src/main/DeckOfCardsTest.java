package main;

import java.util.*;

public class DeckOfCardsTest
{
   public static void main(String[] args)
   {
	  Scanner sc = new Scanner(System.in);
	  
      DeckOfCards deckOfCards = new DeckOfCards();
      deckOfCards.shuffle();
            
      System.out.println("Quantos jogadores vao jogar?");
      int players = sc.nextInt();
	  sc.nextLine();
            
      List<String> names = new ArrayList<>();
      for(int i=0; i<players; i++) {
    	  System.out.print("Nome do jogador " + (i+1) + ": ");
    	  names.add(sc.nextLine());
	  }
      
      Game game = new Game(sc, deckOfCards, players, names);
      game.play();
      
      sc.close();      
   } 
}

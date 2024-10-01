//package main;
//
//public class DeckOfCardsTest
//{
//   // execute application
//   public static void main(String[] args)
//   {
//      DeckOfCards myDeckOfCards = new DeckOfCards();
//      myDeckOfCards.shuffle(); // place Cards in random order
//      
//      // print all 52 Cards in the order in which they are dealt
//      for (int i = 1; i <= 52; i++)
//      {
//         // deal and display a Card
//         System.out.printf("%-19s", myDeckOfCards.dealCard());
//
//		 if (i % 4 == 0) // output a newline after every fourth card
//		    System.out.println();
//      } 
//   } 
//} // end class DeckOfCardsTest
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

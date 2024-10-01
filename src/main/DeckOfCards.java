package main;

import java.security.SecureRandom;

public class DeckOfCards
{
   private Card[] deck; // array of Card objects
   private int currentCard; // index of next Card to be dealt (0-51)
   private static final int NUMBER_OF_CARDS = 52; // constant # of Cards
   // random number generator
   private static final SecureRandom randomNumbers = new SecureRandom();

   // [constructor fills deck of Cards
   public DeckOfCards()
   {
      String[] faces = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
      String[] suits = {"♥", "♦", "♣", "♠"};

      deck = new Card[NUMBER_OF_CARDS]; // create array of Card objects
      currentCard = 0; // first Card dealt will be deck[0]

      // populate deck with Card objects
      for (int count = 0; count < deck.length; count++) {    	  
    	  deck[count] = new Card(faces[count % 13], suits[count / 13], cardValue(faces[count % 13]));
      }
   } 
   
   public int cardValue(String card) {
	   int value = 0;
	   switch (card) {
	       case "A":
	           value = 11;
	           break;
	       case "2":
	       case "3":
	       case "4":
	       case "5":
	       case "6":
	       case "7":
	       case "8":
	       case "9":
	       case "10":
	    	   value = Integer.parseInt(card);
	    	   break;
	       case "J":
	       case "Q":
	       case "K":
	    	   value = 10;
	           break;
	       default:
	           break;
	   }
	   
	   return value;
   }

   // shuffle deck of Cards with one-pass algorithm
   public void shuffle()
   {
      // next call to method dealCard should start at deck[0] again
      currentCard = 0; 

      // for each Card, pick another random Card (0-51) and swap them
      for (int first = 0; first < deck.length; first++) 
      {
         // select a random number between 0 and 51 
         int second =  randomNumbers.nextInt(NUMBER_OF_CARDS);
         
         // swap current Card with randomly selected Card
         Card temp = deck[first];        
         deck[first] = deck[second];   
         deck[second] = temp;            
      } 
   } 
   
   public boolean hasNextCard() {
	   return currentCard != (NUMBER_OF_CARDS - 1);
   }

   // deal one Card
   public Card dealCard()
   {
      // determine whether Cards remain to be dealt
      if (currentCard < deck.length)
         return deck[currentCard++]; // return current Card in array
      else        
         return null; // return null to indicate that all Cards were dealt
   } 
} // end class DeckOfCards
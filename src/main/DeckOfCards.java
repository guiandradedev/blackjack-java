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
      String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", 
         "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
      String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

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
	       case "Ace":
	           value = 11; // Considere inicialmente o Ás como 11
	           break;
	       case "Deuce":
	           value = 2;
	           break;
	       case "Three":
	           value = 3;
	           break;
	       case "Four":
	    	   value = 4;
	           break;
	       case "Five":
	    	   value = 5;
	           break;
	       case "Six":
	    	   value = 6;
	           break;
	       case "Seven":
	    	   value = 7;
	           break;
	       case "Eight":
	    	   value = 8;
	           break;
	       case "Nine":
	    	   value = 9;
	           break;
	       case "Ten":
	       case "Jack":
	       case "Queen":
	       case "King":
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
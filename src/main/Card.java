package main;

public class Card 
{
   private final String face; // face of card ("Ace", "Deuce", ...)
   private final String suit; // suit of card ("Hearts", "Diamonds", ...)
   private final int value;

   // two-argument constructor initializes card's face and suit
   public Card(String face, String suit, int value)
   {
      this.face = face;
      this.suit = suit; 
      this.value = value;
   } 
   
   public int getValue() {
	   return this.value;
   }
   
   public String getFace() {
	   return this.face;
   }
   
   public String getSuit() {
	   return this.suit;
   }

   // return String representation of Card
   public String toString() {
		return "+---------+\n"
			 + "| "+ String.format("%-2s",this.face) + "      |\n"	
			 + "|         |\n"
			 + "|         |\n"
			 + "│    " + this.suit + "    │\n"
			 + "|         |\n"
			 + "|         |\n"
			 + "│       " + String.format("%-2s",this.face) + "│\n"
			 + "+---------+\n";
	}

} // end class Card
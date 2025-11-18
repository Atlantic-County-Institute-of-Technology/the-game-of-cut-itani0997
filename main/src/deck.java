import java.util.*;

public class deck {
  Random shuffler = new Random();
  Card[] deck = new Card[52]; 

  public Card[] builddeck() {
    int i = 0;
    for (int suit = 1; suit <= 4; suit++) {
      for (int face = 1; face <= 13; face++) {
        deck[i] = (new Card(face, suit));
        i++;
      }
    }
    return deck;
  }
  public void shuffledeck() {
    for(int i = 0; i < 52; i++) {
      int newPos = shuffler.nextInt(52);
      Card temp = deck[i];
      deck[i] = deck[newPos];
      deck[newPos] = temp;
    }
  }
  public Card fetchCard(int target) {
   return deck[target];
  }
  
  public Card removeCard(int index) {
    Card removedCard = deck[index];
    for (int i = index; i < 51; i++) {
      deck[i] = deck[i + 1];
    }
    deck[51] = null; 
    return removedCard;
  }
  public int getCardsRemaining() {
    int count = 0;
      for (Card card : deck) {
          if (card != null) {
              count++;
          }
      }
    return count;
  }
  public String toString() {
    StringBuilder output = new StringBuilder(" ");
    for (int i = 0; i < 52; i++) {
      if (deck[i] != null) {
        output.insert(0, deck[i] + "\n");
      }
    }
    return "Deck: \n" + output;
  }
}

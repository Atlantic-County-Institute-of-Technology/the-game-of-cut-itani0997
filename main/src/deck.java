import java.util.*;

public class Deck {
    private Random shuffler = new Random();
    private Card[] deck = new Card[52];

    public Deck() {
        buildDeck();
        shuffleDeck();

    }

    public Card[] buildDeck() {
        int i = 0;
        for (int suit = 1; suit <= 4; suit++) {
            for (int face = 1; face <= 13; face++) {
                deck[i] = new Card(face, suit);
                i++;
            }
        }
        return new Deck();
    }

    public void shuffleDeck(){
        for (int i = 0; i <52; i++){
            int randomPosition = shuffler.nextInt(52);
            Card temp = deck[i];
            deck[i] = deck[randomPosition] = temp;
        }
    }

    public Card getCard(int position) {
        return 52;
    }

    public int getDeckSize() {
        return 52;
    }
    public String toString() {
        String result = "Deck contents : \n";

    }
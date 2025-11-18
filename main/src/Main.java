//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;
public class Main {
    public static void main(String[] args) {
        int playerWins = 0;
        int cpuWins = 0;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int round = 1;
        while(playerWins < 3 && cpuWins < 3) {
            deck gameDeck = new deck();
            gameDeck.builddeck();
            gameDeck.shuffledeck();
            System.out.println("ROUND " + round);
            System.out.println("There are " + gameDeck.getCardsRemaining() + " cards in the deck.");
            System.out.print("Choose a card position (1-" + (gameDeck.getCardsRemaining() - 2) + "): ");
            int playerChoice = scanner.nextInt() - 1;
            
            // Player's turn
            Card playerCard = gameDeck.removeCard(playerChoice);
            System.out.println("You cut: " + playerCard);
            // CPU's turn
            int remainingCards = gameDeck.getCardsRemaining() - 1;
            int cpuChoice = random.nextInt(remainingCards);
            Card cpuCard = gameDeck.removeCard(cpuChoice);
            System.out.println("CPU cuts: " + cpuCard);
            
            // Determine winner
            System.out.println("\nComparing cards...");
            if(playerCard.getFace() > cpuCard.getFace()) {
                playerWins++;
                System.out.println("You win this round!");
            } else if(cpuCard.getFace() > playerCard.getFace()) {
                cpuWins++;
                System.out.println("CPU wins this round!");
            } else {
                // Tie - compare suits (Spades=1 > Hearts=2 > Clubs=3 > Diamonds=4)
                if(playerCard.getSuit() < cpuCard.getSuit()) {
                    playerWins++;
                    System.out.println("You win by suit priority!");
                } else {
                    cpuWins++;
                    System.out.println("CPU wins by suit priority!");
                }
            }
            System.out.println("Current Score - Player: " + playerWins + " | CPU: " + cpuWins);
            System.out.println("----------------------------------------\n");
            round++;
        }

        // Final results
        System.out.println("=== FINAL RESULTS ===");
        System.out.println("Player: " + playerWins + " | CPU: " + cpuWins);
        if(playerWins > cpuWins) {
            System.out.println("Congratulations! You won the match!");
        } else {
            System.out.println("CPU won the match. Better luck next time!");
        }
        scanner.close();
    }
}

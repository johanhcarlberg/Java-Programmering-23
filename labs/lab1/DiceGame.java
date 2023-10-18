import java.util.Scanner;

public class DiceGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many rounds would you like to play?");
        int numRounds = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter number of die sides:");
        int dieSides = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter player name:");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);

        player.addDice(dieSides);

        for(int currentRound = 1; currentRound <= numRounds; currentRound++) {
            System.out.println("Round number " + currentRound + "/" + numRounds);
            System.out.println(player);
            System.out.println("Guess die number:");
            int numberGuess = scanner.nextInt();
            scanner.nextLine();

            player.rollDice();

            System.out.println("Player guess was " + numberGuess + " dice value was " + player.getDiceValue());
            if(player.getDiceValue() == numberGuess) {
                System.out.println("Player guess was correct, increasing score.");
                player.increaseScore();
            }
            System.out.println();
        }

        System.out.println("Game over");
        System.out.println("Final score: " + player.getScore());

        scanner.close();
    }
}

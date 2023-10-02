package MultiplayerDiceGame;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MultiplayerDiceGame {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Player> players = initalize(scanner);
        System.out.println("Enter number of dice per player:");
        int numDice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter number of sides per die:");
        int numSides = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter number of turns:");
        int numTurns = scanner.nextInt();
        scanner.nextLine();

        for(Player player : players) {
            player.addDice(numSides, numDice);
        }

        for(int currentTurn = 1; currentTurn <= numTurns; currentTurn++) {
            System.out.println("Turn " + currentTurn + "/" + numTurns);
            takeTurn(players);

            ArrayList<Player> winners = getWinners(players);
            for (Player winner : winners) {
                winner.increaseScore();
            }
        }

        scanner.close();
    }

    private static ArrayList<Player> initalize(Scanner scanner) {
        ArrayList<Player> players = new ArrayList<>();
        System.out.println("Enter number of players:");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();
        
        for(int i = 0; i < numPlayers; i++) {
            System.out.println("Enter player name for player " + (i+1) + ":");
            String playerName = scanner.nextLine();
            Player player = new Player(playerName);
            players.add(player);
        }

        return players;
    }

    private static void takeTurn(ArrayList<Player> players) throws InterruptedException {
        for (Player player : players) {
            System.out.println("Rolling dice for player " + player.getName());
            player.rollDice();
            System.out.println("Player dice value: " + player.getDiceValue());
        }
    }

    private static ArrayList<Player> getWinners(ArrayList<Player> players) {
        ArrayList<Player> winners = new ArrayList<>();
        int maxDiceValue = 0;
        for (Player player : players) {
            int playerDiceValue = player.getDiceValue();
            if (playerDiceValue > maxDiceValue) {
                maxDiceValue = playerDiceValue;
            }
        }

        for (Player player : players) {
            if(player.getDiceValue() == maxDiceValue) {
                winners.add(player);
            }
        }

        return winners;
    }
}

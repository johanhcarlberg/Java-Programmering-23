package PigGame;

import java.util.ArrayList;
import java.util.Scanner;

public class PigGame {
    private static final int MAX_SCORE = 40;

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Player> players = initalize(scanner);

        for (Player player : players) {
            player.addDice(6, 1);
        }

        while (getWinners(players).size() == 0) {
            for (Player player : players) {
                takeTurn(player, scanner);
                if (getWinners(players).size() > 0) {
                    break;
                }
            }
        }

        System.out.println("Game over!");
        System.out.println(getWinners(players).get(0).getName() + " wins!");

        scanner.close();
    }

    private static ArrayList<Player> initalize(Scanner scanner) {
        ArrayList<Player> players = new ArrayList<>();
        System.out.println("Enter number of players:");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Enter player name for player " + (i + 1) + ":");
            String playerName = scanner.nextLine();
            Player player = new Player(playerName);
            players.add(player);
        }

        return players;
    }

    private static void takeTurn(Player player, Scanner scanner) throws InterruptedException {
        while (true) {
            System.out.println("Rolling dice for player " + player.getName());
            player.rollDice();
            System.out.println("Player dice value: " + player.getDiceValue());

            if (player.getDiceValue() == 1) {
                player.setScore(0);
                return;
            }

            player.increaseScore(player.getDiceValue());
            System.out.println("Player score: " + player.getScore());
            if (player.getScore() >= MAX_SCORE) {
                return;
            }

            String continueInput;
            while (true) {
                System.out.println("Continue (y/n)?");
                continueInput = scanner.nextLine().toLowerCase();
                if (continueInput.equals("y")) {
                    break;
                }

                if (continueInput.equals("n")) {
                    return;
                }
            }
        }
    }

    private static ArrayList<Player> getWinners(ArrayList<Player> players) {
        ArrayList<Player> winners = new ArrayList<>();
        for (Player player : players) {
            int playerScore = player.getScore();
            if (playerScore >= MAX_SCORE) {
                winners.add(player);
                return winners;
            }
        }

        return winners;
    }
}

package MultiplayerDiceGame;

import java.util.ArrayList;

public class Player {
    private ArrayList<Die> dice;
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.dice = new ArrayList<>();
    }

    public void rollDice() {
        for (Die die : this.dice) {
            die.roll();
        }
    }

    public void addDice(int sides, int numDice) {
        for(int i = 0; i < numDice; i++) {
            this.dice.add(new Die(sides));
        }
    }

    public int getDiceValue() {
        int diceSum = 0;
        for (Die die : this.dice) {
            diceSum += die.getCurrentValue();
        }
        
        return diceSum;
    }

    public void increaseScore(int scoreToAdd) {
        this.score += scoreToAdd;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name + " - Score: " + this.score;
    }
}

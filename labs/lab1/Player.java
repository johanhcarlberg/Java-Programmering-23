public class Player {
    private Die die;
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public void rollDice() {
        this.die.roll();
    }

    public void addDice(int sides) {
        this.die = new Die(sides);
    }

    public int getDiceValue() {
        return this.die.getCurrentValue();
    }

    public Die getDie() {
        return this.die;
    }

    public void increaseScore() {
        this.score += 1;
    }

    public int getScore() {
        return this.score;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name + " - Score: " + this.score;
    }
}

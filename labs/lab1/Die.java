import java.util.Random;

public class Die {
    private int sides;
    private Random random;
    private int currentValue;

    public Die(int sides) {
        this.sides = sides;
        this.random = new Random();
        this.roll();
    }

    public int getSides() {
        return this.sides;
    }

    public int getCurrentValue() {
        return this.currentValue;
    }

    public void roll() {
        int newValue = random.nextInt(sides) + 1;
        this.currentValue = newValue;
    }
}
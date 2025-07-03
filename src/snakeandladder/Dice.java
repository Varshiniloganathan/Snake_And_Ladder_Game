package snakeandladder;

import java.util.Random;

public class Dice {
    private Random random;
    
    public Dice() {
        random = new Random();
    }
    
    public int roll() {
        return random.nextInt(6) + 1; // 1-6
    }
    
    // For testing
    public void setFixedRoll(int value) {
        // Implementation for testing
    }
}
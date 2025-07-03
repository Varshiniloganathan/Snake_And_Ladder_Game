package snakeandladder;

public class Player {
    private String name;
    private int position;
    
    // Constructor - removed unused position parameter
    public Player(String name) {
        this.name = name;
        this.position = 0;  // All players start at position 0
    }
    
    // Getter methods
    public String getName() {
        return name;
    }
    
    public int getPosition() {
        return position;
    }
    
    // Setter method - changed to void
    public void setPosition(int position) {
        // Optional: Add validation
        if (position >= 0) {
            this.position = position;
        }
    }
    
    // Move method
    public void move(int steps) {
        this.position += steps;
    }
}
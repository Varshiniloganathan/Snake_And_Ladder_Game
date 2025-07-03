package snakeandladder;

import java.util.Scanner;

public class Game {
    private Player[] players;
    private Board board;
    private Dice dice;
    private Scanner scanner;
    
    public Game() {
        scanner = new Scanner(System.in);
        board = new Board();
        dice = new Dice();
    }
    
    public void initializePlayers() {
        System.out.print("Enter number of players: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        if (numPlayers <= 0) {
            System.out.println("Invalid number of players!");
            return;
        }
        
        players = new Player[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            System.out.printf("Enter name for player %d: ", i+1);
            players[i] = new Player(scanner.nextLine());
        }
    }
    
    public void start() {
        System.out.println("\n GAME STARTED....LET'S START CLIMB!");
        try {
            while (true) {
                for (Player player : players) {
                    playTurn(player);
                    if (board.isWin(player.getPosition())) {
                        System.out.printf("\n%s wins!%n", player.getName());
                        return;
                    }
                }
            }
        } finally {
            closeGame();
        }
    }
    
    private void playTurn(Player player) {
        System.out.printf("\n%s's turn (Position: %d)%n", 
            player.getName(), player.getPosition());
        System.out.print("Press ENTER to roll...");
        scanner.nextLine();
        System.out.println("************************");
        int roll = dice.roll();
        System.out.println("-------------------------");
        System.out.printf("DICE ROLLED: %d%n", roll);
        System.out.println("-------------------------");
        int newPosition = player.getPosition() + roll;
        System.out.println();
        
        System.out.println(player.getName() + " new position: " + newPosition);
        System.out.println("************************");
        if (newPosition > 100) {
            System.out.println("!!!!! Need exact roll to win !!!!!!");
            return;
        }
        
        int finalPosition = board.checkSnakeOrLadder(newPosition);
        player.setPosition(finalPosition);
    }
    
    public void closeGame() {
        scanner.close();
    }
}
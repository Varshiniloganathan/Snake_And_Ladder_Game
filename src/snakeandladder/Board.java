package snakeandladder;

public class Board {
    private static final int WINNING_POSITION = 100;
    private static final int[][] SNAKES = {{99,41}, {95,75}, {76,58}};
    private static final int[][] LADDERS = {{4,25}, {9,31}, {28,84}};
     public int checkSnakeOrLadder(int position) {
        for (int[] snake : SNAKES) {
            if (snake[0] == position) {
                System.out.printf("$$$ Snake bite! %d --> %d%n", position, snake[1]);
                return snake[1];
            }
        }
    
        for (int[] ladder : LADDERS) {
            if (ladder[0] == position) {
                System.out.printf("### Ladder climb! %d --> %d%n", position, ladder[1]);
                return ladder[1];
            }
        }
        return position;
    }
     public boolean isWin(int position) {
        return position >= WINNING_POSITION;
    }
}


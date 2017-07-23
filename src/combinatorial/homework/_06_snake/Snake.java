package combinatorial.homework._06_snake;

import java.util.HashSet;
import java.util.Set;

/**
 * 23/07/2017
 */
public class Snake {

    private static Set<String> visited = new HashSet<>();
    private static Set<String> snakes = new HashSet<>();
    private static int size = 3;
    private static char[] currentSnake = new char[size];

    public void gen(int index, int row, int col, char direction) {

        if (index >= size) {
            // found
            if (!snakes.contains(String.valueOf(currentSnake))) {
                printSnake();
                snakes.add(String.valueOf(currentSnake));
            }

        } else {
            //PRiority R D L U
            String currentCell = row + " " + col;


            if (!visited.contains(currentCell)) {

                visited.add(currentCell);
                currentSnake[index] = direction;

                gen(index + 1, row, col + 1, 'R');
                gen(index + 1, row - 1, col, 'D');
                gen(index + 1, row, col - 1, 'L');
                gen(index + 1, row + 1, col, 'U');
                visited.remove(currentCell);
            }

        }

    }

    public void printSnake() {
        for (char c : currentSnake) {
            System.out.print(c);
        }
        System.out.println();
    }
}

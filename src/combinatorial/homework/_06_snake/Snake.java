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
                markSnake(currentSnake);
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

    public void markSnake(char[] currentSnake) {

        char[] flipped = flip(currentSnake);
        char[] reversed = reverse(currentSnake);
        char[] flippedReversed = flip(reversed);

        for (int i = 0; i < 4; i++) {
            currentSnake = rotate(currentSnake);
            snakes.add(new String(currentSnake));
        }

        for (int i = 0; i < 4; i++) {
            flipped = rotate(flipped);
            snakes.add(new String(flipped));
        }

        for (int i = 0; i < 4; i++) {
            reversed = rotate(reversed);
            snakes.add(new String(reversed));
        }

        for (int i = 0; i < 4; i++) {
            flippedReversed = rotate(flippedReversed);
            snakes.add(new String(flippedReversed));
        }
        System.out.println();
    }

    private char[] rotate(char[] currentSnake) {
        int length = currentSnake.length;

        for (int i = 0; i < length; i++) {
            switch (currentSnake[i]) {
                case 'R':
                    currentSnake[i] = 'D';
                    break;
                case 'D':
                    currentSnake[i] = 'L';
                    break;
                case 'L':
                    currentSnake[i] = 'U';
                    break;
                case 'U':
                    currentSnake[i] = 'R';
            }
        }
        return currentSnake;
    }

    private char[] reverse(char[] currentSnake) {

        char[] reversed = new char[currentSnake.length];
        reversed[0] = 'S';
        for (int i = 1; i < currentSnake.length; i++) {
            reversed[i] = currentSnake[currentSnake.length - i];
        }

        return reversed;
    }

    private char[] flip(char[] currentSnake) {
        char[] flipped = new char[currentSnake.length];

        for (int i = 0; i < currentSnake.length; i++) {
            if ('U' == currentSnake[i]) {
                flipped[i] = 'D';
            } else if ('D' == currentSnake[i]) {
                flipped[i] = 'U';
            } else {
                flipped[i] = currentSnake[i];
            }
        }
        return flipped;
    }

    public void printSnake() {
        for (char c : currentSnake) {
            System.out.print(c);
        }
        System.out.println();
    }
}

package combinatorial.homework._06_snake;

/**
 * 23/07/2017
 */
public class Main {

    public static void main(String[] args) {

        Snake snake = new Snake();

        snake.markSnake(new char[]{'S','R','R','D'});

        snake.gen(0, 0, 0, 'S');
    }
}

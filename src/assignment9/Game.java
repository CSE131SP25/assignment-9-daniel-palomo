package assignment9;

import java.awt.event.KeyEvent;
import edu.princeton.cs.introcs.StdDraw;

public class Game {

    private Snake snake;
    private Food food;
    private int score; // Added for score tracking (optional extra)

    public Game() {
        StdDraw.enableDoubleBuffering();
        snake = new Snake();
        food = new Food();
        score = 0; // Initialize score
    }

    public void play() { //7. play() method handles collision, movement, food 
        while (snake.isInbounds() && !snake.hasCollidedWithSelf()) { // 4. Check wall and self collision conditions, otherwise game ends
            int dir = getKeypress();

            if (dir != -1) {
                snake.changeDirection(dir);
            }

            snake.move();

            if (snake.eat(food)) {
                food = new Food(); //3. after snake.eat(food) returns true, food = new Food(); spawns it in a random inbound location 
                score++; // 5. Increase score when food is eaten
            }

            updateDrawing();

            StdDraw.pause(100); // Game speed
        }

        // Game Over Screen
        StdDraw.clear(StdDraw.BLACK);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.text(0.5, 0.6, "Game Over!");
        StdDraw.text(0.5, 0.5, "Final Score: " + score);
        StdDraw.show();

        System.out.println("Game Over! Final Score: " + score);
    }

    private int getKeypress() {
        if (StdDraw.isKeyPressed(KeyEvent.VK_W)) {
            return 1; // Up
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
            return 2; // Down
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
            return 3; // Left
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
            return 4; // Right
        } else {
            return -1; // No key pressed
        }
    }

    private void updateDrawing() {
        StdDraw.clear();
        snake.draw();
        food.draw();

        // Optional: Draw the score on screen
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.textLeft(0.05, 0.95, "Score: " + score);

        StdDraw.pause(5);
        StdDraw.show();
    }

    public static void main(String[] args) {
        Game g = new Game();
        g.play();
    }
}

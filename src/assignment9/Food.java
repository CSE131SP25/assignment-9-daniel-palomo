package assignment9;

import java.awt.Color;
import edu.princeton.cs.introcs.StdDraw;

public class Food {

    public static final double FOOD_SIZE = 0.02; // Size of the food
    private double x, y; // Coordinates of the food

    /**
     * Creates a new Food at a random location, ensuring it stays fully within bounds.
     */
    public Food() {
        // Ensure food does not spawn partially out of bounds
        this.x = FOOD_SIZE + (1 - 2 * FOOD_SIZE) * Math.random();
        this.y = FOOD_SIZE + (1 - 2 * FOOD_SIZE) * Math.random();
    }

    /**
     * Draws the Food
     */
    public void draw() {
        StdDraw.setPenColor(Color.RED);
        StdDraw.filledCircle(x, y, FOOD_SIZE);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

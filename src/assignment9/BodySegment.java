package assignment9;

import java.awt.Color;
import edu.princeton.cs.introcs.StdDraw;

public class BodySegment {

    private double x, y, size;
    private Color color;

    /**
     * Creates a BodySegment with the given position and size.
     *
     * @param x    x-coordinate of the segment
     * @param y    y-coordinate of the segment
     * @param size radius of the segment
     */
    public BodySegment(double x, double y, double size) {
        this.x = x;
        this.y = y;
        this.size = size;

        // Pick a default color or generate one from a predefined list
        this.color = generateColor();
    }

    /**
     * Generates a random color or selects one from a predefined list.
     *
     * @return A Color instance
     */
    private Color generateColor() {
        // Define an array of possible colors
        Color[] colors = {Color.GREEN, Color.BLUE, Color.ORANGE, Color.YELLOW};
        // Randomly pick one from the array
        int index = (int) (Math.random() * colors.length);
        return colors[index];
    }

    /**
     * Draws the segment.
     */
    public void draw() {
        StdDraw.setPenColor(color); // Set the segment's color
        StdDraw.filledCircle(x, y, size); // Draw the circle at (x, y) with the given size
    }

	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}
	
	public double getY() {
		// TODO Auto-generated method stub
		return y;
	}
}


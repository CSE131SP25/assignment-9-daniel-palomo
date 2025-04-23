package assignment9;

import java.util.LinkedList;

public class Snake {

    private static final double SEGMENT_SIZE = 0.02;
    private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
    private LinkedList<BodySegment> segments;
    private double deltaX;
    private double deltaY;
    private int direction;
    private boolean shouldGrow = false;

    public Snake() {
        segments = new LinkedList<>();
        segments.add(new BodySegment(0.5, 0.5, SEGMENT_SIZE)); // starting at position (0.5, 0.5)
        direction = 4; // Default direction is to the right
    }

    public void changeDirection(int direction) {
        if ((this.direction == 1 && direction == 2) || // up → down
            (this.direction == 2 && direction == 1) || // down → up
            (this.direction == 3 && direction == 4) || // left → right
            (this.direction == 4 && direction == 3)) { // right → left
            return; // Do nothing — this is a reversal
        }

        this.direction = direction;

        if (direction == 1) { // up
            deltaY = MOVEMENT_SIZE;
            deltaX = 0;
        } else if (direction == 2) { // down
            deltaY = -MOVEMENT_SIZE;
            deltaX = 0;
        } else if (direction == 3) { // left
            deltaY = 0;
            deltaX = -MOVEMENT_SIZE;
        } else if (direction == 4) { // right
            deltaY = 0;
            deltaX = MOVEMENT_SIZE;
        }
    }

    public void move() { //6. A new head segment is added, and if snake is not growing, the last segment is removed
        BodySegment head = segments.getFirst();
        double newX = head.getX() + deltaX;
        double newY = head.getY() + deltaY;

        segments.addFirst(new BodySegment(newX, newY, SEGMENT_SIZE));

        if (shouldGrow) {
            shouldGrow = false;
        } else {
            segments.removeLast();
        }
    }

    public void draw() {
        for (BodySegment segment : segments) {
            segment.draw();
        }
    }

    public boolean eat(Food f) {
        BodySegment head = segments.getFirst(); 
        if (Math.abs(head.getX() - f.getX()) < SEGMENT_SIZE &&
            Math.abs(head.getY() - f.getY()) < SEGMENT_SIZE) {
            shouldGrow = true; 
            return true; //2. Returns true if snake head overlaps true 
        }
        return false;
    }

    public boolean isInbounds() {
        BodySegment head = segments.getFirst();
        return head.getX() >= 0 && head.getX() <= 1 && head.getY() >= 0 && head.getY() <= 1;
    }

    public boolean hasCollidedWithSelf() { //5. Creative portion 
        BodySegment head = segments.getFirst();
        double headX = head.getX();
        double headY = head.getY();

        for (int i = 1; i < segments.size(); i++) {
            BodySegment segment = segments.get(i);
            if (Math.abs(headX - segment.getX()) < SEGMENT_SIZE &&
                Math.abs(headY - segment.getY()) < SEGMENT_SIZE) {
                return true; //Returns true if head collides with body
            }
        }
        return false;
    }
}

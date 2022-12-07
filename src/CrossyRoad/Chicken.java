package CrossyRoad;

import edu.macalester.graphics.*;
import edu.macalester.graphics.events.Key;
import edu.macalester.graphics.events.KeyboardEvent;

/**
 * Chicken class creates a chicken image that can be added to a canvas.
 */
public class Chicken extends Image {

    private static final double CHICKEN_HEIGHT = 50;
    private static final double CHICKEN_WIDTH = 50;
    private double x;
    private double y;

    /**
     * Chicken constructer, sets image, size and position for chicken
     * 
     * @param x x position
     * @param y y position
     */
    public Chicken(double x, double y) {
        super(x, y);
        this.x = x;
        this.y = y;
        setImagePath("chicken.png");
        setMaxHeight(CHICKEN_HEIGHT);
        setMaxWidth(CHICKEN_WIDTH);
    }

    /**
     * This method moves the chicken, up, down, left or right It checks to see if there are not
     * instances of ellipse or images before moving
     * 
     * @param canvas    chicken is on
     * @param event     that occurs
     * @param animation true if game running, false if game ends
     */
    public void move(CanvasWindow canvas, KeyboardEvent event, boolean animation) {
        if (event.getKey() == Key.LEFT_ARROW && animation) {
            if (!(canvas.getElementAt(getChicken().getCenter().getX() - 70,
                getChicken().getCenter().getY()) instanceof Ellipse) &&
                !(canvas.getElementAt(getChicken().getCenter().getX() - 70,
                    getChicken().getCenter().getY()) instanceof Image)) {
                setImagePath("chicken.png");
                moveLeft();
            }
        } else if (event.getKey() == Key.RIGHT_ARROW && animation) {
            if (!(canvas.getElementAt(getChicken().getCenter().getX() + 70,
                getChicken().getCenter().getY()) instanceof Ellipse) &&
                !(canvas.getElementAt(getChicken().getCenter().getX() + 70,
                    getChicken().getCenter().getY()) instanceof Image)) {
                setImagePath("rightfacingchicken.png");
                moveRight();
            }
        } else if (event.getKey() == Key.DOWN_ARROW && animation) {
            if (!(canvas.getElementAt(getChicken().getCenter().getX(),
                getChicken().getCenter().getY() + 70) instanceof Ellipse) &&
                !(canvas.getElementAt(getChicken().getCenter().getX(),
                    getChicken().getCenter().getY() + 70) instanceof Image)
                &&
                getChicken().getY() < 600) {
                moveDown();
            }
        }
    }

    /**
     * Moves chicken left
     */
    public void moveLeft() {
        if (x > 70) {
            x -= 70;
            setPosition(x, y);
        }
    }

    /**
     * Moves chicken right
     */
    public void moveRight() {
        if (x < CrossyRoad.CANVAS_WIDTH - 3 * CHICKEN_WIDTH) {
            x += 70;
            setPosition(x, y);
        }
    }

    /**
     * Moves chicken up
     */
    public void moveUp() {
        y -= 70;
        setPosition(x, y);
    }

    /**
     * Moves chicken down
     */
    public void moveDown() {
        y += 70;
        setPosition(x, y);
    }

    /**
     * Adds chicken to provided canvas
     * 
     * @param canvas
     */
    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(this);
    }

    /**
     * @return this chicken
     */
    public Image getChicken() {
        return this;
    }

    /**
     * This method checks for collisions of chicken with cars and returns true if there is It sees if
     * the width is equal to 60 (the width of the cars) to determine the collision
     * 
     * @param c canvas chicken is on
     */
    public boolean checkCollision(CanvasWindow c) {
        if (c.getElementAt(getX() + CHICKEN_WIDTH + 1, getCenter().getY()).getWidth() == 60 ||
            c.getElementAt(getX() - 1, getCenter().getY()).getWidth() == 60 ||
            c.getElementAt(getX() + CHICKEN_WIDTH / 2, getY() - 1).getWidth() == 60 ||
            c.getElementAt(getX() + CHICKEN_WIDTH / 2, getY() + CHICKEN_HEIGHT + 1).getWidth() == 60) {
            return true;
        } else {
            return false;
        }
    }
}

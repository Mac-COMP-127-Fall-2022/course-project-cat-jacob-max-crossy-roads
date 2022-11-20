package CrossyRoad;

import edu.macalester.graphics.*;

public class Chicken {


    private static final double CHICKEN_HEIGHT = 50;
    private static final double CHICKEN_WIDTH = 50;
    private Image chicken;
    private double x;
    private double y;

    // private CanvasWindow canvas;

    public Chicken(double x, double y) {
        this.x = x;
        this.y = y;

        chicken = new Image(x, y);
        chicken.setImagePath("chicken.png");
        chicken.setMaxHeight(CHICKEN_HEIGHT);
        chicken.setMaxWidth(CHICKEN_WIDTH);
        // canvas.add(chicken);
        // addToCanvas(canvas);

    }

    public void moveLeft() {
        // double moveX = point.getX();
        if (x > 70) {
            x -= 70;
            chicken.setPosition(x, y);
        }

    }

    public void moveRight() {
        if (x < CrossyRoad.CANVAS_WIDTH - 3 * CHICKEN_WIDTH) {
            x += 70;
            chicken.setPosition(x, y);
        }

    }

    public void moveUp() {
        y -= 70;
        chicken.setPosition(x, y);

    }

    public void moveDown() {
        y+= 70;
        chicken.setPosition(x, y);
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(chicken);
    }

    public Image getChicken() {
        return chicken;
    }

}

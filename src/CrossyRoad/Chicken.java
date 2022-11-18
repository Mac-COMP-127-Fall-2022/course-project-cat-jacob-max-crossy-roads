package CrossyRoad;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;

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
        if (x > 0) {
            x -= 70;
            chicken.setPosition(x, y);
        }

    }

    public void moveRight() {
        if (x <= CrossyRoad.CANVAS_WIDTH - 2 * CHICKEN_WIDTH) {
            x += 70;
            chicken.setPosition(x, y);
        }

    }

    public void moveUp() {
        y -= 50;
        chicken.setPosition(x, y);

    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(chicken);
    }

    public Image getChicken() {
        return chicken;
    }

}

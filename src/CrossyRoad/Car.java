package CrossyRoad;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;

public class Car extends GraphicsGroup {

    private static final double CAR_WIDTH = 60;
    private static final double CAR_HEIGHT = 60;
    private Rectangle topBody;
    private Rectangle bottomBody;
    // private Rectangle size;
    private Ellipse leftWheel;
    private Ellipse rightWheel;
    private GraphicsGroup carGroup;

    public Car(double x, double y) {
        carGroup = new GraphicsGroup(x, y);
        buildCar();
    }

    private void buildCar() {

        // to test proportions:
        // size = new Rectangle(0,0,CAR_WIDTH, CAR_HEIGHT);
        // carGroup.add(size);

        topBody = new Rectangle(CAR_WIDTH / 4, CAR_HEIGHT / 8, CAR_WIDTH * 3 / 4, CAR_HEIGHT / 2);
        topBody.setStrokeColor(Color.RED.darker());
        topBody.setFillColor(Color.RED.darker());
        carGroup.add(topBody);

        bottomBody = new Rectangle(0, CAR_HEIGHT / 3, CAR_WIDTH, CAR_HEIGHT / 2);
        bottomBody.setStrokeColor(Color.RED.darker());
        bottomBody.setFillColor(Color.RED.darker());
        carGroup.add(bottomBody);

        leftWheel = new Ellipse(CAR_WIDTH / 30, CAR_HEIGHT * 5 / 8, CAR_WIDTH / 3, CAR_HEIGHT / 3);
        leftWheel.setStrokeColor(Color.BLACK);
        leftWheel.setFillColor(Color.BLACK);
        carGroup.add(leftWheel);

        rightWheel = new Ellipse(CAR_WIDTH * 5 / 8, CAR_HEIGHT * 5 / 8, CAR_WIDTH / 3, CAR_HEIGHT / 3);
        rightWheel.setStrokeColor(Color.BLACK);
        rightWheel.setFillColor(Color.BLACK);
        carGroup.add(rightWheel);
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(carGroup);
    }

}

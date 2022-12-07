package CrossyRoad;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.macalester.graphics.*;

/**
 * Car class creates a left or right facing car that can be added to a canvas. Car can be animated
 * to make it "drive" across a canvas
 */
public class Car extends GraphicsGroup {

    private static final double CAR_WIDTH = 60;
    private static final double CAR_HEIGHT = 60;
    private Rectangle topBody;
    private Rectangle bottomBody;
    private Ellipse leftWheel;
    private Ellipse rightWheel;
    private double x;
    private double carSpeed;
    private Random rand = new Random();

    /**
     * Car constructer, sets car's position and speed and creates it
     * 
     * @param x        x position
     * @param y        y position
     * @param carSpeed car's speed moving across canvas
     */
    public Car(double x, double y, double carSpeed) {
        super(x, y);
        this.x = x;
        this.carSpeed = carSpeed;
        if (x > 0) {
            buildLeftFacingCar();
        } else {
            buildRightFacingCar();
        }
    }

    /**
     * Builds a car facing the left direction
     */
    private void buildLeftFacingCar() {

        List<Color> moColors = colorList();
        int x = rand.nextInt(10);
        Color useColors = moColors.get(x);

        topBody = new Rectangle(CAR_WIDTH / 4, CAR_HEIGHT / 8, CAR_WIDTH * 3 / 4, CAR_HEIGHT / 2);
        topBody.setStrokeColor(useColors);
        topBody.setFillColor(useColors);
        this.add(topBody);

        bottomBody = new Rectangle(0, CAR_HEIGHT / 3, CAR_WIDTH, CAR_HEIGHT / 2);
        bottomBody.setStrokeColor(useColors);
        bottomBody.setFillColor(useColors);
        this.add(bottomBody);

        leftWheel = new Ellipse(CAR_WIDTH / 30, CAR_HEIGHT * 5 / 8, CAR_WIDTH / 3, CAR_HEIGHT / 3);
        leftWheel.setStrokeColor(Color.BLACK);
        leftWheel.setFillColor(Color.BLACK);
        this.add(leftWheel);

        rightWheel = new Ellipse(CAR_WIDTH * 5 / 8, CAR_HEIGHT * 5 / 8, CAR_WIDTH / 3, CAR_HEIGHT / 3);
        rightWheel.setStrokeColor(Color.BLACK);
        rightWheel.setFillColor(Color.BLACK);
        this.add(rightWheel);
    }

    /**
     * Builds a car facing the right direction
     */
    private void buildRightFacingCar() {

        List<Color> moColors = colorList();
        int x = rand.nextInt(10);
        Color useColors = moColors.get(x);

        topBody = new Rectangle(0, CAR_HEIGHT / 8, CAR_WIDTH * 3 / 4, CAR_HEIGHT / 2);
        topBody.setStrokeColor(useColors);
        topBody.setFillColor(useColors);
        this.add(topBody);

        bottomBody = new Rectangle(0, CAR_HEIGHT / 3, CAR_WIDTH, CAR_HEIGHT / 2);
        bottomBody.setStrokeColor(useColors);
        bottomBody.setFillColor(useColors);
        this.add(bottomBody);

        leftWheel = new Ellipse(CAR_WIDTH / 30, CAR_HEIGHT * 5 / 8, CAR_WIDTH / 3, CAR_HEIGHT / 3);
        leftWheel.setStrokeColor(Color.BLACK);
        leftWheel.setFillColor(Color.BLACK);
        this.add(leftWheel);

        rightWheel = new Ellipse(CAR_WIDTH * 5 / 8, CAR_HEIGHT * 5 / 8, CAR_WIDTH / 3, CAR_HEIGHT / 3);
        rightWheel.setStrokeColor(Color.BLACK);
        rightWheel.setFillColor(Color.BLACK);
        this.add(rightWheel);
    }

    /**
     * Method for animating the car, removes the car from the canvas once it drives out of the x bounds.
     * 
     * @param dt     change in time
     * @param canvas canvas the car is on
     */
    public void animateCar(double dt, CanvasWindow canvas) {
        if (this.getPosition().getX() > 700 && x == -40) {
            this.removeAll();
        } else if (this.getPosition().getX() < -40 && x == 740) {
            this.removeAll();
        } else {
            this.moveBy((x == -40 ? dt * carSpeed : -dt * carSpeed), 0);
        }
    }

    /**
     * Creates a list of colors for the cars
     * 
     * @return list of colors
     */
    public List<Color> colorList() {
        List<Color> colors = new ArrayList<>();
        colors.add(new Color(225, 49, 49));
        colors.add(new Color(225, 96, 49));
        colors.add(new Color(225, 131, 49));
        colors.add(new Color(225, 194, 49));
        colors.add(new Color(202, 225, 49));
        colors.add(new Color(124, 225, 49));
        colors.add(new Color(54, 225, 49));
        colors.add(new Color(49, 225, 170));
        colors.add(new Color(49, 186, 225));
        colors.add(new Color(49, 119, 225));
        return colors;
    }

}

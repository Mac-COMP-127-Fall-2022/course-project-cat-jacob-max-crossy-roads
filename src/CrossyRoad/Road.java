package CrossyRoad;

import java.awt.Color;
import java.util.ArrayList;
import edu.macalester.graphics.*;

/**
 * Road class extends Row abstract class. Creates a gray row with lines that cars can be added to.
 * Moves down according to chicken movement.
 */
public class Road extends Row {
    private double y;
    private ArrayList<Car> cars;
    private double direction;
    private double carSpeed;
    public Car car;

    /**
     * Constructor for the road class, it adds cars to an array list and adds them to each independent
     * row, cars in the row have the same speed but different rows have different speed.
     * 
     * @param y position
     */
    public Road(double y) {
        super(Color.DARK_GRAY, y);
        cars = new ArrayList<Car>();
        this.y = y;
        drawLines(y);
        direction = (Math.random() > .5 ? 740 : -40);
        carSpeed = 50 + Math.random() * 50;
        addCar(carSpeed);
    }

    /**
     * Draws lines on Road row
     * 
     * @param y position
     */
    private void drawLines(double y) {
        for (int x = 5; x < 700; x += ROW_WIDTH / 15 + 35) {
            Rectangle line = new Rectangle(x, y + ROW_HEIGHT / 2, ROW_WIDTH / 18, ROW_HEIGHT / 20);
            line.setFillColor(Color.YELLOW);
            line.setFilled(true);
            super.add(line);
        }
    }

    /**
     * Adds a car to the road according to the random direction set and the speed set for this road
     * 
     * @param carSpeed of cars on this road
     */
    public void addCar(double carSpeed) {
        if (Math.random() >= .1) {
            Car car = new Car(direction, y, carSpeed);
            if (carNotInside(car)) {
                this.add(car);
                cars.add(car);
            }
        }
    }

    /**
     * Method that checks for cars to appear on canvas ontop of eachother
     * 
     * @param car to check for on this road
     */
    public boolean carNotInside(Car car) {
        for (Car vehicle : cars) {
            if ((direction > 0 ? vehicle.getX() + vehicle.getWidth() > 670 : vehicle.getX() < 30)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @return cars list on this road
     */
    public ArrayList<Car> getCars() {
        return cars;
    }

    /**
     * @return carSpeed of this road
     */
    public double getCarSpeed() {
        return carSpeed;
    }

}

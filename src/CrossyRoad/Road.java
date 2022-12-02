package CrossyRoad;

import java.awt.Color;
import java.beans.VetoableChangeListener;
import java.util.ArrayList;

import edu.macalester.graphics.*;


public class Road extends Row {
    double y;
    private ArrayList<Car> cars;
    double direction;
    double carSpeed;
    Car car;
    CanvasWindow canvas;

    public Road(double y) {
        super(Color.DARK_GRAY, y);
        cars = new ArrayList<Car>();
        this.y = y;
        drawLines(y);
        direction = (Math.random()>.5 ? 740 : -40);
        carSpeed = 50+ Math.random()*50;
        addCar(carSpeed);

    }

    private void drawLines(double y) {

        for (int x = 5; x < 700; x += ROW_WIDTH / 15 + 35) {
            Rectangle line = new Rectangle(x, y + ROW_HEIGHT / 2, ROW_WIDTH / 18, ROW_HEIGHT / 20);
            line.setFillColor(Color.YELLOW);
            line.setFilled(true);
            super.add(line);
        }
    }

    public void addCar(double carSpeed){
        if (Math.random()>=.1){
            Car car = new Car(direction,y,carSpeed);
            if (carNotInside(car)){
                this.add(car);
                cars.add(car);
            }
        }
    }

    public boolean carNotInside(Car car){
        for (Car vehicle : cars) {
            if ((direction>0 ? vehicle.getX()+vehicle.getWidth()>695 : vehicle.getX()<5)){
                return false;
            }
        }
        return true;
    }

    public ArrayList<Car> getCars(){
        return cars;
    }

    public double getCarSpeed(){
        return carSpeed;
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(this);
    }

}

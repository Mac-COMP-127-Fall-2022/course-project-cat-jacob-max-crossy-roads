package CrossyRoad;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Rectangle;

public class Road extends Row {
    double y;

    public Road(double y) {
        super(Color.DARK_GRAY, y);
        this.y = y;
        drawLines(y);
        addCar();

    }

    private void drawLines(double y) {

        for (int x = 5; x < 700; x += ROW_WIDTH / 15 + 35) {
            Rectangle line = new Rectangle(x, y + ROW_HEIGHT / 2, ROW_WIDTH / 18, ROW_HEIGHT / 20);
            line.setFillColor(Color.YELLOW);
            line.setFilled(true);
            super.add(line);
        }
    }

    // want to add just one car eventually
    private void addCar(){
        for (int i = 35; i < 665; i+=70) {

            if (Math.random()>=.9){

                Car car = new Car(i,y);
                this.add(car);
            }
        }
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(this);
    }

}

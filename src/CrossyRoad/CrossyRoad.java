package CrossyRoad;



import edu.macalester.graphics.*;
import edu.macalester.graphics.events.Key;

public class CrossyRoad {
    public static final int CANVAS_WIDTH = 700;
    public static final int CANVAS_HEIGHT = 700;

    private CanvasWindow canvas;
    private Chicken chicken;
    private RowManager rowManager;
    public static int score = 0;

    // canvas is x=700, y=700
    // 10 rows on canvas so each row is x=700, y=70
    // make objects a little smaller than row so 60 x 60
    // make chicken a little smaller than objects so 50 x 50

    // might need to change so its a grid? easier for intersections and movement?

    public CrossyRoad() {
        canvas = new CanvasWindow("Crossy Roads!", CANVAS_WIDTH, CANVAS_HEIGHT);

        rowManager = new RowManager(canvas);

        chicken = new Chicken(35+ CANVAS_WIDTH / 2, 5 * CANVAS_HEIGHT / 10);
        chicken.addToCanvas(canvas);

        run();
    }

    private void run() {
        //https://stackoverflow.com/questions/541749/how-to-determine-an-objects-class used to do the instanceof check
        canvas.onKeyDown(event -> {
            if (event.getKey() == Key.LEFT_ARROW) {
                if (!(canvas.getElementAt(chicken.getChicken().getCenter().getX()-70,chicken.getChicken().getCenter().getY()) instanceof Ellipse)){
                    chicken.moveLeft();
                }

            } else if (event.getKey() == Key.RIGHT_ARROW) {
                if (!(canvas.getElementAt(chicken.getChicken().getCenter().getX()+70,chicken.getChicken().getCenter().getY()) instanceof Ellipse)){
                    chicken.moveRight();
                }


            } else if (event.getKey() == Key.UP_ARROW) {
                if(chicken.getChicken().getY() > 5 * CANVAS_HEIGHT / 10){
                    chicken.moveUp();
                }
                else if(!(canvas.getElementAt(chicken.getChicken().getCenter().getX(),chicken.getChicken().getCenter().getY()-70) instanceof Ellipse)){
                    rowManager.moveRows();
                }

            } else if (event.getKey() == Key.DOWN_ARROW) {
                if (!(canvas.getElementAt(chicken.getChicken().getCenter().getX(),chicken.getChicken().getCenter().getY()+70) instanceof Ellipse) &&
                    chicken.getChicken().getY() < 600){
                    chicken.moveDown();
                }
            }
        });

        canvas.animate(()->{
            for (Road road : rowManager.getRoads()) {
                if (Math.random()<.05){
                    road.addCar();
                }
                for (Car car : road.getCars()) {
                    car.animateCar(.1, canvas);
                }
            }
                 
        });
    }

    public static void main(String[] args) {
        new CrossyRoad();
    }
}

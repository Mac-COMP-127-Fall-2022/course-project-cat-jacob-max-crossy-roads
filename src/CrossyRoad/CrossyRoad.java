package CrossyRoad;


import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.events.Key;

public class CrossyRoad {
    public static final int CANVAS_WIDTH = 700;
    public static final int CANVAS_HEIGHT = 700;

    private CanvasWindow canvas;
    private Chicken chicken;
    private Tree tree;
    private Car car;
    private Road road;
    private Grass grass;
    private RowManager roadRowManager;
    private RowManager grassRowManager;
    private RowManager rowManager;

    // canvas is x=700, y=700
    // 10 rows on canvas so each row is x=700, y=70
    // make objects a little smaller than row so 60 x 60
    // make chicken a little smaller than objects so 50 x 50

    // might need to change so its a grid? easier for intersections and movement?

    public CrossyRoad() {
        canvas = new CanvasWindow("Crossy Roads!", CANVAS_WIDTH, CANVAS_HEIGHT);

        // road = new Road(0);
        // road.addToCanvas(canvas);

        // grass = new Grass(70);
        // grass.addToCanvas(canvas);
        
        // roadRowManager = new RowManager(road);
        // grassRowManager = new RowManager(grass);
        rowManager = new RowManager(canvas);

        tree = new Tree(150, 150);
        tree.addToCanvas(canvas);

        car = new Car(300, 300);
        car.addToCanvas(canvas);

        chicken = new Chicken(CANVAS_WIDTH / 2, 3 * CANVAS_HEIGHT / 4);
        chicken.addToCanvas(canvas);

        run();
    }

    private void run() {
        // Just realized we dont want chicken to move, lol
        // can use this same layout to create moves for canvas
        canvas.onKeyDown(event -> {
            if (event.getKey() == Key.LEFT_ARROW) {
                chicken.moveLeft();

            } else if (event.getKey() == Key.RIGHT_ARROW) {
                chicken.moveRight();

            } else if (event.getKey() == Key.UP_ARROW) {  // will need to change so it moves canvas and not chicken
                //roadRowManager.moveRow();
                // grassRowManager.moveRow();
                rowManager.moveRows();

            }
        });

    }

    public static void main(String[] args) {
        new CrossyRoad();
    }
}

package CrossyRoad;


import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.events.Key;

public class CrossyRoad {
    public static final int CANVAS_WIDTH = 700;
    public static final int CANVAS_HEIGHT = 700;

    private CanvasWindow canvas;
    private Chicken chicken;
    private Tree tree;


    public CrossyRoad(){
        canvas = new CanvasWindow("Crossy Roads!", CANVAS_WIDTH, CANVAS_HEIGHT);
        chicken = new Chicken(CANVAS_WIDTH/2,3*CANVAS_HEIGHT/4);
        chicken.addToCanvas(canvas);
        tree = new Tree(150, 150);
        tree.addToCanvas(canvas);
        run();
    }

    private void run(){
        //Just realized we dont want chicken to move, lol
        //can use this same layout to create moves for canvas
        canvas.onKeyDown(event -> {
            if (event.getKey() == Key.LEFT_ARROW) {
                    chicken.moveLeft();

            }else if (event.getKey() == Key.RIGHT_ARROW) {
                    chicken.moveRight();
//only up should change actually not left right just need to create bounds so it doesnt go off campus left right
            }else if (event.getKey() == Key.UP_ARROW) {
                    chicken.moveUp();
    }
        });
         
    }

    public static void main(String[] args) {
        new CrossyRoad();
    }
}

package CrossyRoad;



import java.awt.Color;

import edu.macalester.graphics.*;
import edu.macalester.graphics.events.Key;

public class CrossyRoad {
    public static final int CANVAS_WIDTH = 700;
    public static final int CANVAS_HEIGHT = 700;

    private CanvasWindow canvas;
    private Chicken chicken;
    private RowManager rowManager;
    public static int score = 0;
    private GraphicsText scoreLabel = new GraphicsText();
    private Rectangle background = new Rectangle(20, 20, 155, 40);

    public CrossyRoad() {
        canvas = new CanvasWindow("Crossy Roads!", CANVAS_WIDTH, CANVAS_HEIGHT);

        rowManager = new RowManager(canvas);

        chicken = new Chicken(35+ CANVAS_WIDTH / 2, 5 * CANVAS_HEIGHT / 10);
        chicken.addToCanvas(canvas);

        scoreTracker();

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
                    raiseScore();
                    scoreLabel.setText("Score: " + score);
                    if (score >= 100){
                        background.setSize(175, 40);
                    }
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
                if (Math.random()<.01){
                    road.addCar(road.carSpeed);
                }
                for (Car car : road.getCars()) {
                    car.animateCar(.1, canvas); 
                }
            }
            if (chicken.checkCollision(canvas)){
                scoreLabel.setText("gameover");
                canvas.pause(1000);
                canvas.closeWindow();
            }
        });
    }

    public void scoreTracker(){
        background.setFilled(true);
        background.setFillColor(Color.white);
        canvas.add(background);

        // JLabel scoreLabel = new JLabel("Score: 0");
        // scoreLabel.setText();


        scoreLabel.setFont(FontStyle.BOLD, 30);
        scoreLabel.setText("Score: " + score);
        scoreLabel.setPosition(30,50);
        canvas.add(scoreLabel);
    }
    
    public void raiseScore(){
        score++;
    }


    public static void main(String[] args) {
        new CrossyRoad();
    }
}

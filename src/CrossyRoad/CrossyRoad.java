package CrossyRoad;


import java.awt.Color;

import edu.macalester.graphics.*;
import edu.macalester.graphics.events.Key;

public class CrossyRoad {
    public static final int CANVAS_WIDTH = 700;
    public static final int CANVAS_HEIGHT = 700;

    public static int score = 0;

    private CanvasWindow canvas;
    private Chicken chicken;
    private RowManager rowManager;
    private GraphicsText scoreLabel;
    private Rectangle scoreBackground;
    private GraphicsText title;
    private GraphicsText titleShadow;


    // make it so trees don't populate on top of chicken
    // cars arent inside each other

    public CrossyRoad() {
        canvas = new CanvasWindow("Crossy Roads!", CANVAS_WIDTH, CANVAS_HEIGHT);
        scoreBackground = new Rectangle(20, 20, 155, 40);
        scoreLabel = new GraphicsText();
        title = new GraphicsText();
        titleShadow = new GraphicsText();

        rowManager = new RowManager(canvas);

        chicken = new Chicken(CANVAS_WIDTH / 2 - 35, CANVAS_HEIGHT * 2 / 3 + 35);
        while (canvas.getElementAt(chicken.getCenter()) instanceof Ellipse) {
            canvas.remove(canvas.getElementAt(chicken.getCenter()));
            ;
        }
        chicken.addToCanvas(canvas);


        titleScreen();

        scoreTracker();

        run();
    }

    private void run() {
        // https://stackoverflow.com/questions/541749/how-to-determine-an-objects-class used to do the
        // instanceof check
        canvas.onKeyDown(event -> {

            if (event.getKey() == Key.LEFT_ARROW) {
                if (!(canvas.getElementAt(chicken.getChicken().getCenter().getX() - 70,
                    chicken.getChicken().getCenter().getY()) instanceof Ellipse)) {
                    chicken.moveLeft();
                }

            } else if (event.getKey() == Key.RIGHT_ARROW) {
                if (!(canvas.getElementAt(chicken.getChicken().getCenter().getX() + 70,
                    chicken.getChicken().getCenter().getY()) instanceof Ellipse)) {
                    chicken.moveRight();
                }


            } else if (event.getKey() == Key.UP_ARROW) {
                if (chicken.getChicken().getY() > CANVAS_HEIGHT * 2 / 3 + 35) {
                    chicken.moveUp();

                } else if (!(canvas.getElementAt(chicken.getChicken().getCenter().getX(),
                    chicken.getChicken().getCenter().getY() - 70) instanceof Ellipse)) {
                    rowManager.moveRows();
                    raiseScore();
                    scoreLabel.setText("Score: " + score);
                    if (score >= 100) {
                        scoreBackground.setSize(175, 40);
                    }
                }

            } else if (event.getKey() == Key.DOWN_ARROW) {
                if (!(canvas.getElementAt(chicken.getChicken().getCenter().getX(),
                    chicken.getChicken().getCenter().getY() + 70) instanceof Ellipse) &&
                    chicken.getChicken().getY() < 600) {
                    chicken.moveDown();
                }
            }
            if (score == 1) {
                canvas.remove(title);
                canvas.remove(titleShadow);
            }
        });

        canvas.animate(() -> {
            for (Road road : rowManager.getRoads()) {
                if (Math.random() < .01 && canvas.getElementAt(-30, road.getCenter().getY()) == null &&
                    canvas.getElementAt(730, road.getCenter().getY()) == null) {
                    road.addCar(road.getCarSpeed());
                }
                for (Car car : road.getCars()) {
                    car.animateCar(.1, canvas);
                }
            }
            if (chicken.checkCollision(canvas)) {
                scoreLabel.setText("gameover");
                canvas.pause(1000);
                canvas.closeWindow();
            }
        });
    }

    public void scoreTracker() {
        scoreBackground.setFilled(true);
        scoreBackground.setFillColor(Color.WHITE);
        canvas.add(scoreBackground);

        scoreLabel.setFont(FontStyle.BOLD, 30);
        scoreLabel.setText("Score: " + score);
        scoreLabel.setPosition(30, 50);
        canvas.add(scoreLabel);
    }

    public void titleScreen() {
        titleShadow.setFont("rockwell", FontStyle.BOLD, 80);
        titleShadow.setFillColor(Color.DARK_GRAY);
        titleShadow.setText("Crossy Roads");
        titleShadow.setCenter(CANVAS_WIDTH / 2 + 5, CANVAS_HEIGHT / 2 + 5);
        canvas.add(titleShadow);

        title.setFont("rockwell", FontStyle.BOLD, 80);
        title.setFillColor(Color.WHITE);
        title.setText("Crossy Roads");
        title.setCenter(CANVAS_WIDTH / 2, CANVAS_HEIGHT / 2);
        canvas.add(title);
    }

    public void raiseScore() {
        score++;
    }

    public static void main(String[] args) {
        new CrossyRoad();
    }
}

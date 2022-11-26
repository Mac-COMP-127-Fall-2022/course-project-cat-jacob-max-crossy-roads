package CrossyRoad;


import java.awt.Color;
import java.nio.Buffer;

import edu.macalester.graphics.*;
import edu.macalester.graphics.events.Key;
import edu.macalester.graphics.ui.Button;

public class CrossyRoad {
    public static final int CANVAS_WIDTH = 700;
    public static final int CANVAS_HEIGHT = 700;

    public static int score = 0;

    private CanvasWindow canvas;
    private Chicken chicken;
    private RowManager rowManager;
    private GraphicsGroup scoreLabel;
    private Rectangle scoreBackground;
    private GraphicsText scoreText;
    private GraphicsText title;
    private GraphicsText titleShadow;
    private GraphicsText gameOverText;
    private GraphicsText gameoverScore;
    private Button playAgain;
    public boolean animation = true;



    // make it so trees don't populate on top of chicken
    // cars arent inside each other

    public CrossyRoad() {
        canvas = new CanvasWindow("Crossy Roads!", CANVAS_WIDTH, CANVAS_HEIGHT);
        scoreLabel = new GraphicsGroup();
        scoreText = new GraphicsText();
        scoreBackground = new Rectangle(20, 20, 155, 40);
        title = new GraphicsText();
        titleShadow = new GraphicsText();
        

        rowManager = new RowManager(canvas);

        chicken = new Chicken(CANVAS_WIDTH / 2 - 35, CANVAS_HEIGHT * 2 / 3 + 35);
        while (!(canvas.getElementAt(chicken.getCenter()) instanceof Rectangle)) {
            chicken.moveDown();
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
            chicken.move(canvas,event,animation);
            if (event.getKey() == Key.UP_ARROW && animation) {
                if (chicken.getChicken().getY() > canvas.getHeight() * 2 / 3 + 35) {
                    chicken.moveUp();
    
                } else if (!(canvas.getElementAt(chicken.getChicken().getCenter().getX(),
                    chicken.getChicken().getCenter().getY() - 70) instanceof Ellipse)) {
                    rowManager.moveRows();
                    raiseScore();
                    }
                }
            if (score == 1) {
                title.moveBy(-700,0);
                titleShadow.moveBy(-700,0);
            }
        });

        canvas.animate(() -> {
            for (Road road : rowManager.getRoads()) {
                if (Math.random() < .01 && canvas.getElementAt(-30, road.getCenter().getY()) == null &&
                    canvas.getElementAt(730, road.getCenter().getY()) == null && animation) {
                    road.addCar(road.getCarSpeed());
                }
                for (Car car : road.getCars()) {
                    if(animation){
                        car.animateCar(.1, canvas);
                    }
                }
            }
            if (chicken.checkCollision(canvas) && animation) {
                canvas.remove(scoreLabel);
                animation = false;
                gameOver();
            }
        });
    }

    public void scoreTracker() {
        scoreBackground.setFilled(true);
        scoreBackground.setFillColor(Color.WHITE);
        scoreLabel.add(scoreBackground);

        scoreText.setFont(FontStyle.BOLD, 30);
        scoreText.setText("Score: " + score);
        scoreText.setPosition(30, 50);
        scoreLabel.add(scoreText);
        canvas.add(scoreLabel);
    }

    public void gameOver(){
        gameOverText = new GraphicsText("Game Over!");
        gameOverText.setPosition(canvas.getCenter().getX(),canvas.getCenter().getY()-30);
        gameoverScore = new GraphicsText("Score: " + score);
        gameoverScore.setPosition(canvas.getCenter().getX(),canvas.getCenter().getY()-10);
        playAgain = new Button("Play Again");
        playAgain.setPosition(canvas.getCenter().getX(),canvas.getCenter().getY());
        playAgain.onClick(()->{
            canvas.removeAll();
            new CrossyRoad();
        canvas.add(gameOverText);
        canvas.add(gameoverScore);
        canvas.add(playAgain);
        });
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
        scoreText.setText("Score: " + score);
        if (score >= 100) {
            scoreBackground.setSize(175, 40);
        }
    }

    public static void main(String[] args) {
        new CrossyRoad();
    }
}

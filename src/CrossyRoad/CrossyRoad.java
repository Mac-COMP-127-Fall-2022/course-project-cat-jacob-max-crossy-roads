package CrossyRoad;


import java.awt.Color;

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
    private GraphicsGroup gameOver = new GraphicsGroup();
    private Rectangle scoreBackground;
    private GraphicsText scoreText;
    private GraphicsText title;
    private GraphicsText titleShadow;
    private GraphicsText gameOverText;
    private GraphicsText gameoverScore;
    private Button playAgain;
    public boolean animation = true;
    public boolean titleOnCanvas = true;

    public CrossyRoad() {
        gameoverScore = new GraphicsText();
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
                if (chicken.getChicken().getY() > canvas.getHeight() * 2 / 3 + 35 &&
                !(canvas.getElementAt(chicken.getChicken().getCenter().getX(),
                    chicken.getChicken().getCenter().getY() - 70) instanceof Ellipse) &&
                    !(canvas.getElementAt(chicken.getChicken().getCenter().getX(), 
                    chicken.getChicken().getCenter().getY() - 70) instanceof Image)) {
                    chicken.moveUp();

                } else if (!(canvas.getElementAt(chicken.getChicken().getCenter().getX(),
                    chicken.getChicken().getCenter().getY() - 70) instanceof Ellipse) &&
                    !(canvas.getElementAt(chicken.getChicken().getCenter().getX(), 
                    chicken.getChicken().getCenter().getY() - 70) instanceof Image)) {
                    rowManager.moveRows();
                    raiseScore();
                    }
                }
        });
        canvas.animate(() -> {
            if (score == 1 && titleOnCanvas) {
                canvas.remove(title);
                canvas.remove(titleShadow);
                titleOnCanvas=false;
                }
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
                gameOver();
                animation = false;
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
        gameOverText.setCenter(canvas.getCenter().getX(),canvas.getCenter().getY()-30);
        gameoverScore.setText("Score: " + score);
        gameoverScore.setCenter(canvas.getCenter().getX(),canvas.getCenter().getY()-10);
        playAgain = new Button("Play Again");
        playAgain.setCenter(canvas.getCenter().getX(),canvas.getCenter().getY()+10);
        playAgain.onClick(()->{
            canvas.removeAll();
            score=0;
            rowManager = new RowManager(canvas);
            // chicken = new Chicken(CANVAS_WIDTH / 2 - 35, CANVAS_HEIGHT * 2 / 3 + 35);
            chicken.setPosition(CANVAS_WIDTH / 2 - 35, CANVAS_HEIGHT * 2 / 3 + 35);
            while (!(canvas.getElementAt(chicken.getCenter()) instanceof Rectangle)) {
                chicken.moveDown();
            }
            chicken.addToCanvas(canvas);
            animation=true;
            titleOnCanvas=true;

            titleScreen();
            scoreTracker();
        });
        gameOver.add(gameoverScore);
        gameOver.add(gameOverText);
        gameOver.add(playAgain);
        canvas.add(gameOver);
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

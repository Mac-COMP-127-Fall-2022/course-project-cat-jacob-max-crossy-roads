package CrossyRoad;

import java.awt.Color;
import edu.macalester.graphics.*;
import edu.macalester.graphics.events.Key;
import edu.macalester.graphics.ui.Button;

/**
* Main game class to run Crossy Roads
*/
public class CrossyRoad {
    public static final int CANVAS_WIDTH = 700;
    public static final int CANVAS_HEIGHT = 700;
    public static int score = 0;

    private CanvasWindow canvas;
    private Chicken chicken;
    private RowManager rowManager;
    private GraphicsGroup scoreLabel;
    private GraphicsGroup gameOver;
    private Rectangle scoreBackground;
    private Rectangle gameOverBackground;
    private GraphicsText scoreText;
    private GraphicsText title;
    private GraphicsText titleShadow;
    private GraphicsText gameOverText;
    private GraphicsText gameoverScore;
    private Button playAgain;
    public boolean animation = true;
    public boolean titleOnCanvas = true;

    public static void main(String[] args) {
        new CrossyRoad();
    }

    public CrossyRoad() {
        gameoverScore = new GraphicsText();
        gameOver = new GraphicsGroup();
        canvas = new CanvasWindow("Crossy Roads!", CANVAS_WIDTH, CANVAS_HEIGHT);
        scoreLabel = new GraphicsGroup();
        scoreText = new GraphicsText();
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

/**
* Our run function does a lot, it tracks key movements and causes the chicken to
* move depending on selected arrow keys. It also generates random roads and cars
* to spawn. This also controls all the animation for the game
*/
    private void run() {
        canvas.onKeyDown(event -> {
            chicken.move(canvas,event,animation);
            if (event.getKey() == Key.UP_ARROW && animation) {
                if (chicken.getY() > canvas.getHeight() * 2 / 3 + 35 &&
                !(canvas.getElementAt(chicken.getCenter().getX(),
                    chicken.getCenter().getY() - 70) instanceof Ellipse) &&
                    !(canvas.getElementAt(chicken.getCenter().getX(), 
                    chicken.getCenter().getY() - 70) instanceof Image)) {
                    chicken.moveUp();

                } else if (!(canvas.getElementAt(chicken.getCenter().getX(),
                    chicken.getCenter().getY() - 70) instanceof Ellipse) &&
                    !(canvas.getElementAt(chicken.getCenter().getX(), 
                    chicken.getCenter().getY() - 70) instanceof Image)) {
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
        scoreBackground = new Rectangle(20, 20, 155, 40);
        scoreBackground.setFilled(true);
        scoreBackground.setFillColor(Color.WHITE);
        scoreLabel.add(scoreBackground);
        scoreText.setFont(FontStyle.BOLD, 30);
        scoreText.setText("Score: " + score);
        scoreText.setPosition(30, 50);
        scoreLabel.add(scoreText);
        canvas.add(scoreLabel);
    }

/**
* Creates a play again button that allows the user to restart the game. 
* Resets a lot of the game functions to allow it to be played from beginning
*/
    public void gameOver(){
        gameOverText();
        playAgain = new Button("Play Again");
        playAgain.setCenter(350,370);
        playAgain.onClick(()->{
            canvas.removeAll();
            score=0;
            rowManager = new RowManager(canvas);
            chicken = new Chicken(CANVAS_WIDTH / 2 - 35, CANVAS_HEIGHT * 2 / 3 + 35);
            while (!(canvas.getElementAt(chicken.getCenter()) instanceof Rectangle)) {
                chicken.moveDown();
            }
            chicken.addToCanvas(canvas);
            animation=true;
            titleOnCanvas=true;

            titleScreen();
            scoreTracker();
        });
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

    public void gameOverText(){
        gameOverBackground = new Rectangle(0,0,650,120);
        gameOverBackground.setFilled(true);
        gameOverBackground.setFillColor(Color.WHITE);
        gameOverBackground.setCenter(CANVAS_WIDTH/2,CANVAS_HEIGHT/2-60);
        gameOverText = new GraphicsText("GAME OVER!");
        gameOverText.setFont("rockwell", FontStyle.BOLD, 80);
        gameOverText.setFillColor(Color.RED.darker());
        gameOverText.setCenter(CANVAS_WIDTH/2,CANVAS_HEIGHT/2-75);
        gameoverScore.setText("Score: " + score);
        gameoverScore.setFont("rockwell", FontStyle.BOLD, 30);
        gameoverScore.setCenter(CANVAS_WIDTH/2,CANVAS_HEIGHT/2-20);
        gameOver.add(gameOverBackground);
        gameOver.add(gameoverScore);
        gameOver.add(gameOverText);
    }


}

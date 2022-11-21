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

    // make it so trees don't populate on top of chicken
    // cars arent inside each other

    public CrossyRoad() {
        canvas = new CanvasWindow("Crossy Roads!", CANVAS_WIDTH, CANVAS_HEIGHT);
        scoreBackground = new Rectangle(20, 20, 155, 40);
        scoreLabel = new GraphicsText();
        title = new GraphicsText();

        rowManager = new RowManager(canvas);

        chicken = new Chicken(CANVAS_WIDTH / 2 - 35, CANVAS_HEIGHT * 2 / 3 + 35);
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
        });

        canvas.animate(() -> {
            for (Road road : rowManager.getRoads()) {
                if (Math.random() < .01) {
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
        scoreBackground.setFillColor(Color.white);
        canvas.add(scoreBackground);

        scoreLabel.setFont(FontStyle.BOLD, 30);
        scoreLabel.setText("Score: " + score);
        scoreLabel.setPosition(30, 50);
        canvas.add(scoreLabel);
    }

    public void titleScreen() {
        title.setFont("chalkboard", FontStyle.BOLD, 100);
        title.setText("Crossy Roads");
        title.setCenter(CANVAS_WIDTH/2, CANVAS_HEIGHT/3);
        canvas.add(title);
    }

    public void raiseScore() {
        score++;
    }

    public static void main(String[] args) {
        new CrossyRoad();
    }
}


/**
 * available font families are: [.applesystemuifont, academy engraved let, 
 * al bayan, al nile, al tarikh, american typewriter, andale mono, apple braille, 
 * apple chancery, apple color emoji, apple sd gothic neo, apple symbols, 
 * applegothic, applemyungjo, arial, arial black, arial hebrew, arial hebrew scholar, 
 * arial narrow, arial rounded mt bold, arial unicode ms, avenir, avenir next, 
 * avenir next condensed, ayuthaya, baghdad, bangla mn, bangla sangam mn, 
 * baskerville, beirut, big caslon, bodoni 72, bodoni 72 oldstyle, 
 * bodoni 72 smallcaps, bodoni ornaments, bradley hand, brush script mt, 
 * chalkboard, chalkboard se, chalkduster, charter, cochin, comic sans ms, 
 * copperplate, corsiva hebrew, courier new, damascus, decotype naskh, 
 * devanagari mt, devanagari sangam mn, dialog, dialoginput, didot, din alternate, 
 * din condensed, diwan kufi, diwan thuluth, euphemia ucas, farah, farisi, futura, 
 * galvji, gb18030 bitmap, geeza pro, geneva, georgia, gill sans, grantha sangam mn, 
 * gujarati mt, gujarati sangam mn, gurmukhi mn, gurmukhi mt, gurmukhi sangam mn, 
 * heiti sc, heiti tc, helvetica, helvetica neue, herculanum, 
 * hiragino maru gothic pron, hiragino mincho pron, hiragino sans, hiragino sans gb, 
 * hoefler text, impact, inaimathi, itf devanagari, itf devanagari marathi, kailasa, 
 * kannada mn, kannada sangam mn, kefa, khmer mn, khmer sangam mn, kohinoor bangla, 
 * kohinoor devanagari, kohinoor gujarati, kohinoor telugu, kokonor, krungthep, 
 * kufistandardgk, lao mn, lao sangam mn, lucida grande, luminari, malayalam mn, 
 * malayalam sangam mn, marker felt, menlo, microsoft sans serif, mishafi, 
 * mishafi gold, monaco, monospaced, mshtakan, mukta mahee, muna, myanmar mn, 
 * myanmar sangam mn, nadeem, new peninim mt, noteworthy, noto nastaliq urdu, 
 * noto sans kannada, noto sans myanmar, noto sans oriya, noto serif myanmar, 
 * optima, oriya mn, oriya sangam mn, palatino, papyrus, party let, phosphate, 
 * pingfang hk, pingfang sc, pingfang tc, plantagenet cherokee, pt mono, pt sans, 
 * pt sans caption, pt sans narrow, pt serif, pt serif caption, raanana, rockwell, 
 * sana, sansserif, sathu, savoye let, serif, shree devanagari 714, signpainter, 
 * silom, sinhala mn, sinhala sangam mn, skia, snell roundhand, songti sc, 
 * songti tc, stix two math, stix two text, stsong, sukhumvit set, symbol, 
 * tahoma, tamil mn, tamil sangam mn, telugu mn, telugu sangam mn, thonburi, 
 * times new roman, trattatello, trebuchet ms, verdana, waseem, webdings, 
 * wingdings, wingdings 2, wingdings 3, zapf dingbats, zapfino
 */
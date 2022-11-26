package CrossyRoad;

import edu.macalester.graphics.*;
import edu.macalester.graphics.events.Key;
import edu.macalester.graphics.events.KeyboardEvent;

public class Chicken extends Image{


    private static final double CHICKEN_HEIGHT = 50;
    private static final double CHICKEN_WIDTH = 50;
    // private Image chicken;
    private double x;
    private double y;

    // private CanvasWindow canvas;

    public Chicken(double x, double y) {
        super(x,y);
        this.x = x;
        this.y = y;

        setImagePath("chicken.png");
        setMaxHeight(CHICKEN_HEIGHT);
        setMaxWidth(CHICKEN_WIDTH);
    }

    public void move(CanvasWindow canvas, KeyboardEvent event, boolean animation){
        if (event.getKey() == Key.LEFT_ARROW && animation) {
            if (!(canvas.getElementAt(getChicken().getCenter().getX() - 70,
                getChicken().getCenter().getY()) instanceof Ellipse)) {
                moveLeft();
            }

        } else if (event.getKey() == Key.RIGHT_ARROW && animation) {
            if (!(canvas.getElementAt(getChicken().getCenter().getX() + 70,
                getChicken().getCenter().getY()) instanceof Ellipse)) {
                moveRight();
            }


        }
         else if (event.getKey() == Key.DOWN_ARROW && animation) {
            if (!(canvas.getElementAt(getChicken().getCenter().getX(),
                getChicken().getCenter().getY() + 70) instanceof Ellipse) &&
                getChicken().getY() < 600) {
                moveDown();
            }
        }
    }

    public void moveLeft() {
        // double moveX = point.getX();
        if (x > 70) {
            x -= 70;
            setPosition(x, y);
        }

    }

    public void moveRight() {
        if (x < CrossyRoad.CANVAS_WIDTH - 3 * CHICKEN_WIDTH) {
            x += 70;
            setPosition(x, y);
        }

    }

    public void moveUp() {
        y -= 70;
        setPosition(x, y);
    }

    public void moveDown() {
        y+= 70;
        setPosition(x, y);
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(this);
    }

    public Image getChicken() {
        return this;
    }

    public boolean checkCollision(CanvasWindow c){
        if (c.getElementAt(getX()+CHICKEN_WIDTH+1,getCenter().getY()).getWidth()== 60 ||
            c.getElementAt(getX()-1,getCenter().getY()).getWidth()== 60 ||
            c.getElementAt(getX()+CHICKEN_WIDTH/2,getY()-1).getWidth()== 60 ||
            c.getElementAt(getX()+CHICKEN_WIDTH/2,getY()+CHICKEN_HEIGHT+1).getWidth()== 60){
            return true;
        }
        else{return false;}
    }

}

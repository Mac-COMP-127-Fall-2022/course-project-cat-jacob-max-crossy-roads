package CrossyRoad;

import java.awt.Color;
import edu.macalester.graphics.CanvasWindow;

public class Grass extends Row {
    private double y;

/**
* Grass constructer adds objects to the grass row, and sets its y position
*/
    public Grass(double y,boolean initial) {
        super(Color.GREEN.darker(), y);
        this.y = y;
        addObjects(initial);
    }

/**
* This method randomly determines when to add objects to the grass row
* It takes random numbers between 0 and 1 and depending on the number a tree
* or boulder is added to the row
*/
    private void addObjects(boolean initial) {
        for (int i = 35; i < 665; i += 70) {
            double randNum = Math.random();
            if (randNum >= (initial == true ? .9 : .8)) {
                if (randNum >= (initial == true ? .95 : .9)) {
                    Tree tree = new Tree(i, y);
                    this.add(tree);
                }else {
                    PineTree tree = new PineTree(i, y);
                    this.add(tree);
                }
            }else if (randNum <= .05) {
                Boulder boulder = new Boulder(i, y);
                this.add(boulder);
            }
        }
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(this);
    }

}

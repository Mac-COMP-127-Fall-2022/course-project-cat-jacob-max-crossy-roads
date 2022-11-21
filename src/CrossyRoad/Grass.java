package CrossyRoad;

import java.awt.Color;
import edu.macalester.graphics.CanvasWindow;

public class Grass extends Row {
    double y;

    public Grass(double y) {
        super(Color.GREEN.darker(), y);
        this.y = y;
        addObjects();
    }

    private void addObjects() {
        for (int i = 35; i < 665; i += 70) {
            double randNum = Math.random();

            if (randNum >= .7) {
                Tree tree = new Tree(i, y + 5);
                // PineTree tree = new PineTree(i, y+5);
                this.add(tree);
            } else if (randNum >= .6) {
                Boulder boulder = new Boulder(i, y + 5);
                this.add(boulder);
            }
        }
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(this);
    }

}

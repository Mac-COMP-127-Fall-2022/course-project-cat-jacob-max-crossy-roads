package CrossyRoad;

import java.awt.Color;
import edu.macalester.graphics.CanvasWindow;

public class Grass extends Row {
    double y;

    public Grass(double y) {
        super(Color.GREEN.darker(), y);
        this.y = y;
        addTrees();
    }

    private void addTrees(){
        for (int i = 35; i < 665; i+=70) {
            if (Math.random()>=.8){
                Tree tree = new Tree(i,y+5);
                this.add(tree);
            }
        }
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(this);
    }

}

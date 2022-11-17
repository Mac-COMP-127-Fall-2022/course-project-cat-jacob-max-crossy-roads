package CrossyRoad;

import java.awt.Color;
import edu.macalester.graphics.CanvasWindow;

public class Grass extends Row {

    public Grass(double y) {
        super(Color.GREEN.darker(), y);
    }


    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(this);
    }

}

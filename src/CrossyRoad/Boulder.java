package CrossyRoad;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;

public class Boulder extends GraphicsGroup {

    private static final double BOULDER_WIDTH = 50;
    private static final double BOUDLER_HEIGHT = 50;
    private Image boulderIcon;

/**
* Boulder constructer, sets boulders position and creates it 
*/
    public Boulder(double x, double y) {
        super(x, y);
        buildBoulder();
    }

    private void buildBoulder() {
        boulderIcon = new Image(0, 0);
        boulderIcon.setImagePath("boulders.png");
        boulderIcon.setMaxHeight(BOULDER_WIDTH);
        boulderIcon.setMaxWidth(BOUDLER_HEIGHT);
        boulderIcon.setCenter(BOULDER_WIDTH/2, BOUDLER_HEIGHT*4/5);
        this.add(boulderIcon);
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(this);
    }
}

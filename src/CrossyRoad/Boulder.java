package CrossyRoad;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;

/**
 * Boulder class creates a boulder that can be added to a canvas
 */
public class Boulder extends GraphicsGroup {

    private static final double BOULDER_WIDTH = 50;
    private static final double BOUDLER_HEIGHT = 50;
    private Image boulderIcon;

    /**
     * Boulder constructer, sets boulder's position and creates it
     * 
     * @param x x position
     * @param y y position
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
        boulderIcon.setCenter(BOULDER_WIDTH / 2, BOUDLER_HEIGHT * 4 / 5);
        this.add(boulderIcon);
    }

}

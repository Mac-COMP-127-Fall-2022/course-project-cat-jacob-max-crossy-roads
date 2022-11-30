package CrossyRoad;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
// import edu.macalester.graphics.Rectangle;


public class Boulder extends GraphicsGroup {

    private static final double BOULDER_WIDTH = 50;
    private static final double BOUDLER_HEIGHT = 50;

    private Image boulderIcon;
    // private Rectangle size;

    public Boulder(double x, double y) {
        super(x, y);

        buildBoulder();

    }

    private void buildBoulder() {
        // to test proportions:
        // size = new Rectangle(0,0,BOULDER_WIDTH, BOUDLER_HEIGHT);
        // this.add(size);

        boulderIcon = new Image(0, 0);
        boulderIcon.setImagePath("boulders.png");
        boulderIcon.setMaxHeight(BOULDER_WIDTH);
        boulderIcon.setMaxWidth(BOUDLER_HEIGHT);
        this.add(boulderIcon);

    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(this);
    }
}

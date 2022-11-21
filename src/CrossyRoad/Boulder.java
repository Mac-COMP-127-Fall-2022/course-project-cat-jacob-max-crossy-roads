package CrossyRoad;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Rectangle;
import java.awt.Color;


public class Boulder extends GraphicsGroup {
    
    private static final double BOULDER_WIDTH = 60;
    private static final double BOUDLER_HEIGHT = 60;

    private Image boulderIcon;
    private Rectangle size;
    private Ellipse boulder;

    public Boulder(double x, double y) {
        super(x, y);

        buildBoulder();
        
    }

    private void buildBoulder() {
        // to test proportions:
        size = new Rectangle(0,0,BOULDER_WIDTH, BOUDLER_HEIGHT);
        this.add(size);

        boulder = new Ellipse(BOULDER_WIDTH / 8, BOUDLER_HEIGHT / 8, BOULDER_WIDTH * 3 / 4, BOUDLER_HEIGHT * 3 / 4);
        boulder.setStrokeColor(Color.GREEN);
        boulder.setFillColor(Color.GREEN);
        this.add(boulder);

        boulderIcon.setImagePath("boulder.png");
        boulderIcon.setMaxHeight(BOULDER_WIDTH);
        boulderIcon.setMaxWidth(BOUDLER_HEIGHT);
        this.add(boulderIcon);

    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(this);
    }
}

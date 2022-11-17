package CrossyRoad;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;

import java.awt.Color;

public abstract class Row extends GraphicsGroup {

    public static final double ROW_HEIGHT = 70;
    public static final double ROW_WIDTH = CrossyRoad.CANVAS_WIDTH;


    public Row(Color color, double y) {
        super();
        drawRow(y, color);
    }

    public void drawRow(double y, Color color) {
        Rectangle row = new Rectangle(0, y, ROW_WIDTH, ROW_HEIGHT);
        row.setFilled(true);
        row.setFillColor(color);
        row.setStrokeColor(color);
        super.add(row);
    }


}

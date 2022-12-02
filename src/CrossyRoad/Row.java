package CrossyRoad;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;
import java.awt.Color;

public abstract class Row extends GraphicsGroup {

    public static final double ROW_HEIGHT = 70;
    public static final double ROW_WIDTH = CrossyRoad.CANVAS_WIDTH;

/**
* Creates row and lets the y and color to be variables so to be changed
* depending on the type of row that is needed
*/ 
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

    public void setRowPos(double pos) {
        this.setPosition(0, pos);
    }
}

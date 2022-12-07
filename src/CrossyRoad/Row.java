package CrossyRoad;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;
import java.awt.Color;

/**
 * Abstract class Row creates a rectangle to represent a row in Crossy Roads
 */
public abstract class Row extends GraphicsGroup {

    public static final double ROW_HEIGHT = 70;
    public static final double ROW_WIDTH = CrossyRoad.CANVAS_WIDTH;

    /**
     * Creates row according to given parameters
     * 
     * @param color of the row
     * @param y     position
     */
    public Row(Color color, double y) {
        super();
        drawRow(y, color);
    }

    /**
     * Creates the row according to given parameters
     * 
     * @param y     position
     * @param color of the row
     */
    public void drawRow(double y, Color color) {
        Rectangle row = new Rectangle(0, y, ROW_WIDTH, ROW_HEIGHT);
        row.setFilled(true);
        row.setFillColor(color);
        row.setStrokeColor(color);
        super.add(row);
    }

    /**
     * Sets the position of this row
     * 
     * @param pos position of this row
     */
    public void setRowPos(double pos) {
        this.setPosition(0, pos);
    }
}

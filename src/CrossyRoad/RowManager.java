package CrossyRoad;

import java.util.ArrayList;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;

/**
 * RowManager class contains methods that help manage the rows on the canvas
 */
public class RowManager {
    private GraphicsGroup rows;
    private ArrayList<Road> roads;
    private ArrayList<Grass> grasses;

    /**
     * Creates array lists to hold roads and grass rows to be set set up and added to canvas
     * 
     * @param canvas the rows are added to
     */
    public RowManager(CanvasWindow canvas) {
        rows = new GraphicsGroup();
        roads = new ArrayList<Road>();
        grasses = new ArrayList<Grass>();
        setUpRows();
        canvas.add(rows);
    }

    /**
     * Adds random rows to the row array list unless it is the start of the game
     */
    public void setUpRows() {
        for (int i = 0; i <= 630; i += 70) {
            if (i > 280) {
                rows.add(new Grass(i, true));
            } else {
                randomRow(i);
            }
        }
    }

    /**
     * Moves the rows in the row array list down one row and adds a new random road at the top
     */
    public void moveRows() {
        rows.iterator().forEachRemaining(row -> {
            if (row.getY() <= 560) {
                ((Row) row).setRowPos(row.getY() + 70);
            } else if (row.getY() >= 630) {
                ((Row) row).removeAll();
            }
        });
        randomRow(0);
    }

    /**
     * Randomly generates a number that deteremines which type of row will be added to row list, slight
     * preference to grass
     */
    public void randomRow(double y) {
        if (Math.random() >= .4) {
            Road road = new Road(y);
            rows.add(road);
            roads.add(road);
        } else {
            Grass grass = new Grass(y, false);
            rows.add(grass);
            grasses.add(grass);
        }
    }

    /**
     * @return the list of roads
     */
    public ArrayList<Road> getRoads() {
        return roads;
    }
}

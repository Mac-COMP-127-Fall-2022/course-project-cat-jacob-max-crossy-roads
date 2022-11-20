package CrossyRoad;

import java.util.ArrayList;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;


public class RowManager {
    private GraphicsGroup rows;
    private ArrayList<Road> roads;
    private ArrayList<Grass> grasses;

    public RowManager(CanvasWindow canvas) {
        rows = new GraphicsGroup();
        roads = new ArrayList<Road>();
        grasses = new ArrayList<Grass>();
        setUpRows();
        canvas.add(rows);
    }

    public void setUpRows() {
        for (int i = 0; i <= 630; i += 70) {

            if (i > 280) {
                rows.add(new Grass(i));
            } else {
                randomRow(i);
            }
        }

    }

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

    public void randomRow(double y) {
        if (Math.random() >= .4) {
            Road road = new Road(y);
            rows.add(road);
            roads.add(road);
        } else {
            Grass grass = new Grass(y);
            rows.add(grass);
            grasses.add(grass);
        }
    }

    public GraphicsGroup getRows(){
        return rows;
    }
    
    public ArrayList<Road> getRoads() {
        return roads;
    }
}

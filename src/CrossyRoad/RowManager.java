package CrossyRoad;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;


public class RowManager {
    private GraphicsGroup rows;

    public RowManager(CanvasWindow canvas) {
        rows = new GraphicsGroup();
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
            rows.add(new Road(y));
        } else {
            rows.add(new Grass(y));
        }
    }
}

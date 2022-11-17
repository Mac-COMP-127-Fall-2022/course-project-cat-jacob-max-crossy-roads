package CrossyRoad;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Rectangle;

public class Road extends Row {

    public Road(double y) {
        super(Color.DARK_GRAY, y);
        drawLines(y);

    }

    private void drawLines(double y) {

        for (int x = 5; x < 700; x += ROW_WIDTH / 15 + 35) {
            Rectangle line = new Rectangle(x, y + ROW_HEIGHT / 2, ROW_WIDTH / 18, ROW_HEIGHT / 20);
            line.setFillColor(Color.YELLOW);
            line.setFilled(true);
            super.add(line);
        }
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(this);
    }

}

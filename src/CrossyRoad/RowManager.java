package CrossyRoad;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import java.util.ArrayList;
import java.util.List;

import javax.sql.RowSet;

import java.awt.Color;

public class RowManager {
    private GraphicsGroup rows;

    public RowManager(CanvasWindow canvas){
        rows = new GraphicsGroup();
        setUpRows();
        canvas.add(rows);
    }

    public void setUpRows(){
        for (int i = 0; i <= 630; i+=70) {
            System.out.println(i);
            rows.add(new Grass(i));
        }
    }

    public void moveRows(){
        rows.iterator().forEachRemaining(row->{
            if (row.getY() <= 560){
                ((Row) row).setRowPos(row.getY()+70);
            }
            else if (row.getY()>=630){
                ((Row) row).removeAll();
            }
            //rows.add(new Grass(0));
        });
    }
}

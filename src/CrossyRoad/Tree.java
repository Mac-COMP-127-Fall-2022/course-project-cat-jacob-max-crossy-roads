package CrossyRoad;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;

public class Tree extends GraphicsGroup {

    private static final double TREE_WIDTH = 60;
    private static final double TREE_HEIGHT = 60;
    private Rectangle treeBase;
    private Ellipse leaf;
    private GraphicsGroup treeGroup;
    // private Rectangle size;


    public Tree(double x, double y) {
        treeGroup = new GraphicsGroup(x, y);
        buildTree();
    }

    private void buildTree() {
        // to test proportions:
        // size = new Rectangle(0,0,TREE_WIDTH, TREE_HEIGHT);
        // treeGroup.add(size);

        treeBase = new Rectangle(TREE_WIDTH * 5 / 12, TREE_HEIGHT * 3 / 4, TREE_WIDTH / 6, TREE_HEIGHT / 4);
        treeBase.setStrokeColor(Color.BLACK);
        treeBase.setFillColor(Color.BLACK);
        treeGroup.add(treeBase);

        leaf = new Ellipse(TREE_WIDTH / 8, 0, TREE_WIDTH * 3 / 4, TREE_HEIGHT * 3 / 4);
        leaf.setStrokeColor(Color.GREEN);
        leaf.setFillColor(Color.GREEN);
        treeGroup.add(leaf);
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(treeGroup);
    }

}

package CrossyRoad;

import java.awt.Color;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;

/**
 * Tree class creates a tree that can be added to a canvas
 */
public class Tree extends GraphicsGroup {

    private static final double TREE_WIDTH = 70;
    private static final double TREE_HEIGHT = 70;
    private Rectangle treeBase;
    private Ellipse leaf;

    /**
     * Tree constructer, sets position of tree to be used and creates the tree
     *
     * @param x x position
     * @param y y position
     */
    public Tree(double x, double y) {
        super(x, y);
        buildTree();
    }

    /**
     * Builds a tree
     */
    private void buildTree() {
        treeBase = new Rectangle(TREE_WIDTH * 5 / 12, TREE_HEIGHT * 3 / 4, TREE_WIDTH / 6, TREE_HEIGHT / 5);
        treeBase.setStrokeColor(Color.BLACK);
        treeBase.setFillColor(Color.BLACK);
        this.add(treeBase);

        leaf = new Ellipse(TREE_WIDTH / 7, 8, TREE_WIDTH * 2 / 3, TREE_HEIGHT * 2 / 3);
        leaf.setStrokeColor(Color.GREEN);
        leaf.setFillColor(Color.GREEN);
        this.add(leaf);
    }

}

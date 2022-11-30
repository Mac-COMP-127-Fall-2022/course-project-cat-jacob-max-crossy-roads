package CrossyRoad;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Rectangle;

public class Tree extends GraphicsGroup {

    private static final double TREE_WIDTH = 70;
    private static final double TREE_HEIGHT = 70;
    private Rectangle treeBase;
    private Ellipse leaf;
    private Image tree;
    // private Rectangle size;


    public Tree(double x, double y) {
        super(x, y);
        buildTree();
    }

    private void buildTree() {
        // to test proportions:
        // size = new Rectangle(0,0,TREE_WIDTH, TREE_HEIGHT);
        // this.add(size);

        treeBase = new Rectangle(TREE_WIDTH * 5 / 12, TREE_HEIGHT * 3 / 4, TREE_WIDTH / 6, TREE_HEIGHT / 5);
        treeBase.setStrokeColor(Color.BLACK);
        treeBase.setFillColor(Color.BLACK);
        this.add(treeBase);

        leaf = new Ellipse(TREE_WIDTH / 7, 8, TREE_WIDTH * 2 / 3, TREE_HEIGHT * 2 / 3);
        leaf.setStrokeColor(Color.GREEN);
        leaf.setFillColor(Color.GREEN);
        this.add(leaf);

        // tree = new Image(0, 0);
        // tree.setImagePath("alt_tree.png");
        // tree.setMaxHeight(TREE_WIDTH);
        // tree.setMaxWidth(TREE_HEIGHT);
        // this.add(tree);
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(this);
    }

}

package CrossyRoad;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;

public class Tree extends GraphicsGroup{

    private static final double TREE_WIDTH = 40;
    private static final double TREE_HEIGHT = 40;
    private Rectangle treeBase;
    private Ellipse leaf;
    private double x;
    private double y;
    private GraphicsGroup treeGroup;


    public Tree(double x, double y){
        this.x = x;
        this.y = y;
        treeGroup = new GraphicsGroup(x,y);
        oneTree();
    }

    private void oneTree(){
        treeBase = new Rectangle(10,40,TREE_WIDTH/4,TREE_HEIGHT);
        treeBase.setStrokeColor(Color.BLACK);
        treeBase.setFillColor(Color.BLACK);
        treeGroup.add(treeBase);

        leaf = new Ellipse(-5, 10 , TREE_WIDTH,TREE_HEIGHT);
        leaf.setStrokeColor(Color.GREEN);
        leaf.setFillColor(Color.GREEN);
        treeGroup.add(leaf);
    }

    // private void treeTop(){
        
    // }
    
    public void addToCanvas(CanvasWindow canvas){
        canvas.add(treeGroup);
    }

}

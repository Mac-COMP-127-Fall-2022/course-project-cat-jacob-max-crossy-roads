package CrossyRoad;

import edu.macalester.graphics.Rectangle;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Image;

public class PineTree extends GraphicsGroup{

        private static final double TREE_WIDTH = 70;
        private static final double TREE_HEIGHT = 70;
        private Image pine;
        private Rectangle treeBase;
        private Rectangle bottomLayer;
        private Rectangle secondLayer;
        private Rectangle thirdLayer;
        private Rectangle fourthLayer;
        private Rectangle top;
        private Ellipse circle;
        private Color green = Color.green.darker().darker();

        
         //private Rectangle size;
    
    
        public PineTree(double x, double y) {
            super(x,y);
            buildTree();
        }
    
        private void buildTree() {
            // to test proportions:
            // size = new Rectangle(0,0,TREE_WIDTH, TREE_HEIGHT);
            // treeGroup.add(size);
    
        treeBase = new Rectangle(25, 48, TREE_WIDTH /6, TREE_HEIGHT / 4);
        treeBase.setStrokeColor(Color.BLACK);
        treeBase.setFillColor(Color.BLACK);
        this.add(treeBase);

        

        bottomLayer = new Rectangle(3, 45, 54 , TREE_HEIGHT / 8);
        bottomLayer.setStrokeColor(green);
        bottomLayer.setFillColor(green);
        this.add(bottomLayer);

        secondLayer = new Rectangle(8, 37, 44, TREE_HEIGHT / 8);
        secondLayer.setStrokeColor(green);
        secondLayer.setFillColor(green);
        this.add(secondLayer);

        thirdLayer = new Rectangle(13, 29, 35, TREE_HEIGHT / 8);
        thirdLayer.setStrokeColor(green);
        thirdLayer.setFillColor(green);
        this.add(thirdLayer);

        fourthLayer = new Rectangle(17, 21, 26, TREE_HEIGHT / 8);
        fourthLayer.setStrokeColor(green);
        fourthLayer.setFillColor(green);
        this.add(fourthLayer);

        top = new Rectangle(25, 13, 10, TREE_HEIGHT / 8);
        top.setStrokeColor(green);
        top.setFillColor(green);
        this.add(top);

        circle = new Ellipse(15, 20, 30, 30);
        circle.setStrokeColor(green);
        circle.setFillColor(green);
        this.add(circle);
    
        // pine = new Image(0, 0);
        // pine.setImagePath("alt_pinetree.png");
        // pine.setMaxHeight(TREE_WIDTH);
        // pine.setMaxWidth(TREE_HEIGHT);
        // this.add(pine);
        }
    
        public void addToCanvas(CanvasWindow canvas) {
            canvas.add(this);
        }
    
    }
    


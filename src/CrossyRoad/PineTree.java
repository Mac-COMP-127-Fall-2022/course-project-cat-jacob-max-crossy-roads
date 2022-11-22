package CrossyRoad;

import edu.macalester.graphics.Rectangle;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsGroup;

public class PineTree extends GraphicsGroup{

        private static final double TREE_WIDTH = 60;
        private static final double TREE_HEIGHT = 60;
        private Rectangle treeBase;
        private Rectangle bottomLayer;
        private Rectangle secondLayer;
        private Rectangle thirdLayer;
        private Rectangle fourthLayer;
        private Rectangle top;
        private Ellipse circle;

        
         //private Rectangle size;
    
    
        public PineTree(double x, double y) {
            super(x,y);
            buildTree();
        }
    
        private void buildTree() {
            // to test proportions:
            //size = new Rectangle(0,0,TREE_WIDTH, TREE_HEIGHT);
            //treeGroup.add(size);
    
        treeBase = new Rectangle(25, 48, TREE_WIDTH /6, TREE_HEIGHT / 4);
        treeBase.setStrokeColor(Color.BLACK);
        treeBase.setFillColor(Color.BLACK);
        this.add(treeBase);

        // circle = new Ellipse(10, 30, 20, 20);
        // this.add(circle);

        bottomLayer = new Rectangle(5, 45, 50 , TREE_HEIGHT / 8);
        bottomLayer.setStrokeColor(Color.green.darker().darker());
        bottomLayer.setFillColor(Color.green.darker().darker());
        this.add(bottomLayer);

        secondLayer = new Rectangle(10, 37, 40, TREE_HEIGHT / 8);
        secondLayer.setStrokeColor(Color.green.darker().darker());
        secondLayer.setFillColor(Color.green.darker().darker());
        this.add(secondLayer);

        thirdLayer = new Rectangle(15, 29, 30, TREE_HEIGHT / 8);
        thirdLayer.setStrokeColor(Color.green.darker().darker());
        thirdLayer.setFillColor(Color.green.darker().darker());
        this.add(thirdLayer);

        fourthLayer = new Rectangle(20, 21, 20, TREE_HEIGHT / 8);
        fourthLayer.setStrokeColor(Color.green.darker().darker());
        fourthLayer.setFillColor(Color.green.darker().darker());
        this.add(fourthLayer);

        top = new Rectangle(26, 13, 8, TREE_HEIGHT / 8);
        top.setStrokeColor(Color.green.darker().darker());
        top.setFillColor(Color.green.darker().darker());
        this.add(top);
    
        }
    
        public void addToCanvas(CanvasWindow canvas) {
            canvas.add(this);
        }
    
    }
    


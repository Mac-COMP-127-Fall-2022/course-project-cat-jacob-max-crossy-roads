package CrossyRoad;

import edu.macalester.graphics.Rectangle;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;

public class PineTree extends GraphicsGroup{

        private static final double TREE_WIDTH = 60;
        private static final double TREE_HEIGHT = 60;
        private Rectangle treeBase;
        private Rectangle bottomLayer;
        private Rectangle secondLayer;
        private Rectangle thirdLayer;
        private Rectangle fourthLayer;

        
         //private Rectangle size;
    
    
        public PineTree(double x, double y) {
            super(x,y);
            buildTree();
        }
    
        private void buildTree() {
            // to test proportions:
            //size = new Rectangle(0,0,TREE_WIDTH, TREE_HEIGHT);
            //treeGroup.add(size);
    
            treeBase = new Rectangle(25, 45, TREE_WIDTH /6, TREE_HEIGHT / 4);
            treeBase.setStrokeColor(Color.BLACK);
            treeBase.setFillColor(Color.BLACK);
            this.add(treeBase);

            bottomLayer = new Rectangle(0, 45, TREE_WIDTH , TREE_HEIGHT / 8);
            bottomLayer.setStrokeColor(Color.green);
            bottomLayer.setFillColor(Color.green);
            this.add(bottomLayer);

            secondLayer = new Rectangle(10, 53, TREE_WIDTH / 2, TREE_HEIGHT / 8);
            secondLayer.setStrokeColor(Color.green.darker());
            secondLayer.setFillColor(Color.green.darker());
            this.add(secondLayer);

            thirdLayer = new Rectangle(15, 60, TREE_WIDTH / 3, TREE_HEIGHT / 8);
            thirdLayer.setStrokeColor(Color.green.darker());
            thirdLayer.setFillColor(Color.green.darker());
            this.add(thirdLayer);

            fourthLayer = new Rectangle(20, 68, TREE_WIDTH / 4, TREE_HEIGHT / 8);
            fourthLayer.setStrokeColor(Color.green.darker());
            fourthLayer.setFillColor(Color.green.darker());
            this.add(fourthLayer);
    
        }
    
    
        public void addToCanvas(CanvasWindow canvas) {
            canvas.add(this);
        }
    
    }
    


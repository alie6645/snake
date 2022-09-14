package snake;

import java.awt.*;
import java.awt.geom.Point2D;

public class Part {
    int x;
    int y;
    double xChange;
    double yChange;
    int target = 2;
    int diameter = 30;

    public Part(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Part(int x, int y, int target) {
        this.x = x;
        this.y = y;
        this.target = target;
    }

    public void shift() {
        xChange = 0;
        yChange = 0;
        switch (target) {
            case 0 -> xChange = -5;
            case 1 -> yChange = -5;
            case 2 -> xChange = 5;
            case 3 -> yChange = 5;
        }

        x += xChange;
        y += yChange;
    }

    public void stop(){
        xChange = 0;
        yChange = 0;
        target = 9;
    }

    public boolean getChange(){
        return x % diameter == 0 && y % diameter == 0;
    }

    public boolean intersect(Part part){
        int b = part.diameter;
        int xCheck = 15;
        int yCheck = 15;
        if (xChange > 0) {
            xCheck = diameter + 5;
        } else if (xChange < 0){
            xCheck = -5;
        }
        if (yChange > 0){
            yCheck = diameter + 5;
        } else if (yChange < 0){
            yCheck = -5;
        }
        if (x+xCheck < part.x+b && x+xCheck > part.x) {
            if (y+yCheck < part.y + b && y+yCheck > part.y) {
                return true;
            }
        }
        return false;
    }

    public boolean intersect(int x, int y, int diameter){
        int xCheck = 15;
        int yCheck = 15;
        if (xChange > 0) {
            xCheck = diameter + 5;
        } else if (xChange < 0){
            xCheck = -5;
        }
        if (yChange > 0){
            yCheck = diameter + 5;
        } else if (yChange < 0){
            yCheck = -5;
        }
        if (this.x+xCheck < x+ diameter && this.x+xCheck > x) {
            if (this.y+yCheck < y+ diameter && this.y+yCheck > y) {
                return true;
            }
        }
        return false;
    }

    public int[] getCoordinates(){
        return new int[]{x / diameter, y / diameter};
    }

    public void draw(Graphics2D g2){

        int xCheck = 15;
        int yCheck = 15;
        if (xChange > 0) {
            xCheck = diameter + 5;
        } else if (xChange < 0){
            xCheck = -5;
        }
        if (yChange > 0){
            yCheck = diameter + 5;
        } else if (yChange < 0){
            yCheck = -5;
        }
        g2.drawLine(x+15,y+15,x+xCheck,y+yCheck);
    }
}

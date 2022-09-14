package snake;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class SnakePanel extends JComponent {
    int xCollect;
    int yCollect;
    int target = 2;
    Part[] parts = new Part[20];
    boolean [][] map = new boolean[10][10];
    int index = 2;
    int diameter = 30;

    public SnakePanel(){
        parts[0] = new Part(180,0);
        parts[1] = new Part(150,0);
        grow();

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        parts[0].draw(g2);
        new Grid(300,300,10,10).draw(g2);

        g2.setColor(Color.green);
        for (int i=0; i<index; i++){
            draw(parts[i],g2);
        }

        g2.setColor(Color.red);
        g2.fillOval(xCollect,yCollect,diameter,diameter);



    }




    public void shift() {
        for (int i=0; i<index; i++){
            parts[i].shift();
        }
        if (parts[0].getChange()){
            for (int i=index-2; i>=0; i--){
                parts[i+1].target = parts[i].target;
            }
            if(Math.abs(parts[0].target - target) != 2) { // prevents snake from turning back into itself
                parts[0].target = target;
            }
        }
        if (collision()){
            reset();
        }
        if (collect()){
            grow();
        }
        repaint();
    }

    // gives lose conditions
    public boolean collision(){
        for (int i=1; i<index; i++){
            if (parts[0].intersect(parts[i])){
                return true;
            }
        }
        if (parts[0].x<0 || parts[0].y<0){
            return true;
        }
        if (parts[0].x>290 || parts[0].y>290){
            return true;
        }
        return false;
    }

    public boolean collect(){
        return parts[0].intersect(xCollect,yCollect,diameter);
    }

    //adding a segment to snake
    public void grow(){
        for (int i=0; i<index; i++){
            try {
                int xCoord = parts[i].getCoordinates()[0];
                int yCoord = parts[i].getCoordinates()[1];
                map[xCoord][yCoord] = true;
            } catch (ArrayIndexOutOfBoundsException e) {

            }
        }

        int rand = (int) (Math.random()*(100-index));
        for (int i=0; i<10; i++){ // i is y, j is x
            for (int j=0; j<10; j++){
                if (!map[j][i]){
                    rand -= 1;
                }
                if (rand == 0){
                    xCollect = j*diameter;
                    yCollect = i*diameter;
                }
            }
        }
        int xAdjust = 0;
        int yAdjust = 0;
        Part last = parts[index-1];
        switch (last.target) {
            case 0 -> xAdjust = diameter;
            case 1 -> yAdjust = diameter;
            case 2 -> xAdjust = -diameter;
            case 3 -> yAdjust = -diameter;
        }
        parts[index] = new Part(last.x + xAdjust, last.y + yAdjust, last.target);
        index += 1;

    }

    //called upon lose
    public void reset(){
        Arrays.fill(parts, null);
        target = 9;
        index = 1;
        parts[0] = new Part(180,60);
        parts[0].stop();
    }

    public void setTarget(int target){
        this.target = target;
    }

    public void draw(Part part, Graphics2D g2){
        g2.fillOval(part.x, part.y, part.diameter, part.diameter);
    }
}


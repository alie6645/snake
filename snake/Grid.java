package snake;

import javax.swing.*;
import java.awt.*;

public class Grid extends JComponent {
    int height;
    int width;
    int rows;
    int cols;

    public Grid(int height, int width, int rows, int cols) {
        this.height = height;
        this.width = width;
        this.rows = rows;
        this.cols = cols;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for (int i=0; i<width; i+=width/cols){
            g2.drawLine(i,0,i,height);
        }
        for (int i=0; i<height; i+=height/rows){
            g2.drawLine(0,i,width,i);
        }

    }

    public void draw(Graphics2D g2){
        for (int i=0; i<width; i+=width/cols){
            g2.drawLine(i,0,i,height);
        }
        for (int i=0; i<height; i+=height/rows){
            g2.drawLine(0,i,width,i);
        }
    }
}

package snake;

import javax.swing.*;
import java.awt.*;

public class MainFrame {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(320,340));
        SnakePanel move = new SnakePanel();;
        frame.setVisible(true);
        frame.addKeyListener(new SnakeKeys(move));
        frame.add(move);
        frame.revalidate();
        Timer timer = new Timer(15, e -> {
            move.shift();

        });
        timer.start();


    }
}
package snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeKeys extends KeyAdapter {
    SnakePanel move;
    public SnakeKeys(SnakePanel move){
        this.move = move;
    }

    @Override
    public void keyPressed(KeyEvent e) {
            move.setTarget(e.getKeyCode() - 37);
    }


    @Override
    public void keyReleased(KeyEvent e) {
    }
}
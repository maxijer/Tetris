package design;

import model.Coords;
import model.Figure;
import service.FlyFigure;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JFrame implements Runnable {

    private Block[][] blocks;
    private FlyFigure fly;

    public Window() {
        blocks = new Block[Config.WIDTH][Config.HEIGHT];
        FormInit();
        BoxesInit();
        addKeyListener(new KeyAdapter());
    }

    public void showShape() {
        showShape(1);
    }

    public void hideShape() {
        showShape(0);
    }

    public void add_new_figure() {
        fly = new FlyFigure();
        showShape();
    }



    class KeyAdapter implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            int ection = e.getKeyCode();
            hideShape();
            if (KeyEvent.VK_LEFT == ection) {
                fly.moveShape(-1, 0);
            } else if (KeyEvent.VK_RIGHT == ection) {
                fly.moveShape(+1, 0);
            } else if (KeyEvent.VK_DOWN == ection) {
                fly.moveShape(0, +1);
            } else if (KeyEvent.VK_SPACE == ection) {
                fly.go_shape();
            }
            showShape();
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    private void FormInit() {
        setSize(Config.WIDTH * Config.SIZE + 15, Config.HEIGHT * Config.SIZE + 39);
        setTitle("Tetris");
        setLocationRelativeTo(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void BoxesInit() {
        for (int x = 0; x < Config.WIDTH; x++) {
            for (int y = 0; y < Config.HEIGHT; y++) {
                blocks[x][y] = new Block(x, y);
                add(blocks[x][y]);
            }
        }
    }

    public void run() {
        repaint();
    }

    public void setBoxColor(int x, int y, int color) {
        if (y < 0 || y >= Config.HEIGHT) {
            return;
        }
        if (x < 0 || x >= Config.WIDTH) {
            return;
        }
        blocks[x][y].setColor(color);
    }

    public void showShape(int color) { // color = 0 - скрытие фигуры, color = 1- отображение фигуры
        for (Coords coord : fly.get_shape().list_of_coords) {
            setBoxColor(coord.x + fly.get_coords().x, coord.y + fly.get_coords().y, color);
        }
    }
}

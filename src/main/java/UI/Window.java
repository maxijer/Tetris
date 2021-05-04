package UI;

import model.Coord;
import model.Figure;

import javax.swing.*;

public class Window extends JFrame implements Runnable {

    private Block[][] boxes;

    public Window() {
        boxes = new Block[Config.WIDTH][Config.HEIGHT];
        FormInit();
        BoxesInit();
    }

    public void run() {
        repaint();
    }

    private void FormInit() {
        setSize(Config.WIDTH * Config.SIZE + 15, Config.HEIGHT * Config.SIZE + 30);
        setTitle("Tetris");
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void BoxesInit() {
        for (int x = 0; x < Config.WIDTH; x++) {
            for (int y = 0; y < Config.HEIGHT; y++) {
                boxes[x][y] = new Block(x, y);
                add(boxes[x][y]);
            }
        }
    }

    public void setBoxColor(int x, int y, int color) {
        if (x < 0 || x >= Config.WIDTH) {
            return;
        }
        if (y < 0 || y >= Config.HEIGHT) {
            return;
        }
        boxes[x][y].setColor(color);
    }

    public void showShape(Figure figure, Coord at) {
        for (Coord dot : figure.dot) {
            setBoxColor(dot.x + at.x, dot.y + at.y, 1);
        }
    }
}

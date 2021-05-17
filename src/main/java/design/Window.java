package design;

import model.Coords;
import model.Figure;

import javax.swing.*;

public class Window extends JFrame implements Runnable {

    private Block[][] blocks;

    public Window() {
        blocks = new Block[Config.WIDTH][Config.HEIGHT];
        FormInit();
        BoxesInit();
    }

    private void FormInit() {
        setSize(Config.WIDTH * Config.SIZE + 15, Config.HEIGHT * Config.SIZE + 30);
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

    public void showShape(Figure figure, Coords pos) {
        for (Coords coord : figure.list_of_coords) {
            setBoxColor(coord.x + pos.x, coord.y + pos.y, 1);
        }
    }
}

package design;

import model.Coords;
import model.Figure;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JFrame implements Runnable {

    private Block[][] blocks;
    private Figure active_figure;
    private Coords coords_active_figure;

    public Window() {
        blocks = new Block[Config.WIDTH][Config.HEIGHT];
        FormInit();
        BoxesInit();
        addKeyListener(new KeyAdapter());
    }

    public void showShape() {
        showShape(active_figure, coords_active_figure, 1);
    }

    public void hideShape() {
        showShape(active_figure, coords_active_figure, 0);
    }

    public void add_new_figure() {
        active_figure = Figure.get_random_figure();
        coords_active_figure = new Coords(5, 5);
        showShape(active_figure, coords_active_figure, 1);
    }

    public boolean CanMoveShape(Figure figure, int sx, int sy) {
        int left = coords_active_figure.x + sx + figure.top.x;
        if (left < 0) {
            return false;
        }
        int right = coords_active_figure.x + sx + figure.bottom.x;
        if (right >= Config.WIDTH) {
            return false;
        }
        if (coords_active_figure.y + sy + figure.top.y < 0) {
            return false;
        }
        if (coords_active_figure.y + sy + figure.bottom.y >= Config.HEIGHT) {
            return false;
        }
        return true;
    }

    public void moveShape(int sx, int sy) {
        if (CanMoveShape(active_figure, sx, sy)) {
            coords_active_figure = coords_active_figure.dobav(sx, sy);
        }
    }

    public void go_shape() {
        Figure rotate = active_figure.go_right();
        if (!CanMoveShape(rotate, 0, 0)) {
            return;
        }
        active_figure = rotate;
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
                moveShape(-1, 0);
            } else if (KeyEvent.VK_RIGHT == ection) {
                moveShape(+1, 0);
            } else if (KeyEvent.VK_DOWN == ection) {
                moveShape(0, +1);
            } else if (KeyEvent.VK_SPACE == ection) {
                go_shape();
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

    public void showShape(Figure figure, Coords pos, int color) { // color = 0 - скрытие фигуры, color = 1- отображение фигуры
        for (Coords coord : figure.list_of_coords) {
            setBoxColor(coord.x + pos.x, coord.y + pos.y, color);
        }
    }
}

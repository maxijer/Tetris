package design;

import model.Coords;
import model.Mapable;
import service.FlyFigure;

import javax.swing.*;
import java.awt.event.*;

public class Window extends JFrame implements Runnable, Mapable {
    private Block[][] blocks;
    private FlyFigure fly;

    public Window() {
        blocks = new Block[Config.WIDTH][Config.HEIGHT];
        FormInit();
        BoxesInit();
        addKeyListener(new KeyAdapter());
        TimeAdapter time_adapter = new TimeAdapter();
        Timer timer = new Timer(100, time_adapter);
        timer.start();
    }

    @Override
    public int getBoxColor(int x, int y) {
        if (y < 0 || y >= Config.HEIGHT) {
            return -1;
        }
        if (x < 0 || x >= Config.WIDTH) {
            return -1;
        }
        return blocks[x][y].getColor();
    }

    private boolean is_full_line(int y) {
        for (int x = 0; x < Config.WIDTH; x++) {
            if (getBoxColor(x, y) != 2) {
                return false;
            }
        }
        return true;
    }

    private void dropLine(int y) {
        for (int my = y - 1; my >= 0; my--) {
            for (int x = 0; x < Config.WIDTH; x++) {
                setBoxColor(x, my + 1, getBoxColor(x, my));
            }
        }
        for (int x = 0; x < Config.WIDTH; x++) {
            setBoxColor(x, 0, 0);
        }
    }

    private void stripLines() {
        for (int y = Config.HEIGHT - 1; y >= 0; y--) {
            while (is_full_line(y)) {
                dropLine(y);
            }
        }
    }

    class TimeAdapter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            moveFly(0, 1);
            if (fly.fall) {
                showShape(2);
                stripLines();
                add_new_figure();
                for (int i = 0; i < Config.WIDTH; i++) {
                    for (int j = 0; j < Config.HEIGHT; j++) {
                        System.out.print(blocks[i][j].getColor() + " ");
                    }
                    System.out.println();
                }
                System.out.println("-------------");
            }
        }
    }

    public void showShape() {
        showShape(1);
    }

    public void hideShape() {
        showShape(0);
    }

    public void add_new_figure() {
        fly = new FlyFigure(this);
        showShape();
    }

    private void go_fly(int direction) {
        hideShape();
        fly.go_shape(direction);
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
                moveFly(-1, 0);
            } else if (KeyEvent.VK_RIGHT == ection) {
                moveFly(+1, 0);
            } else if (KeyEvent.VK_UP == ection) {
                fly.go_shape(1);
            } else if (KeyEvent.VK_DOWN == ection) {
                fly.go_shape(2);
            }
            showShape();
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    private void moveFly(int sx, int sy) {
        hideShape();
        fly.moveShape(sx, sy);
        showShape();
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
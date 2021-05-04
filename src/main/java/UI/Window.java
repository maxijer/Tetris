package UI;

import javax.swing.*;

public class Window extends JFrame {

    public Window() {
        FormInit();
    }

    private void FormInit() {
        setSize(Config.WIDTH * Config.SIZE + 15, Config.HEIGHT * Config.SIZE + 30);
        setTitle("Tetris");
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}

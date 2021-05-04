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
        BoxesInit();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void BoxesInit()
    {
        for (int x = 0; x < Config.WIDTH; x ++)
        {
            for (int y = 0; y < Config.HEIGHT; y ++)
            {
                Block block = new Block(x, y);
                add(block);
            }
        }
    }

}

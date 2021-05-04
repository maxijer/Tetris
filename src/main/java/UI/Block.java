package UI;

import javax.swing.*;

public class Block extends JPanel {
    public Block(int x, int y)
    {
        setBounds(Config.WIDTH, Config.HEIGHT, x * Config.SIZE, y * Config.SIZE);
        setBackground(Config.background);
        setVisible(true);
        setBackground(Config.background);
    }
}

package UI;

import javax.swing.*;

public class Block extends JPanel {
    public Block(int x, int y) {
        setBounds(Config.WIDTH, Config.HEIGHT, x * Config.SIZE, y * Config.SIZE);
        setBackground(Config.background);
        setVisible(true);
        setLayout(null);
        setBackground(Config.background);
    }

    public void setColor(int i) {
        if (i == 0) {
            setBackground(Config.background);
        } else {
            setBackground(Config.FORE);
        }
    }
}

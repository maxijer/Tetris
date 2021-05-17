package design;

import javax.swing.*;

public class Block extends JPanel {
    public Block(int x, int y) {
        setBounds(x * Config.SIZE, y * Config.SIZE, Config.SIZE, Config.SIZE);
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

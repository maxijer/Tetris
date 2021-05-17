package design;

import javax.swing.*;

public class Block extends JPanel {
    private int color;

    public int getColor()
    {
        return color;
    }

    public Block(int x, int y) {
        color = 0;
        setBounds(x * Config.SIZE, y * Config.SIZE, Config.SIZE, Config.SIZE);
        setVisible(true);
        setLayout(null);
        setBackground(Config.background);
    }

    public void setColor(int i) {
        this.color = i;
        if (color >= 0 && color < Config.colors.length) {
            setBackground(Config.colors[color]);
        }
    }
}

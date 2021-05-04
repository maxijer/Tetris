import UI.Window;
import model.Coord;
import model.Figure;

import javax.swing.*;

import static model.Figure.Z1;

public class Tetris {
    public static void main(String[] args) {
        Window wind = new Window();
        SwingUtilities.invokeLater(wind);
        wind.showShape(Figure.Z2, new Coord(150, 5));
    }
}

import design.Window;
import model.Coords;
import model.Figure;

import javax.swing.*;

import static model.Figure.Z1;

public class Tetris {
    public static void main(String[] args) {
        Window wind = new Window();
        javax.swing.SwingUtilities.invokeLater(wind);
        wind.showShape(Figure.Z1, new Coords(5, 5));
    }
}

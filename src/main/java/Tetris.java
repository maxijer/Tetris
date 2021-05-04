import UI.Window;
import model.Coord;
import model.Figure;

import static model.Figure.Z1;

public class Tetris {
    public static void main(String[] args) {
        Window wind = new Window();
        wind.showShape(Figure.L2, new Coord(5, 5));
    }
}

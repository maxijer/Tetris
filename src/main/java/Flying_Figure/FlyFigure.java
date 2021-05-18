package Flying_Figure;

import design.Config;
import model.Coords;
import model.Coords_and_colors;
import model.Figure;
import model.Coords_and_colors;

public class FlyFigure {
    private Figure active_figure;
    private int ticks;
    private Coords coords_active_figure;
    Coords_and_colors map;
    public boolean fall;

    public Figure get_shape() {
        return active_figure;
    }

    public Coords get_coords() {
        return coords_active_figure;
    }

    public FlyFigure(Coords_and_colors map) {
        this.map = map;
        active_figure = Figure.get_random_figure();
        coords_active_figure = new Coords(Config.WIDTH / 2 - 2, -active_figure.top.y + 2);
        fall = false;
        ticks = 2;
    }

    public boolean CanMoveShape(Figure figure, int sx, int sy) {
        int left = coords_active_figure.x + sx + figure.top.x;
        if (left < 0) {
            return false;
        }
        int right = coords_active_figure.x + sx + figure.bottom.x;
        if (right >= Config.WIDTH) {
            return false;
        }
        if (coords_active_figure.y + sy + figure.top.y < 0) {
            return false;
        }
        if (coords_active_figure.y + sy + figure.bottom.y >= Config.HEIGHT) {
            return false;
        }
        for (Coords coords : figure.list_of_coords) {
            if (map.getBoxColor(coords.x + sx + coords_active_figure.x, coords.y + sy + coords_active_figure.y) != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean canPlaceShape()
    {
        return CanMoveShape(active_figure, 0, 0);
    }


    public void moveShape(int sx, int sy) {
        if (CanMoveShape(active_figure, sx, sy)) {
            coords_active_figure = coords_active_figure.dobav(sx, sy);
        } else if (sy == 1) {
            if (ticks > 0) {
                ticks--;
            } else {
                fall = true;
            }
        }
    }

    public void go_shape(int direction) {
        Figure rotate;
        if (direction == 1) {
            rotate = active_figure.go_right();
        } else {
            rotate = active_figure.go_left();
        }
        if (!CanMoveShape(rotate, 0, 0)) {
            return;
        }
        active_figure = rotate;
    }
}

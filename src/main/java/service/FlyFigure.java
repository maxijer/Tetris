package service;

import design.Config;
import model.Coords;
import model.Figure;

public class FlyFigure {
    private Figure active_figure;
    private Coords coords_active_figure;

    public Figure get_shape() {
        return active_figure;
    }

    public Coords get_coords() {
        return coords_active_figure;
    }

    public FlyFigure() {
        active_figure = Figure.get_random_figure();
        coords_active_figure = new Coords(Config.WIDTH / 2 - 2, -active_figure.top.y + 2);
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
        return true;
    }

    public void moveShape(int sx, int sy) {
        if (CanMoveShape(active_figure, sx, sy)) {
            coords_active_figure = coords_active_figure.dobav(sx, sy);
        }
    }

    public void go_shape() {
        Figure rotate = active_figure.go_right();
        if (!CanMoveShape(rotate, 0, 0)) {
            return;
        }
        active_figure = rotate;
    }
}

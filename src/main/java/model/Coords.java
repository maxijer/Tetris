package model;

public class Coords { // класс отвечающий за координаты, он предельно просто, храним x и y
    public int x, y;

    public Coords(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Coords dobav(int sx, int sy) {
        return new Coords(x + sx, y + sy);
    }
}

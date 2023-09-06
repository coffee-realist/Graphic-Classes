package lab1.graphics;

public class Dot extends GeometryFigure {
    private int x, y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move(int delta_x, int delta_y) {
        setX(getX() + delta_x);
        setY(getY() + delta_y);
    }

    @Override
    public String toString() {
        return String.format("Точка (%d; %d).", getX(), getY());
    }
}

package lab1.graphics;

public class Dot extends Drawable {
        private double x, y;

    public Dot(double x, double y) {
        check(x, y);
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void move(double delta_x, double delta_y) {
        setX(getX() + delta_x);
        setY(getY() + delta_y);
    }

    public void check(double x1, double y1) {
        if (x1 < 0 || y1 < 0)
            throw new RuntimeException("Координаты не могут быть отрицательными. Пожалуйста задайте другие координаты");
    }
    @Override
    public String toString() {
        return String.format("Точка (%f; %f).", getX(), getY());
    }

    @Override
    public void draw() {}
}

package lab1.graphics;

public class Dot extends Drawable {
        private double x, y;

    public Dot(double x, double y) {
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

    @Override
    public String toString() {
        return String.format("Точка (%f; %f).", getX(), getY());
    }

    @Override
    public void draw() {}
}

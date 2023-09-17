package lab1.graphics;

import java.lang.Math;

public class Ellipse extends Figure {
    private double small_radius, big_radius;
    private final double rotation;
    private double square;
    private Dot center;

    public Ellipse(Dot center, double small_radius, double big_radius, double rotation) {
        check(center, small_radius, big_radius);
        this.small_radius = small_radius;
        this.big_radius = big_radius;
        this.center = center;
        if (rotation < 0)
            rotation += 360;
        this.rotation = rotation;
        calculateSquare();
    }

    public Dot getCenter() {
        return center;
    }

    public double getSmall_radius() {
        return small_radius;
    }

    public double getBig_radius() {
        return big_radius;
    }

    public double getRotation() {
        return rotation;
    }

    public void setCenter(Dot center) {
        this.center = center;
    }

    public void setSmall_radius(double small_radius) {
        this.small_radius = small_radius;
    }

    public void setBig_radius(double big_radius) {
        this.big_radius = big_radius;
    }

    @Override
    public void calculateSquare() {
        setSquare(Math.PI * small_radius * big_radius);
    }

    @Override
    public void expandTo(double multiplier) {
        setSmall_radius(getSmall_radius() * multiplier);
        setBig_radius(getBig_radius() * multiplier);
        calculateSquare();
    }

    @Override
    public void move(double delta_x, double delta_y) {
        center.move(delta_x, delta_y);
    }

    public void check(Dot c, double r1, double r2) {
        if (c.getX() < 0 || c.getY() < 0 || r1 < 0 || r2 < 0)
            throw new RuntimeException("Координаты и полуоси не могут быть отрицательными. " +
                    "Пожалуйста задайте другие координаты или полуоси");
    }

    @Override
    public String toString() {
        return String.format("""
                Класс Эллипса.
                Координаты центра: %s
                Малая полуось: %f.
                Большая полуось: %f.
                Угол поворота: %f,
                Площадь: %f""", getCenter().toString(), getSmall_radius(), getBig_radius(), getRotation(), getSquare());
    }

    @Override
    public void draw() {
    }
}


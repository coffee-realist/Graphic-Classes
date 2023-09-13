package lab1.graphics;

import java.lang.Math;

public class Ellipse extends Figure {
    private double small_radius, big_radius;
    private final double rotation;
    private double square;
    private Dot center;

    public Ellipse(Dot center, double small_radius, double big_radius, double rotation) {
        this.small_radius = small_radius;
        this.big_radius = big_radius;
        this.center = center;
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
        Dot current_center = getCenter();
        setCenter(new Dot(current_center.getX() + delta_x, current_center.getY() + delta_y));
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


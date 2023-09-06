package lab1.graphics;

import java.lang.Math;

public class Ellipse extends Figure {
    private final int small_radius;
    private final int big_radius;
    private final int rotate_angle;
    private double square;
    private Dot center;

    public Ellipse(Dot center, int small_radius, int big_radius, int rotate_angle) {
        this.small_radius = small_radius;
        this.big_radius = big_radius;
        this.center = center;
        this.rotate_angle = rotate_angle;
        calculateSquare();
    }

    public Dot getCenter() {
        return center;
    }

    public int getSmall_radius() {
        return small_radius;
    }

    public int getBig_radius() {
        return big_radius;
    }

    public int getRotate_angle() {
        return rotate_angle;
    }

    public void setCenter(Dot center) {
        this.center = center;
    }

    @Override
    public void calculateSquare() {
        setSquare(Math.PI * small_radius * big_radius);
    }

    public void move(int delta_x, int delta_y) {
        Dot current_center = getCenter();
        setCenter(new Dot(current_center.getX() + delta_x, current_center.getY() + delta_y));
    }

    @Override
    public void expandTo() {

    }

    @Override
    public String toString() {
        return String.format("""
                Класс Эллипса.
                Координаты центра: %s
                Малая полуось: %d.
                Большая полуось: %d.
                Угол поворота: %d,
                Площадь: %f""", getCenter().toString(), getSmall_radius(), getBig_radius(), getRotate_angle(), getSquare());
    }

    @Override
    public void draw() {
    }
}


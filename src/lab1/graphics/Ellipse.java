package lab1.graphics;

import java.lang.Math;

public class Ellipse extends Figure {
    private final double small_radius;
    private final double big_radius;
    private final double rotation;
    private final Dot center;

    public Ellipse(Dot center, double small_radius, double big_radius, double rotation) {
        check(center, small_radius, big_radius);
        this.small_radius = small_radius;
        this.big_radius = big_radius;
        this.center = center;
        if (rotation < 0)
            rotation += 360;
        this.rotation = rotation;
        square = new Lazy<>(this::calculateSquare);
    }

    protected double calculateSquare() {
        return (Math.PI * small_radius * big_radius);
    }

    @Override
    public Ellipse expandTo(double multiplier) {
        return new Ellipse(center, small_radius*multiplier, big_radius*multiplier, rotation);
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

    public Ellipse getCircumscribedCircle() {
        return new Ellipse(center, big_radius, big_radius, rotation);
    }

    @Override
    public String toString() {
        return String.format("""
                Эллипс.
                Координаты центра: %sМалая полуось: %f.
                Большая полуось: %f.
                Угол поворота: %f,
                Площадь: %f
                                
                """, center.toString(), small_radius, big_radius, rotation, getSquare());
    }

    @Override
    public void draw() {
    }
}


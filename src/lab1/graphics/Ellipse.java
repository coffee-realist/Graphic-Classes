package lab1.graphics;

import lab1.RoundAboutAvailable;

import java.lang.Math;

public class Ellipse extends Figure implements RoundAboutAvailable {
    private final double small_radius;
    private final double big_radius;
    private final double rotation;
    private final Dot center;

    public Ellipse(Dot center, double small_radius, double big_radius, double rotation) {
        super(() -> Math.PI * small_radius * big_radius);
        check(small_radius, big_radius);
        this.small_radius = small_radius;
        this.big_radius = big_radius;
        this.center = center;
        if (rotation < 0)
            rotation += 360;
        this.rotation = rotation;
    }

    @Override
    public Ellipse expandTo(double multiplier) {
        return new Ellipse(center, small_radius * multiplier, big_radius * multiplier, rotation);
    }

    @Override
    public Ellipse move(double delta_x, double delta_y) {
        return new Ellipse(center.move(delta_x, delta_y), small_radius, big_radius, rotation);
    }

    private void check(double r1, double r2) {
        if (r1 < 0 || r2 < 0)
            throw new RuntimeException("Полуоси не могут быть отрицательными. " +
                    "Пожалуйста задайте другие значения полуосей");
    }

    public Ellipse getRoundAbout() {
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
                                
                """, center, small_radius, big_radius, rotation, getSquare());
    }

    @Override
    public void draw() {
    }
}


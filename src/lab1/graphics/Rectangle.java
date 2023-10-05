package lab1.graphics;

import lab1.RoundAboutAvailable;

import java.lang.Math;

public class Rectangle extends Figure implements RoundAboutAvailable {
    private final Dot dot1;
    private final Dot dot2;
    private final Dot dot3;
    private final Dot dot4;
    private final double rotation;
    private final double diagonal;
    private final Dot center;

    public Rectangle(Dot dot1, Dot dot2, Dot dot3, Dot dot4) {
        super(() -> dot2.length(dot1) * dot4.length(dot1));
        double width = dot2.length(dot1);
        double height = dot4.length(dot1);
        check(dot1, dot2, dot3, dot4, width, height);
        this.dot1 = dot1;
        this.dot2 = dot2;
        this.dot3 = dot3;
        this.dot4 = dot4;
        double rotation = -Math.acos((dot4.minus(dot1).scalarProduct(new Dot(1, 0)) / width));
        if (rotation < 0)
            rotation += 360;
        this.rotation = rotation;
        this.center = dot3.minus(dot1).product(0.5).plus(dot1);
        this.diagonal = dot3.length(dot1);
    }

    private boolean isEqual(double a, double b) {
        return Math.abs(a - b) < 1e-5;
    }

    private void check(Dot d1, Dot d2, Dot d3, Dot d4, double width, double height) {
        if ((!(isEqual(d1.length(d2), d3.length(d4)) && isEqual(d2.length(d3), d1.length(d4)))) ||
                isEqual(width, 0) || isEqual(height, 0)|| !(isEqual(d2.minus(d1).scalarProduct(d4.minus(d1)), 0)))
            throw new RuntimeException("Это не прямоугольник. Пожалуйста задайте другие координаты");
    }

    @Override
    public Rectangle move(double delta_x, double delta_y) {
        return new Rectangle(dot1.move(delta_x, delta_y), dot2.move(delta_x, delta_y),
                dot3.move(delta_x, delta_y), dot4.move(delta_x, delta_y));
    }

    public Ellipse getRoundAbout() {
        return new Ellipse(center, diagonal * 0.5, diagonal * 0.5, rotation);
    }

    @Override
    public Rectangle expandTo(double multiplier) {
        return new Rectangle(dot1.minus(center).product(multiplier),
                dot2.minus(center).product(multiplier),
                dot3.minus(center).product(multiplier),
                dot4.minus(center).product(multiplier));
    }

    @Override
    public String toString() {
        return String.format("""
                Прямоугольник.
                Координаты точек:
                %s%s%s%sПлощадь: %f
                """, dot1, dot2, dot3, dot4, getSquare());
    }

    @Override
    public void draw() {
    }
}

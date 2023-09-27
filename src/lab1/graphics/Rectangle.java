package lab1.graphics;

import java.lang.Math;

public class Rectangle extends Figure {
    private final Dot dot1;
    private final Dot dot2;
    private final Dot dot3;
    private final Dot dot4;
    private final double rotation;
    private final double width;
    private final double height;
    private final double diagonal;
    private final Dot center;

    public Rectangle(Dot dot1, Dot dot2, Dot dot3, Dot dot4) {
        double width = Math.sqrt(Math.pow(dot1.getX() - dot4.getX(), 2) + Math.pow(dot1.getY() - dot4.getY(), 2));
        double height = Math.sqrt(Math.pow(dot1.getX() - dot2.getX(), 2) + Math.pow(dot1.getY() - dot4.getY(), 2));
        check(dot1, dot2, dot3, dot4, width, height);
        this.dot1 = dot1;
        this.dot2 = dot2;
        this.dot3 = dot3;
        this.dot4 = dot4;
        this.width = width;
        this.height = height;
        double rotation = -Math.acos((dot4.getX() - dot1.getX()) / width);
        if (rotation < 0)
            rotation += 360;
        this.rotation = rotation;
        this.center = new Dot((dot3.getX() - dot1.getX()) / 2 + dot1.getX(),
                (dot3.getY() - dot1.getY()) / 2 + dot1.getY());
        this.diagonal = Math.sqrt(Math.pow(dot3.getX() - dot1.getX(), 2) + Math.pow(dot3.getY() - dot1.getY(), 2));
        square = new Lazy<>(this::calculateSquare);
    }

    @Override
    public double calculateSquare() {
        return height * width;
    }

    public void check(Dot d1, Dot d2, Dot d3, Dot d4, double width, double height) {
        if (d1.getX() < 0 || d1.getY() < 0 || d2.getX() < 0 || d2.getY() < 0 ||
                d3.getX() < 0 || d3.getY() < 0 || d4.getX() < 0 || d4.getY() < 0)
            throw new RuntimeException("Координаты не могут быть отрицательными. Пожалуйста задайте другие координаты");
        if ((!(d2.getX() - d1.getX() == d3.getX() - d4.getX() &&
                d2.getY() - d1.getY() == d3.getY() - d4.getY() &&
                d3.getX() - d2.getX() == d4.getX() - d1.getX() &&
                d3.getY() - d2.getY() == d4.getY() - d1.getY())) ||
                (width == 0) || (height == 0))
            throw new RuntimeException("Это не прямоугольник. Пожалуйста задайте другие координаты");
    }

    @Override
    public void move(double delta_x, double delta_y) {
        dot1.move(delta_x, delta_y);
        dot2.move(delta_x, delta_y);
        dot3.move(delta_x, delta_y);
        dot4.move(delta_x, delta_y);
    }

    public Ellipse getCircumscribedCircle() {
        return new Ellipse(center, diagonal * 0.5, diagonal * 0.5, rotation);
    }

    @Override
    public Rectangle expandTo(double multiplier) {
        return new Rectangle(new Dot((dot1.getX() - center.getX()) * multiplier,
                (dot1.getY() - center.getY()) * multiplier),
                new Dot((dot2.getX() - center.getX()) * multiplier,
                (dot2.getY() - center.getY()) * multiplier),
                new Dot((dot3.getX() - center.getX()) * multiplier,
                (dot3.getY() - center.getY()) * multiplier),
                new Dot((dot4.getX() - center.getX()) * multiplier,
                (dot4.getY() - center.getY()) * multiplier));
    }

    @Override
    public String toString() {
        return String.format("""
                        Прямоугольник.
                        Координаты точек:
                        %s%s%s%sПлощадь: %f
                        """, dot1.toString(), dot2.toString(),
                dot3.toString(), dot4.toString(), getSquare());
    }

    @Override
    public void draw() {
    }
}
